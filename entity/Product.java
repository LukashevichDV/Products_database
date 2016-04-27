package ru.mail.LukashevichDV.entity;


import javafx.scene.control.TableColumn;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "date of produce")
    private String date;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<GroupProduct> groupProductList;


    public Product(String nameProduct, String descriptionProduct, String dateProduct) {

    }

    public Product(Integer id, String name, List<GroupProduct> groupProductList, String description, String date) {
        this.id = id;
        this.name = name;
        this.groupProductList = groupProductList;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GroupProduct> getGroupProductList() {
        return groupProductList;
    }

    public void setGroupProductList(List<GroupProduct> groupProductList) {
        this.groupProductList = groupProductList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
