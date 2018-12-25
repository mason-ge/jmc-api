package com.jmc.api.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

/**
 * @Description:商品基本信息
 * @Author: mason_ge
 * @Date: 11:20 2018/11/21
 */
@Entity
@Table(name = "prod_base_info")
public class ProdBase {
	private String pkId;
	private String client;
	private String prodCode;
	private String prodName;
	private String otherProdCode;
	private String brand;
	private String measUnit;
	private String invtyUnit;
	private String invtyMgtAttr;
	private String supCode;
	private String supName;
	private String prodTheme;
	private String firstRange;
	private String firstCatg;
	private String secCatg;
	private String armType;
	private String model;
	private String shape;
	private String mosType;
	private String prodCraft;
	private String surfHandleRem;
	private String otherCraftRem;
	private String cmptRem;
	private String designRem;
	private String status;
	private String createdBy;
	private Date createdD;
	private String updatedBy;
	private Date updatedD;
	private String attr1;
	private String attr2;
	private String attr3;
	private String attr4;
	private String attr5;
	private String delFlg;

	@Id
	@Column(name = "PK_ID")
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getPkId() {
		return pkId;
	}

	public void setPkId(String pkId) {
		this.pkId = pkId;
	}

	@Basic
	@Column(name = "CLIENT")
	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	@Basic
	@Column(name = "PROD_CODE")
	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	@Basic
	@Column(name = "PROD_NAME")
	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	@Basic
	@Column(name = "OTHER_PROD_CODE")
	public String getOtherProdCode() {
		return otherProdCode;
	}

	public void setOtherProdCode(String otherProdCode) {
		this.otherProdCode = otherProdCode;
	}

	@Basic
	@Column(name = "BRAND")
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Basic
	@Column(name = "MEAS_UNIT")
	public String getMeasUnit() {
		return measUnit;
	}

	public void setMeasUnit(String measUnit) {
		this.measUnit = measUnit;
	}

	@Basic
	@Column(name = "INVTY_UNIT")
	public String getInvtyUnit() {
		return invtyUnit;
	}

	public void setInvtyUnit(String invtyUnit) {
		this.invtyUnit = invtyUnit;
	}

	@Basic
	@Column(name = "INVTY_MGT_ATTR")
	public String getInvtyMgtAttr() {
		return invtyMgtAttr;
	}

	public void setInvtyMgtAttr(String invtyMgtAttr) {
		this.invtyMgtAttr = invtyMgtAttr;
	}

	@Basic
	@Column(name = "SUP_CODE")
	public String getSupCode() {
		return supCode;
	}

	public void setSupCode(String supCode) {
		this.supCode = supCode;
	}

	@Basic
	@Column(name = "SUP_NAME")
	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	@Basic
	@Column(name = "PROD_THEME")
	public String getProdTheme() {
		return prodTheme;
	}

	public void setProdTheme(String prodTheme) {
		this.prodTheme = prodTheme;
	}

	@Basic
	@Column(name = "FIRST_RANGE")
	public String getFirstRange() {
		return firstRange;
	}

	public void setFirstRange(String firstRange) {
		this.firstRange = firstRange;
	}

	@Basic
	@Column(name = "FIRST_CATG")
	public String getFirstCatg() {
		return firstCatg;
	}

	public void setFirstCatg(String firstCatg) {
		this.firstCatg = firstCatg;
	}

	@Basic
	@Column(name = "SEC_CATG")
	public String getSecCatg() {
		return secCatg;
	}

	public void setSecCatg(String secCatg) {
		this.secCatg = secCatg;
	}

	@Basic
	@Column(name = "ARM_TYPE")
	public String getArmType() {
		return armType;
	}

	public void setArmType(String armType) {
		this.armType = armType;
	}

	@Basic
	@Column(name = "MODEL")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Basic
	@Column(name = "SHAPE")
	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	@Basic
	@Column(name = "MOS_TYPE")
	public String getMosType() {
		return mosType;
	}

	public void setMosType(String mosType) {
		this.mosType = mosType;
	}

	@Basic
	@Column(name = "PROD_CRAFT")
	public String getProdCraft() {
		return prodCraft;
	}

	public void setProdCraft(String prodCraft) {
		this.prodCraft = prodCraft;
	}

	@Basic
	@Column(name = "SURF_HANDLE_REM")
	public String getSurfHandleRem() {
		return surfHandleRem;
	}

	public void setSurfHandleRem(String surfHandleRem) {
		this.surfHandleRem = surfHandleRem;
	}

	@Basic
	@Column(name = "OTHER_CRAFT_REM")
	public String getOtherCraftRem() {
		return otherCraftRem;
	}

	public void setOtherCraftRem(String otherCraftRem) {
		this.otherCraftRem = otherCraftRem;
	}

	@Basic
	@Column(name = "CMPT_REM")
	public String getCmptRem() {
		return cmptRem;
	}

	public void setCmptRem(String cmptRem) {
		this.cmptRem = cmptRem;
	}

	@Basic
	@Column(name = "DESIGN_REM")
	public String getDesignRem() {
		return designRem;
	}

	public void setDesignRem(String designRem) {
		this.designRem = designRem;
	}

	@Basic
	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	@Column(name = "CREATED_D")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedD() {
		return createdD;
	}

	public void setCreatedD(Date createdD) {
		this.createdD = createdD;
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
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_D")
	public Date getUpdatedD() {
		return updatedD;
	}

	public void setUpdatedD(Date updatedD) {
		this.updatedD = updatedD;
	}

	@Basic
	@Column(name = "ATTR1")
	public String getAttr1() {
		return attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	@Basic
	@Column(name = "ATTR2")
	public String getAttr2() {
		return attr2;
	}

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}

	@Basic
	@Column(name = "ATTR3")
	public String getAttr3() {
		return attr3;
	}

	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}

	@Basic
	@Column(name = "ATTR4")
	public String getAttr4() {
		return attr4;
	}

	public void setAttr4(String attr4) {
		this.attr4 = attr4;
	}

	@Basic
	@Column(name = "ATTR5")
	public String getAttr5() {
		return attr5;
	}

	public void setAttr5(String attr5) {
		this.attr5 = attr5;
	}

	@Basic
	@Column(name = "DEL_FLG")
	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ProdBase that = (ProdBase) o;
		return Objects.equals(pkId, that.pkId) && Objects.equals(client, that.client)
				&& Objects.equals(prodCode, that.prodCode) && Objects.equals(prodName, that.prodName)
				&& Objects.equals(otherProdCode, that.otherProdCode) && Objects.equals(brand, that.brand)
				&& Objects.equals(measUnit, that.measUnit) && Objects.equals(invtyUnit, that.invtyUnit)
				&& Objects.equals(invtyMgtAttr, that.invtyMgtAttr) && Objects.equals(supCode, that.supCode)
				&& Objects.equals(supName, that.supName) && Objects.equals(prodTheme, that.prodTheme)
				&& Objects.equals(firstRange, that.firstRange) && Objects.equals(firstCatg, that.firstCatg)
				&& Objects.equals(secCatg, that.secCatg) && Objects.equals(armType, that.armType)
				&& Objects.equals(model, that.model) && Objects.equals(shape, that.shape)
				&& Objects.equals(mosType, that.mosType) && Objects.equals(prodCraft, that.prodCraft)
				&& Objects.equals(surfHandleRem, that.surfHandleRem)
				&& Objects.equals(otherCraftRem, that.otherCraftRem) && Objects.equals(cmptRem, that.cmptRem)
				&& Objects.equals(designRem, that.designRem) && Objects.equals(status, that.status)
				&& Objects.equals(createdBy, that.createdBy) && Objects.equals(createdD, that.createdD)
				&& Objects.equals(updatedBy, that.updatedBy) && Objects.equals(updatedD, that.updatedD)
				&& Objects.equals(attr1, that.attr1) && Objects.equals(attr2, that.attr2)
				&& Objects.equals(attr3, that.attr3) && Objects.equals(attr4, that.attr4)
				&& Objects.equals(attr5, that.attr5) && Objects.equals(delFlg, that.delFlg);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pkId, client, prodCode, prodName, otherProdCode, brand, measUnit, invtyUnit, invtyMgtAttr,
				supCode, supName, prodTheme, firstRange, firstCatg, secCatg, armType, model, shape, mosType, prodCraft,
				surfHandleRem, otherCraftRem, cmptRem, designRem, status, createdBy, createdD, updatedBy, updatedD,
				attr1, attr2, attr3, attr4, attr5, delFlg);
	}
}
