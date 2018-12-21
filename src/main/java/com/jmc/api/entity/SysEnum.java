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
@Table(name = "sys_enum")
public class SysEnum {
	private String enumId;
	private String enumCode;
	private String enumDesc;
	private String enumName;
	private String enumType;
	private String model;
	private Timestamp syncDate;
	private String syncFlag;
	private String updatedBy;
	private Timestamp updatedDate;
	private String valueFrom;
	private String version;
	private String attribute1;
	private String attribute2;
	private String attribute3;
	private String attribute4;
	private String attribute5;
	private String createdBy;
	private Timestamp createdDate;
	private String deletedFlag;

	@Id
	@Column(name = "ENUM_ID", nullable = false, length = 36)
	public String getEnumId() {
		return enumId;
	}

	public void setEnumId(String enumId) {
		this.enumId = enumId;
	}

	@Basic
	@Column(name = "ENUM_CODE", nullable = false, length = 30)
	public String getEnumCode() {
		return enumCode;
	}

	public void setEnumCode(String enumCode) {
		this.enumCode = enumCode;
	}

	@Basic
	@Column(name = "ENUM_DESC", nullable = true, length = 200)
	public String getEnumDesc() {
		return enumDesc;
	}

	public void setEnumDesc(String enumDesc) {
		this.enumDesc = enumDesc;
	}

	@Basic
	@Column(name = "ENUM_NAME", nullable = false, length = 60)
	public String getEnumName() {
		return enumName;
	}

	public void setEnumName(String enumName) {
		this.enumName = enumName;
	}

	@Basic
	@Column(name = "ENUM_TYPE", nullable = true, length = 60)
	public String getEnumType() {
		return enumType;
	}

	public void setEnumType(String enumType) {
		this.enumType = enumType;
	}

	@Basic
	@Column(name = "MODEL", nullable = true, length = 60)
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Basic
	@Column(name = "SYNC_DATE", nullable = true)
	public Timestamp getSyncDate() {
		return syncDate;
	}

	public void setSyncDate(Timestamp syncDate) {
		this.syncDate = syncDate;
	}

	@Basic
	@Column(name = "SYNC_FLAG", nullable = true, length = 2)
	public String getSyncFlag() {
		return syncFlag;
	}

	public void setSyncFlag(String syncFlag) {
		this.syncFlag = syncFlag;
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
	@Column(name = "VALUE_FROM", nullable = true, length = 60)
	public String getValueFrom() {
		return valueFrom;
	}

	public void setValueFrom(String valueFrom) {
		this.valueFrom = valueFrom;
	}

	@Basic
	@Column(name = "VERSION", nullable = true, length = 20)
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
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
	@Column(name = "CREATED_BY", nullable = true, length = 60)
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
	@Column(name = "DELETED_FLAG", nullable = true, length = 1)
	public String getDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(String deletedFlag) {
		this.deletedFlag = deletedFlag;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SysEnum that = (SysEnum) o;
		return Objects.equals(enumId, that.enumId) &&
				Objects.equals(enumCode, that.enumCode) &&
				Objects.equals(enumDesc, that.enumDesc) &&
				Objects.equals(enumName, that.enumName) &&
				Objects.equals(enumType, that.enumType) &&
				Objects.equals(model, that.model) &&
				Objects.equals(syncDate, that.syncDate) &&
				Objects.equals(syncFlag, that.syncFlag) &&
				Objects.equals(updatedBy, that.updatedBy) &&
				Objects.equals(updatedDate, that.updatedDate) &&
				Objects.equals(valueFrom, that.valueFrom) &&
				Objects.equals(version, that.version) &&
				Objects.equals(attribute1, that.attribute1) &&
				Objects.equals(attribute2, that.attribute2) &&
				Objects.equals(attribute3, that.attribute3) &&
				Objects.equals(attribute4, that.attribute4) &&
				Objects.equals(attribute5, that.attribute5) &&
				Objects.equals(createdBy, that.createdBy) &&
				Objects.equals(createdDate, that.createdDate) &&
				Objects.equals(deletedFlag, that.deletedFlag);
	}

	@Override
	public int hashCode() {
		return Objects.hash(enumId, enumCode, enumDesc, enumName, enumType, model, syncDate, syncFlag, updatedBy, updatedDate, valueFrom, version, attribute1, attribute2, attribute3, attribute4, attribute5, createdBy, createdDate, deletedFlag);
	}
}
