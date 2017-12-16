package top.haha233.model.po;

/**
 * @author Ice_Dog
 */
public class BillPo {
	private Long id;
	private String billCode;
	private String productName;
	private String productDesc;
	private String productUnit;
	private Double productCount;
	private Double totalPrice;
	private Integer isPayment;
	private Long providerId;

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

	public Double getProductCount() {
		return productCount;
	}

	public void setProductCount(Double productCount) {
		this.productCount = productCount;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getIsPayment() {
		return isPayment;
	}

	public void setIsPayment(Integer isPayment) {
		this.isPayment = isPayment;
	}

	public Long getProviderId() {
		return providerId;
	}

	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}

	@Override
	public String toString() {
		return "BillPo{" +
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
