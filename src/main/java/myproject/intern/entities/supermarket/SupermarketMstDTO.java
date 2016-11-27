package myproject.intern.entities.supermarket;


import myproject.intern.entities.ICsvMasterDTO;

public class SupermarketMstDTO implements ICsvMasterDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3711231132225687846L;
	private Long supermarketId;
	private String address;
	private String tel;

	/**
	 * Default Constructor 
	 * 
	 * @param supermarketId
	 * @param address
	 * @param tel
	 */
	public SupermarketMstDTO(Long supermarketId, String address,
			String tel) {
		super();
		this.supermarketId = supermarketId;
		this.address = address;
		this.tel = tel;
	}

	public Long getSupermarketId() {
		return supermarketId;
	}

	public void setSupermarketId(Long supermarketId) {
		this.supermarketId = supermarketId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
