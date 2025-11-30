package com.sanodmendis.bxbyn.models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.math.BigDecimal;

/**
 *
 * @author Sanod D. Mendis
 */
public class MovementItem {
    private int movementItemId;
    private int movementId;
    private int materialId;
    private Integer batchId;
    private Integer fromBinId;
    private Integer toBinId;
    private BigDecimal quantity;
    private String uom;
    private String lineStatus;
    private BigDecimal processedQuantity;
    private String lineNotes;

    public MovementItem() {}

    public MovementItem(int movementId, int materialId, BigDecimal quantity, String uom) {
        this.movementId = movementId;
        this.materialId = materialId;
        this.quantity = quantity;
        this.uom = uom;
        this.lineStatus = "PENDING";
        this.processedQuantity = BigDecimal.ZERO;
    }

    public int getMovementItemId() { return movementItemId; }
    public void setMovementItemId(int movementItemId) { this.movementItemId = movementItemId; }

    public int getMovementId() { return movementId; }
    public void setMovementId(int movementId) { this.movementId = movementId; }

    public int getMaterialId() { return materialId; }
    public void setMaterialId(int materialId) { this.materialId = materialId; }

    public Integer getBatchId() { return batchId; }
    public void setBatchId(Integer batchId) { this.batchId = batchId; }

    public Integer getFromBinId() { return fromBinId; }
    public void setFromBinId(Integer fromBinId) { this.fromBinId = fromBinId; }

    public Integer getToBinId() { return toBinId; }
    public void setToBinId(Integer toBinId) { this.toBinId = toBinId; }

    public BigDecimal getQuantity() { return quantity; }
    public void setQuantity(BigDecimal quantity) { this.quantity = quantity; }

    public String getUom() { return uom; }
    public void setUom(String uom) { this.uom = uom; }

    public String getLineStatus() { return lineStatus; }
    public void setLineStatus(String lineStatus) { this.lineStatus = lineStatus; }

    public BigDecimal getProcessedQuantity() { return processedQuantity; }
    public void setProcessedQuantity(BigDecimal processedQuantity) { this.processedQuantity = processedQuantity; }

    public String getLineNotes() { return lineNotes; }
    public void setLineNotes(String lineNotes) { this.lineNotes = lineNotes; }
}
