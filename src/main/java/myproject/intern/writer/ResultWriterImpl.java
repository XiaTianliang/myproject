package myproject.intern.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


import myproject.intern.constants.Constants;
import myproject.intern.constants.Messages;
import myproject.intern.util.Utilities;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

/**
 * Implementation of IResultWriter.
 * 
 */
public class ResultWriterImpl implements IResultWriter {

	private static final String DEFAULT_OUTPUT_FILE_NAME = "result.csv";

	private static final Log logger = LogFactory.getLog(ResultWriterImpl.class);
	private final String outFilePath;

	/**
	 * use default output file name and path
	 */
	public ResultWriterImpl() {
		outFilePath = Constants.DEFAULT_CSV_OUTPUT_FOLDER
				+ DEFAULT_OUTPUT_FILE_NAME;
	}

	/**
	 * use customize output file address (path + name)
	 * 
	 * @param fileAddress
	 */
	public ResultWriterImpl(String fileAddress) {
		this.outFilePath = fileAddress;
	}

	@Override
	public void writeResult(List<String[]> result) {
		CSVWriter writer = null;
		try {
			writer = new CSVWriter(new FileWriter(outFilePath),
					Constants.DEFAULT_CSV_SEPARATOR,
					Constants.DEFAULT_CSV_QUOTECHAR);
			writer.writeAll(result);
		} catch (IOException e) {
			logger.fatal(Messages.ERROR_WRITE_CSV, e);
			throw new RuntimeException(e);
		} finally {
			Utilities.closeSilently(writer);
		}
	}

}
