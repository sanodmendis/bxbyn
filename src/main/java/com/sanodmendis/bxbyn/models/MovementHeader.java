/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanodmendis.bxbyn.models;

import java.time.LocalDateTime;

/**
 *
 * @author Sanod D. Mendis
 */
public class MovementHeader {
    private int movementId;
    private String movementNumber;
    private int movementTypeId;
    private String referenceDocument;
    private LocalDateTime movementDate;
    private String status;
    private String createdBy;
    private LocalDateTime createdDate;
    private String postedBy;
    private LocalDateTime postedDate;
    private String notes;
    
    // Constructors
    public MovementHeader() {}
    
    public MovementHeader(String movementNumber, int movementTypeId, String referenceDocument, String createdBy) {
        this.movementNumber = movementNumber;
        this.movementTypeId = movementTypeId;
        this.referenceDocument = referenceDocument;
        this.createdBy = createdBy;
        this.movementDate = LocalDateTime.now();
        this.createdDate = LocalDateTime.now();
        this.status = "DRAFT";
    }
    
    // Getters and Setters
    public int getMovementId() { return movementId; }
    public void setMovementId(int movementId) { this.movementId = movementId; }
    
    public String getMovementNumber() { return movementNumber; }
    public void setMovementNumber(String movementNumber) { this.movementNumber = movementNumber; }
    
    public int getMovementTypeId() { return movementTypeId; }
    public void setMovementTypeId(int movementTypeId) { this.movementTypeId = movementTypeId; }
    
    public String getReferenceDocument() { return referenceDocument; }
    public void setReferenceDocument(String referenceDocument) { this.referenceDocument = referenceDocument; }
    
    public LocalDateTime getMovementDate() { return movementDate; }
    public void setMovementDate(LocalDateTime movementDate) { this.movementDate = movementDate; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
    
    public LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }
    
    public String getPostedBy() { return postedBy; }
    public void setPostedBy(String postedBy) { this.postedBy = postedBy; }
    
    public LocalDateTime getPostedDate() { return postedDate; }
    public void setPostedDate(LocalDateTime postedDate) { this.postedDate = postedDate; }
    
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
