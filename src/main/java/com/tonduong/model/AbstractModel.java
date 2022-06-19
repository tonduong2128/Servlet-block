package com.tonduong.model;

import java.sql.Timestamp;

abstract class AbstractModel {
	protected Integer id;

	protected Timestamp createddate;
	protected Timestamp modifieddate;
	protected Integer createdby;
	protected Integer modifiedby;
	
	public AbstractModel() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}
	public Timestamp getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(Timestamp modifiededdate) {
		this.modifieddate = modifiededdate;
	}
	public Integer getCreatedby() {
		return createdby;
	}
	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}
	public Integer getModifiedby() {
		return modifiedby;
	}
	public void setModifiedby(Integer modifiedby) {
		this.modifiedby = modifiedby;
	}
	
}
