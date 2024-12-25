package com.bhabani.flexiventures.models;

import java.util.List;

public class Order {
	private String recordId;
	private String taskId;

	private double partsPrice;
	private double labourPrice;
	private double amount;

	private String status;

	private List<String> reviewSummary;

	private String createdBy;
	private String updatedBy;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(String recordId, String taskId, double partsPrice, double labourPrice, double amount, String status,
			List<String> reviewSummary, String createdBy, String updatedBy) {
		super();
		this.recordId = recordId;
		this.taskId = taskId;
		this.partsPrice = partsPrice;
		this.labourPrice = labourPrice;
		this.amount = amount;
		this.status = status;
		this.reviewSummary = reviewSummary;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public double getPartsPrice() {
		return partsPrice;
	}

	public void setPartsPrice(double partsPrice) {
		this.partsPrice = partsPrice;
	}

	public double getLabourPrice() {
		return labourPrice;
	}

	public void setLabourPrice(double labourPrice) {
		this.labourPrice = labourPrice;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getReviewSummary() {
		return reviewSummary;
	}

	public void setReviewSummary(List<String> reviewSummary) {
		this.reviewSummary = reviewSummary;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}