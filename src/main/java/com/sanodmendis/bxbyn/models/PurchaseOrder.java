/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanodmendis.bxbyn.models;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Sanod D. Mendis
 */
public class PurchaseOrder {
    private String poNumber;
    private String vendor;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private String status;
    private List<POItem> items;
    
    // Getters and Setters
    public String getPoNumber() { return poNumber; }
    public void setPoNumber(String poNumber) { this.poNumber = poNumber; }
    
    public String getVendor() { return vendor; }
    public void setVendor(String vendor) { this.vendor = vendor; }
    
    public LocalDate getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }
    
    public LocalDate getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(LocalDate deliveryDate) { this.deliveryDate = deliveryDate; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public List<POItem> getItems() { return items; }
    public void setItems(List<POItem> items) { this.items = items; }
}
