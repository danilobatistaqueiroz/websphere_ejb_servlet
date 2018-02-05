package com.labs;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;

@Stateful
public class CartBean implements CartRemote {
	
	private int quantity = 0;
	private List<String> items;
	
    @Override
	public void add(String item) {
    	quantity++;
        items.add(item);
    }
    
    @Override
	public int getQuantity() {
    	return quantity;
    }
    
    @Override
	public List<String> getItens(){
    	return items;
    }
    
    @PostConstruct
    public void init() {
    	quantity = 0;
    	items = new ArrayList<String>();
    }
    
    @PrePassivate
    public void passivate() { System.out.println("@PrePassivate  ejb"); }
    @PostActivate
    public void activate() { System.out.println("@PostActivate  ejb"); }
    @PreDestroy
    public void shutdown() { System.out.println("@PreDestroy  ejb"); }
}