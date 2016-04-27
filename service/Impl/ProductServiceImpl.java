package ru.mail.LukashevichDV.service.Impl;


import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import ru.mail.LukashevichDV.dao.Impl.ProductDaoImpl;
import ru.mail.LukashevichDV.dao.ProductDao;
import ru.mail.LukashevichDV.entity.Product;
import ru.mail.LukashevichDV.service.ProductService;

import java.util.List;

public class ProductServiceImpl  implements ProductService{


    private ProductDao dao = new ProductDaoImpl();

    @Override
    public List<Product> getAll() {
        return dao.getAll();
    }

    @Override
    public void save(List<Product> data) {
        dao.save(data);
    }

    @Override
    public List<Product> getByParametr(String key, String value) {
        Criterion criterion = Restrictions.eq(key, value);
        return dao.getByCriterion(criterion);
    }
}
