package com.example.clase4multiplestablas.controller;

import com.example.clase4multiplestablas.entity.Product;
import com.example.clase4multiplestablas.repository.CategoryRepository;
import com.example.clase4multiplestablas.repository.ProductRepository;
import com.example.clase4multiplestablas.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping(value = {"", "/"})
    public String listaProductos(Model model) {
        model.addAttribute("listaProductos", productRepository.findAll());
        return "product/list";
    }

    @GetMapping("/new")
    public String nuevoProductoFrm(Model model) {
        model.addAttribute("listaCategory", categoryRepository.findAll());
        model.addAttribute("listaSupplier", supplierRepository.findAll());
        return "product/newFrm";
    }

    @PostMapping("/save")
    public String guardarProducto(Product product, Model model, RedirectAttributes attr) {
        if (product.getId() == 0) {
            attr.addFlashAttribute("msg", "Producto creado exitosamente");
        } else {
            attr.addFlashAttribute("msg", "Producto actualizado exitosamente");
        }

        if (product.getCategory() != null && product.getSupplier() != null) {
            productRepository.save(product);
            return "redirect:/product";
        } else {
            model.addAttribute("errProd", "Error al crear producto");
            model.addAttribute("listaCategory", categoryRepository.findAll());
            model.addAttribute("listaSupplier", supplierRepository.findAll());
            if (product.getId() != 0) {
                model.addAttribute("product", product);
                return "product/editFrm";
            } else {
                return "product/newFrm";
            }
        }
    }

    @GetMapping("/edit")
    public String editarTransportista(Model model, @RequestParam("id") int id) {

        Optional<Product> optProduct = productRepository.findById(id);

        if (optProduct.isPresent()) {
            Product product = optProduct.get();
            model.addAttribute("product", product);
            model.addAttribute("listaCategory", categoryRepository.findAll());
            model.addAttribute("listaSupplier", supplierRepository.findAll());
            return "product/editFrm";
        } else {
            return "redirect:/product";
        }
    }

    @GetMapping("/delete")
    public String borrarTransportista(Model model,
                                      @RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Product> optProduct = productRepository.findById(id);

        if (optProduct.isPresent()) {
            productRepository.deleteById(id);
            attr.addFlashAttribute("msg", "Producto borrado exitosamente");
        }
        return "redirect:/product";

    }

}
