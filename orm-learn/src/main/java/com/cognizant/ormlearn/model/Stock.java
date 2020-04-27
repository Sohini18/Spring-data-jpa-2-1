package com.cognizant.ormlearn.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock {

	public Stock() {
		super();
	}

	public Stock(int id, String code, Date date, BigDecimal open, BigDecimal close, BigDecimal volume) {
		super();
		this.id = id;
		this.code = code;
		this.date = date;
		this.open = open;
		this.close = close;
		this.volume = volume;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="st_id")
	private int id;
	
	@Column(name="st_code")
	private String code;
	
	@Column(name="st_date")
	private Date date;
	
	@Column(name="st_open")
	private BigDecimal open;
	
	@Column(name="st_close")
	private BigDecimal close;
	
	@Column(name="st_volume")
	private BigDecimal volume;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getOpen() {
		return open;
	}

	public void setOpen(BigDecimal open) {
		this.open = open;
	}

	public BigDecimal getClose() {
		return close;
	}

	public void setClose(BigDecimal close) {
		this.close = close;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", code=" + code + ", date=" + date + ", open=" + open + ", close=" + close
				+ ", volume=" + volume + "]";
	}
	
	
	
	
}
