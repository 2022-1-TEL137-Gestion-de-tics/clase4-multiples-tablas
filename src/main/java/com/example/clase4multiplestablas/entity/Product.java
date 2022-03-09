package com.example.clase4multiplestablas.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ProductID")
    private int id;
    @Column(nullable = false)
    private String productname;
    private int supplierid;
    private int categoryid;
    private String quantityperunit;
    private BigDecimal unitprice;
    private int unitsinstock;
    private int unitsonorder;
    private int reorderlevel;
    @Column(nullable = false)
    private boolean discontinued;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(int supplierid) {
        this.supplierid = supplierid;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getQuantityperunit() {
        return quantityperunit;
    }

    public void setQuantityperunit(String quantityperunit) {
        this.quantityperunit = quantityperunit;
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    public int getUnitsinstock() {
        return unitsinstock;
    }

    public void setUnitsinstock(int unitsinstock) {
        this.unitsinstock = unitsinstock;
    }

    public int getUnitsonorder() {
        return unitsonorder;
    }

    public void setUnitsonorder(int unitsonorder) {
        this.unitsonorder = unitsonorder;
    }

    public int getReorderlevel() {
        return reorderlevel;
    }

    public void setReorderlevel(int reorderlevel) {
        this.reorderlevel = reorderlevel;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }
}
