package myproject.intern.entities.product;

import myproject.intern.constants.Constants;
import myproject.intern.constants.PriceUnitType;
import myproject.intern.entities.AbstractDTOReader;

import java.io.IOException;


public class ProductMstDtoReader extends AbstractDTOReader<ProductMstDTO> {
	private static final int COLUMN_INDEX_PRODUCT_ID = 0;
	private static final int COLUMN_INDEX_PRODUCT_TYPE = 1;
	private static final int COLUMN_INDEX_PRODUCT_NAME = 2;
	private static final int COLUMN_INDEX_PRICE = 3;
	private static final int COLUMN_INDEX_PRICE_UNIT = 4;

	private String fileAddress = Constants.DEFAULT_CSV_FOLDER
			+ "PRODUCT_MST.csv";

	/**
	 * use default file address
	 * 
	 * @throws IOException
	 */
	public ProductMstDtoReader() throws IOException {
		super(ProductMstDtoReader.class.getName());
		super.init();
	}

	/**
	 * use customize file address
	 * 
	 * @param fileAddress
	 * @throws IOException
	 */
	public ProductMstDtoReader(final String fileAddress) throws IOException {
		super(ProductMstDtoReader.class.getName());
		this.fileAddress = fileAddress;
		super.init();
	}

	@Override
	protected String getFileArress() {
		return fileAddress;
	}

	@Override
	protected ProductMstDTO convertArrayToDTO(String[] value) throws IOException {

		Integer productMstId = Integer.valueOf(value[COLUMN_INDEX_PRODUCT_ID]);
		String productType = value[COLUMN_INDEX_PRODUCT_TYPE];
		String productName = value[COLUMN_INDEX_PRODUCT_NAME];
		double price = Double.parseDouble(value[COLUMN_INDEX_PRICE]);
		PriceUnitType priceUnit = PriceUnitType.valueOfString(value[COLUMN_INDEX_PRICE_UNIT]);

		//ProductMstDTO dto = new ProductMstDTO(productMstId, productType, productName, price, priceUnit);
		//return dto;
		return null;
	}
}
