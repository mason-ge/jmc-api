package com.jmc.api.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Description:
 * @Author: mason_ge
 * @Date: 14:30 2018/12/21
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
	private Timestamp updatedDate;
	private Long version;
	private String attribute1;
	private String attribute2;
	private String attribute3;
	private String attribute4;
	private String attribute5;
	private String createdBy;
	private Timestamp createdDate;
	private Long deletedFlag;

	@Id
	@Column(name = "ENUMV_ID", nullable = false, length = 36)
	public String getEnumvId() {
		return enumvId;
	}

	public void setEnumvId(String enumvId) {
		this.enumvId = enumvId;
	}

	@Basic
	@Column(name = "ENUM_ID_", nullable = true, length = 36)
	public String getEnumId() {
		return enumId;
	}

	public void setEnumId(String enumId) {
		this.enumId = enumId;
	}

	@Basic
	@Column(name = "ENUMV_CODE", nullable = false, length = 60)
	public String getEnumvCode() {
		return enumvCode;
	}

	public void setEnumvCode(String enumvCode) {
		this.enumvCode = enumvCode;
	}

	@Basic
	@Column(name = "ENUMV_DESC", nullable = true, length = 100)
	public String getEnumvDesc() {
		return enumvDesc;
	}

	public void setEnumvDesc(String enumvDesc) {
		this.enumvDesc = enumvDesc;
	}

	@Basic
	@Column(name = "ENUMV_NAME", nullable = false, length = 200)
	public String getEnumvName() {
		return enumvName;
	}

	public void setEnumvName(String enumvName) {
		this.enumvName = enumvName;
	}

	@Basic
	@Column(name = "ORDER_NO", nullable = true)
	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	@Basic
	@Column(name = "PARENT_ENUMV_ID", nullable = true, length = 36)
	public String getParentEnumvId() {
		return parentEnumvId;
	}

	public void setParentEnumvId(String parentEnumvId) {
		this.parentEnumvId = parentEnumvId;
	}

	@Basic
	@Column(name = "UPDATED_BY", nullable = true, length = 120)
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Basic
	@Column(name = "UPDATED_DATE", nullable = true)
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Basic
	@Column(name = "VERSION", nullable = true)
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Basic
	@Column(name = "ATTRIBUTE1", nullable = true, length = 255)
	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	@Basic
	@Column(name = "ATTRIBUTE2", nullable = true, length = 255)
	public String getAttribute2() {
		return attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	@Basic
	@Column(name = "ATTRIBUTE3", nullable = true, length = 255)
	public String getAttribute3() {
		return attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	@Basic
	@Column(name = "ATTRIBUTE4", nullable = true, length = 255)
	public String getAttribute4() {
		return attribute4;
	}

	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}

	@Basic
	@Column(name = "ATTRIBUTE5", nullable = true, length = 255)
	public String getAttribute5() {
		return attribute5;
	}

	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}

	@Basic
	@Column(name = "CREATED_BY", nullable = true, length = 120)
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Basic
	@Column(name = "CREATED_DATE", nullable = true)
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	@Basic
	@Column(name = "DELETED_FLAG", nullable = true)
	public Long getDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(Long deletedFlag) {
		this.deletedFlag = deletedFlag;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		SysEnumv that = (SysEnumv) o;
		return Objects.equals(enumvId, that.enumvId) && Objects.equals(enumId, that.enumId)
				&& Objects.equals(enumvCode, that.enumvCode) && Objects.equals(enumvDesc, that.enumvDesc)
				&& Objects.equals(enumvName, that.enumvName) && Objects.equals(orderNo, that.orderNo)
				&& Objects.equals(parentEnumvId, that.parentEnumvId) && Objects.equals(updatedBy, that.updatedBy)
				&& Objects.equals(updatedDate, that.updatedDate) && Objects.equals(version, that.version)
				&& Objects.equals(attribute1, that.attribute1) && Objects.equals(attribute2, that.attribute2)
				&& Objects.equals(attribute3, that.attribute3) && Objects.equals(attribute4, that.attribute4)
				&& Objects.equals(attribute5, that.attribute5) && Objects.equals(createdBy, that.createdBy)
				&& Objects.equals(createdDate, that.createdDate) && Objects.equals(deletedFlag, that.deletedFlag);
	}

	@Override
	public int hashCode() {
		return Objects.hash(enumvId, enumId, enumvCode, enumvDesc, enumvName, orderNo, parentEnumvId, updatedBy,
				updatedDate, version, attribute1, attribute2, attribute3, attribute4, attribute5, createdBy,
				createdDate, deletedFlag);
	}
}
