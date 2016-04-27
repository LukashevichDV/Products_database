package ru.mail.LukashevichDV.dao;


import org.hibernate.criterion.Criterion;
import ru.mail.LukashevichDV.entity.Product;

import java.util.List;

public interface ProductDao {

    Product getById(Integer id);

    List<Product> getAll();

    void save (Product product);

    void save (List<Product> products);

    List<Product> getByCriterion (Criterion criterion);

}
