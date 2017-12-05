package com.xlzhang.zip;

import java.io.InputStream;

public class ZipInputStreamInfo {
	
	private InputStream inputStream;
	private String inputFileName;
	
	
	
	public ZipInputStreamInfo() {
		super();
	}
	public ZipInputStreamInfo(InputStream inputStream, String inputFileName) {
		super();
		this.inputStream = inputStream;
		this.inputFileName = inputFileName;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getInputFileName() {
		return inputFileName;
	}
	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}
	
}
