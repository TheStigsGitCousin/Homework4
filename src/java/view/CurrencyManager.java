/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CurrencyFacade;
import java.io.Serializable;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.CurrencyDTO;

/**
 *
 * @author David
 */
@Named("currMan")
@SessionScoped
public class CurrencyManager implements Serializable {
    
    private static final long serialVersionUID = 16247164405L;
    @EJB
    private CurrencyFacade currencyFacade;
    @Inject
    private Conversation conversation;
    private CurrencyDTO fromCurrency;
    private CurrencyDTO toCurrency;
    private Map<String, CurrencyDTO> allCurrencies;
    private double convertionResult;
    
    public void convertCurrensies(){
        currencyFacade.createCurrency("Kronor", "kr", 7);
        currencyFacade.createCurrency("Dollar", "$", 14);
        currencyFacade.createCurrency("Euro", "€", 9);
        if(fromCurrency!=null && toCurrency!=null){
            
        }
    }
    
    public Map<String, CurrencyDTO> getAllCurrencies() {
        return allCurrencies;
    }

    public CurrencyDTO getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(CurrencyDTO fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public CurrencyDTO getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(CurrencyDTO toCurrency) {
        this.toCurrency = toCurrency;
    }
    
}
