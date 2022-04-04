package com.example.clase4multiplestablas.controller;

import com.example.clase4multiplestablas.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("")
    public String index(){
        return "index";
    }

    @GetMapping("/estadisticas")
    public String estadisticas(Model model){
        model.addAttribute("listaEmpleadosPorRegion",employeeRepository.listaEmpleadosPorRegion());
        return "employee/estadistica";
    }
}
