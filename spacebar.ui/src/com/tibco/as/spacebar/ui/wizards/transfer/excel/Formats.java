package com.tibco.as.spacebar.ui.wizards.transfer.excel;

import com.tibco.as.convert.Attribute;
import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ConverterFactory.Blob;

public class Formats {

	private Attributes conversion;

	public Formats() {
		this(new Attributes());
	}

	public Formats(Attributes conversion) {
		this.conversion = conversion;
	}

	public Blob getBlobFormat() {
		return conversion.get(Attribute.BLOB);
	}

	public void setBlobFormat(Blob blobFormat) {
		conversion.put(Attribute.BLOB, blobFormat);
	}

	public String getDateFormat() {
		return conversion.get(Attribute.DATE);
	}

	public void setDateFormat(String dateFormat) {
		conversion.put(Attribute.DATE, dateFormat);
	}

}
