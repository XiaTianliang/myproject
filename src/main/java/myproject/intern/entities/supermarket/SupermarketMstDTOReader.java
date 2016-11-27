package myproject.intern.entities.supermarket;

import myproject.intern.constants.Constants;
import myproject.intern.entities.AbstractDTOReader;

import java.io.IOException;


public class SupermarketMstDTOReader extends AbstractDTOReader<SupermarketMstDTO> {
	private static final int COLUMN_INDEX_SUPERMARKET_ID = 0;
	private static final int COLUMN_INDEX_ADDRESS = 1;
	private static final int COLUMN_INDEX_TEL = 2;


	private String fileAddress = Constants.DEFAULT_CSV_FOLDER+"SUPERMARKET_MST.csv";

	/**
	 * use default file address
	 *
	 * @throws IOException
	 */
	public SupermarketMstDTOReader() throws IOException {
		super(SupermarketMstDTOReader.class.getName());
		super.init();
	}

	/**
	 * use customize file address
	 *
	 * @param fileAddress
	 * @throws IOException
	 */
	public SupermarketMstDTOReader(final String fileAddress) throws IOException {
		super(SupermarketMstDTOReader.class.getName());
		this.fileAddress = fileAddress;
		super.init();
	}

	@Override
	protected String getFileArress() {
		return fileAddress;
	}

	@Override
	protected SupermarketMstDTO convertArrayToDTO(String[] value) throws IOException {

		Long supermarketId = Long.valueOf(value[COLUMN_INDEX_SUPERMARKET_ID]);
		String address = value[COLUMN_INDEX_ADDRESS];
		String tel = value[COLUMN_INDEX_TEL];

//		private Long supermarketId;
//		private String address;
//		private String tel;

		SupermarketMstDTO dto = new SupermarketMstDTO(supermarketId, address, tel);
		return dto;
	}
}
