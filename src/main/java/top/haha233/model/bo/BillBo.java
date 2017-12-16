package top.haha233.model.bo;

import top.haha233.model.po.ProviderPo;

public class BillBo {
	private Long id;
	private String billCode;
	private String productName;
	private String productDesc;
	private String productUnit;
	private String productCount;
	private Double totalPrice;
	private Long isPayment;
	private ProviderPo providerId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}

	public String getProductCount() {
		return productCount;
	}

	public void setProductCount(String productCount) {
		this.productCount = productCount;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getIsPayment() {
		return isPayment;
	}

	public void setIsPayment(Long isPayment) {
		this.isPayment = isPayment;
	}

	public ProviderPo getProviderId() {
		return providerId;
	}

	public void setProviderId(ProviderPo providerId) {
		this.providerId = providerId;
	}

	@Override
	public String toString() {
		return "BillBo{" +
				"id=" + id +
				", billCode='" + billCode + '\'' +
				", productName='" + productName + '\'' +
				", productDesc='" + productDesc + '\'' +
				", productUnit='" + productUnit + '\'' +
				", productCount='" + productCount + '\'' +
				", totalPrice=" + totalPrice +
				", isPayment=" + isPayment +
				", providerId=" + providerId +
				'}';
	}
}
