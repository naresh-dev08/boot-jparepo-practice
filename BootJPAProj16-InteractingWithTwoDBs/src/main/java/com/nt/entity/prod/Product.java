package com.nt.entity.prod;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "JPA_ORA_PRODUCT_TAB")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	
	@Column(length = 30)
	@NonNull
	private String pname;
	
	@NonNull
	private Double price;
	
	@NonNull
	private Integer qty;
	
	@NonNull
	private boolean status;
	
	@NonNull
	private LocalDateTime expiryTime;
	
}
