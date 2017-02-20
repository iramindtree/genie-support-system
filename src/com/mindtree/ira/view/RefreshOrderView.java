package com.mindtree.ira.view;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.mindtree.ira.model.ServiceRequest;
import com.mindtree.ira.service.IRAService;

@ManagedBean
@ViewScoped
public class RefreshOrderView {
	private String kitchenOrderText = "Hello" ;
	private List<ServiceRequest> kitchenServiceRequests;
	private List<ServiceRequest> retailServiceRequests;
	
	@ManagedProperty("#{iraService}")
    private IRAService iraService;
	
	@PostConstruct
    public void init() {
        kitchenServiceRequests = new ArrayList<ServiceRequest>();
        retailServiceRequests = new ArrayList<ServiceRequest>();
        updateKitchenOrder();
        updateRetailOrder();
    }
	
	public void updateKitchenOrder(){
		kitchenServiceRequests = iraService.createKitchenServiceRequest();
	}
	
	public void updateRetailOrder(){
		retailServiceRequests = iraService.createRetailServiceRequests();
	}

	public String getKitchenOrderText() {
		return kitchenOrderText;
	}

	public void setKitchenOrderText(String kitchenOrderText) {
		this.kitchenOrderText = kitchenOrderText;
	}

	public List<ServiceRequest> getKitchenServiceRequests() {
		return kitchenServiceRequests;
	}

	public List<ServiceRequest> getRetailServiceRequests() {
		return retailServiceRequests;
	}
	
	public void setIraService(IRAService iraService) {
		this.iraService = iraService;
	}

}
