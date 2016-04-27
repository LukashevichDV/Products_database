package ru.mail.LukashevichDV.dao.Impl;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import ru.mail.LukashevichDV.HibernateUtil;
import ru.mail.LukashevichDV.dao.ProductDao;
import ru.mail.LukashevichDV.entity.Product;

import java.util.List;

public class ProductDaoImpl  implements ProductDao{


    @Override
    public Product getById(Integer id) {
        Session session = getSession();
        Product product = (Product) session.get(Product.class, id);
        session.close();
        return product;
    }

    @Override
    public List<Product> getAll() {
        Session session = getSession();
        Criteria criteria = session.createCriteria(Product.class);
        List<Product> products = criteria.list();
        session.close();
        return products;
    }

    @Override
    public void save(Product product) {
        Session session = getSession();
        session.getTransaction().begin();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void save(List<Product> products) {
        Session session = getSession();
        session.getTransaction().begin();
        for (Product product:products) {
            session.saveOrUpdate(product);
        }
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public List<Product> getByCriterion(Criterion criterion) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(Product.class);
        criteria.add(criterion);
        List<Product> products = criteria.list();
        session.close();
        return products;
    }

    private Session getSession(){
        return  HibernateUtil.getSessionFactory().openSession();
    }
}
