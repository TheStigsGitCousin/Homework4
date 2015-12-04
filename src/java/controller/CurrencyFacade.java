/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Currency;
import model.CurrencyDTO;

/**
 *
 * @author David
 */
@Stateless
public class CurrencyFacade {
    
    @PersistenceContext(unitName = "currencyPU")
    private EntityManager em;
    
    public CurrencyDTO createCurrency(String currencyName, String currencyAbbreviation, double currencyValue){
        CurrencyDTO cu=new Currency(currencyName, currencyAbbreviation, currencyValue);
        em.persist(cu);
        return cu;
    }
    
    public CurrencyDTO getCurrency(String currencyName){
        return em.find(CurrencyDTO.class, currencyName);
    }
    
    public LinkedHashMap<String, CurrencyDTO> getCurrencies(){
        Query query = em.createQuery("SELECT e FROM Currency e");
        LinkedHashMap<String, CurrencyDTO> map=new LinkedHashMap<>();
        Collection<CurrencyDTO> col=(Collection<CurrencyDTO>) query.getResultList();
        for(CurrencyDTO c : col){
            map.put(c.getCurrencyName(), c);
        }
        return map;
    }
}
