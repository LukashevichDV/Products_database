package ru.mail.LukashevichDV.service;

import ru.mail.LukashevichDV.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    void save (List<Product> data);

    List<Product> getByParametr (String key, String value);

}
