package com.mindtree.ira.service;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.mindtree.ira.dao.IRADAO;
import com.mindtree.ira.model.ServiceRequest;

@ManagedBean(name = "iraService")
@ApplicationScoped
public class IRAService {
	    
    @ManagedProperty("#{iraDao}")
    private IRADAO iraDao;
     
    public List<ServiceRequest> createKitchenServiceRequest() {
    	return iraDao.createKitchenServiceRequests();
    }
    
    public List<ServiceRequest> createRetailServiceRequests() {
    	return iraDao.createRetailServiceRequests();
    }

	public void setIraDao(IRADAO iraDao) {
		this.iraDao = iraDao;
	}
}
