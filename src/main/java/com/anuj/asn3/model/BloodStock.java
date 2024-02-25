package com.anuj.asn3.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BloodStock")
public class BloodStock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}
	public BloodStock(Long id, String bloodGroup, int quantity, LocalDate bestBeforeDate, String status) {
		super();
		this.id = id;
		this.bloodGroup = bloodGroup;
		this.quantity = quantity;
		this.bestBeforeDate = bestBeforeDate;
		this.status = status;
	}
	public BloodStock() {
		super();
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDate getBestBeforeDate() {
		return bestBeforeDate;
	}
	public void setBestBeforeDate(LocalDate bestBeforeDate) {
		this.bestBeforeDate = bestBeforeDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String bloodGroup;

	private int quantity;

	private LocalDate bestBeforeDate;
	private String status;

}
