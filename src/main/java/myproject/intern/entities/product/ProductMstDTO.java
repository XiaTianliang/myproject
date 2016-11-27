package myproject.intern.entities.product;


import myproject.intern.constants.PriceUnitType;
import myproject.intern.entities.ICsvMasterDTO;

public class ProductMstDTO implements ICsvMasterDTO {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1950118052473203296L;
	private int productMstId;
	private String productType;
	private String productName;
	private double price;
	private double salesPrice;
	private PriceUnitType priceUnit;

//	/**
//	 * Default Constructor
//	 *
//	 * @param productMstId
//	 * @param productType
//	 * @param productName
//	 * @param price
//	 * @param priceUnit
//	 */
//	public ProductMstDTO(int productMstId, String productType, String productName, double price, PriceUnitType priceUnit) {
//		super();
//		this.productMstId = productMstId;
//		this.productType = productType;
//		this.productName = productName;
//		this.price = price;
//		this.priceUnit = priceUnit;
//	}

	public int getProductMstId() {
		return productMstId;
	}

	public void setProductMstId(int productMstId) {
		this.productMstId = productMstId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public PriceUnitType getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(PriceUnitType priceUnit) {
		this.priceUnit = priceUnit;
	}
}