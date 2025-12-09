/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanodmendis.bxbyn.models;

import java.math.BigDecimal;

/**
 *
 * @author Sanod D. Mendis
 */
public class POItem {
    private int poItemId;
    private String poNumber;
    private int materialId;
    private String materialCode;
    private String materialDescription;
    private BigDecimal orderedQty;
    private BigDecimal receivedQty;
    private BigDecimal thisReceipt;
    private String uom;

    public int getPoItemId() { return poItemId; }
    public void setPoItemId(int poItemId) { this.poItemId = poItemId; }

    public String getPoNumber() { return poNumber; }
    public void setPoNumber(String poNumber) { this.poNumber = poNumber; }

    public int getMaterialId() { return materialId; }
    public void setMaterialId(int materialId) { this.materialId = materialId; }

    public String getMaterialCode() { return materialCode; }
    public void setMaterialCode(String materialCode) { this.materialCode = materialCode; }

    public String getMaterialDescription() { return materialDescription; }
    public void setMaterialDescription(String materialDescription) { this.materialDescription = materialDescription; }

    public BigDecimal getOrderedQty() { return orderedQty; }
    public void setOrderedQty(BigDecimal orderedQty) { this.orderedQty = orderedQty; }

    public BigDecimal getReceivedQty() { return receivedQty; }
    public void setReceivedQty(BigDecimal receivedQty) { this.receivedQty = receivedQty; }

    public BigDecimal getThisReceipt() { return thisReceipt; }
    public void setThisReceipt(BigDecimal thisReceipt) { this.thisReceipt = thisReceipt; }

    public String getUom() { return uom; }
    public void setUom(String uom) { this.uom = uom; }
}
