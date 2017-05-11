package com.grandcircus.spring.controller;

import com.grandcircus.spring.models.CustomersEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by Antonella on 5/10/17.
 */


@Controller
public class HomeController {


    @RequestMapping("/")

    public ModelAndView listCustomer() {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");


        SessionFactory sessionFact = cfg.buildSessionFactory();

        Session selectCustomers = sessionFact.openSession();

        selectCustomers.beginTransaction();

        Criteria c = selectCustomers.createCriteria(CustomersEntity.class);

        ArrayList<CustomersEntity> customerList = (ArrayList<CustomersEntity>) c.list();

        return new
                ModelAndView("welcome", "cList", customerList);
    }


    @RequestMapping("delete")
    public ModelAndView deleteCustomer(@RequestParam("id") String id)
    {
        // temp will store info for the object that we want to delete
        CustomersEntity temp = new CustomersEntity();
        temp.setCustomerId(id);


        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

        SessionFactory fact = cfg.buildSessionFactory();

        Session customers = fact.openSession();
        customers.beginTransaction();

        customers.delete(temp);// delete the object from the list

        customers.getTransaction().commit();// delete the row from the database

        ArrayList<CustomersEntity> customerList = getAllCustomers();

        return new
                ModelAndView("welcome","cList",customerList);

    }

    @RequestMapping("searchByCity")
    public ModelAndView searchByCity(@RequestParam("city") String cityName){

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");


        SessionFactory sessionFact = cfg.buildSessionFactory();

        Session selectCustomers = sessionFact.openSession();

        selectCustomers.beginTransaction();

        Criteria c = selectCustomers.createCriteria(CustomersEntity.class);

        c.add(Restrictions.like("city", "%"+cityName+"%"));

        ArrayList<CustomersEntity> customerList = (ArrayList<CustomersEntity>) c.list();

        return new
                ModelAndView("welcome","cList",customerList);

    }

    @RequestMapping("dropdownMenu")
    public ModelAndView countryDropdownMenu(@RequestParam("country") String countryName){

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

        SessionFactory sessionFact = cfg.buildSessionFactory();

        Session selectCustomers = sessionFact.openSession();

        selectCustomers.beginTransaction();

        Criteria c = selectCustomers.createCriteria(CustomersEntity.class);

        c.add(Restrictions.like("country", "%"+countryName+"%"));

        ArrayList<CustomersEntity> customerList = (ArrayList<CustomersEntity>) c.list();

        return new
                ModelAndView("welcome","cList",customerList);

    }

    @RequestMapping("addCustomer")
    public ModelAndView addCust(@RequestParam("custID") String custid,
                                @RequestParam("compName") String companyN,
                                @RequestParam("contName") String contactN,
                                @RequestParam("contTitle") String contactT,
                                @RequestParam("address") String addrss,
                                @RequestParam("city") String cty,
                                @RequestParam("region") String reg,
                                @RequestParam("pCode") String postCode,
                                @RequestParam("country") String countr,
                                @RequestParam("phone") String phoneN,
                                @RequestParam("fax") String fx){

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

        SessionFactory sessionFact = cfg.buildSessionFactory();

        Session session = sessionFact.openSession();

        Transaction tx = session.beginTransaction();
        CustomersEntity newCust = new CustomersEntity ();

        newCust.setCustomerId(custid);
        newCust.setCompanyName(companyN);
        newCust.setContactName(contactN);
        newCust.setContactTitle(contactT);
        newCust.setAddress(addrss);
        newCust.setCity(cty);
        newCust.setRegion(reg);
        newCust.setPostalCode(postCode);
        newCust.setCountry(countr);
        newCust.setPhone(phoneN);
        newCust.setFax(fx);

        session.save(newCust);
        tx.commit();
        session.close();

        return new ModelAndView("addedCust", "addingCust", newCust);

    }

    @RequestMapping("getNewCust")
    ModelAndView newCust(){

        return new ModelAndView("addACustomer", "adding Cust", "");
    }
    public ArrayList<CustomersEntity> getAllCustomers()
    {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");


        SessionFactory sessionFact = cfg.buildSessionFactory();

        Session selectCustomers = sessionFact.openSession();

        selectCustomers.beginTransaction();

        Criteria c = selectCustomers.createCriteria(CustomersEntity.class);

        ArrayList<CustomersEntity> customerList=(ArrayList<CustomersEntity>)c.list();

        return  customerList;

    }
}