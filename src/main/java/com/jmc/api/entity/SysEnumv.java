package com.jmc.api.entity;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.*;

/**
 * @Description:枚举值
 * @Author: mason_ge
 * @Date: 11:14 2018/12/25
 */
@Entity
@Table(name = "sys_enumv")
public class SysEnumv {
	private String enumvId;
	private String enumId;
	private String enumvCode;
	private String enumvDesc;
	private String enumvName;
	private Long orderNo;
	private String parentEnumvId;
	private String updatedBy;
	private Date updatedDate;
	private Long version;
	private String attribute1;
	private String attribute2;
	private String attribute3;
	private String attribute4;
	private String attribute5;
	private String createdBy;
	private Date createdDate;
	private Long deletedFlag;

	@Id
	@Column(name = "ENUMV_ID")
	public String getEnumvId() {
		return enumvId;
	}

	public void setEnumvId(String enumvId) {
		this.enumvId = enumvId;
	}

	@Basic
	@Column(name = "ENUM_ID_")
	public String getEnumId() {
		return enumId;
	}

	public void setEnumId(String enumId) {
		this.enumId = enumId;
	}

	@Basic
	@Column(name = "ENUMV_CODE")
	public String getEnumvCode() {
		return enumvCode;
	}

	public void setEnumvCode(String enumvCode) {
		this.enumvCode = enumvCode;
	}

	@Basic
	@Column(name = "ENUMV_DESC")
	public String getEnumvDesc() {
		return enumvDesc;
	}

	public void setEnumvDesc(String enumvDesc) {
		this.enumvDesc = enumvDesc;
	}

	@Basic
	@Column(name = "ENUMV_NAME")
	public String getEnumvName() {
		return enumvName;
	}

	public void setEnumvName(String enumvName) {
		this.enumvName = enumvName;
	}

	@Basic
	@Column(name = "ORDER_NO")
	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	@Basic
	@Column(name = "PARENT_ENUMV_ID")
	public String getParentEnumvId() {
		return parentEnumvId;
	}

	public void setParentEnumvId(String parentEnumvId) {
		this.parentEnumvId = parentEnumvId;
	}

	@Basic
	@Column(name = "UPDATED_BY")
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Basic
	@Column(name = "UPDATED_DATE")
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Basic
	@Column(name = "VERSION")
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Basic
	@Column(name = "ATTRIBUTE1")
	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	@Basic
	@Column(name = "ATTRIBUTE2")
	public String getAttribute2() {
		return attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	@Basic
	@Column(name = "ATTRIBUTE3")
	public String getAttribute3() {
		return attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	@Basic
	@Column(name = "ATTRIBUTE4")
	public String getAttribute4() {
		return attribute4;
	}

	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}

	@Basic
	@Column(name = "ATTRIBUTE5")
	public String getAttribute5() {
		return attribute5;
	}

	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}

	@Basic
	@Column(name = "CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Basic
	@Column(name = "CREATED_DATE")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Basic
	@Column(name = "DELETED_FLAG")
	public Long getDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(Long deletedFlag) {
		this.deletedFlag = deletedFlag;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SysEnumv sysEnumv = (SysEnumv) o;
		return Objects.equals(enumvId, sysEnumv.enumvId) && Objects.equals(enumId, sysEnumv.enumId)
				&& Objects.equals(enumvCode, sysEnumv.enumvCode) && Objects.equals(enumvDesc, sysEnumv.enumvDesc)
				&& Objects.equals(enumvName, sysEnumv.enumvName) && Objects.equals(orderNo, sysEnumv.orderNo)
				&& Objects.equals(parentEnumvId, sysEnumv.parentEnumvId)
				&& Objects.equals(updatedBy, sysEnumv.updatedBy) && Objects.equals(updatedDate, sysEnumv.updatedDate)
				&& Objects.equals(version, sysEnumv.version) && Objects.equals(attribute1, sysEnumv.attribute1)
				&& Objects.equals(attribute2, sysEnumv.attribute2) && Objects.equals(attribute3, sysEnumv.attribute3)
				&& Objects.equals(attribute4, sysEnumv.attribute4) && Objects.equals(attribute5, sysEnumv.attribute5)
				&& Objects.equals(createdBy, sysEnumv.createdBy) && Objects.equals(createdDate, sysEnumv.createdDate)
				&& Objects.equals(deletedFlag, sysEnumv.deletedFlag);
	}

	@Override
	public int hashCode() {
		return Objects.hash(enumvId, enumId, enumvCode, enumvDesc, enumvName, orderNo, parentEnumvId, updatedBy,
				updatedDate, version, attribute1, attribute2, attribute3, attribute4, attribute5, createdBy,
				createdDate, deletedFlag);
	}
}
