package com.xlzhang.zip;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

public class ZipUtils {

	
	private BuildZip buildZip;
	
	public BuildZip init(){
		
		if(buildZip==null){
			buildZip=new BuildZip();
		}
		return buildZip;
	}

	/**
	 * 创建zip输出流对象
	 * 
	 * @param out
	 * @param comment 描述可以为null
	 * @return
	 */
	public ZipOutputStream createZipOutputStream(OutputStream out,String comment) {
		ZipOutputStream hdzip = new ZipOutputStream(out);
		hdzip.setEncoding("UTF-8");
		if(comment!=null&&!comment.isEmpty()){
			hdzip.setComment(comment);
		}
		return hdzip;
	}
	public void closeZip(){
		
		
		
		
	}

	public void addZipFiles(final ZipOutputStream zipOut, final List<ZipInputStreamInfo> streamInfos,
			final String zipUrl) throws IOException {
		final byte[] buf = new byte[1024];
		int readLen = 0;
		if (!streamInfos.isEmpty()) {
			for (final ZipInputStreamInfo info : streamInfos) {

				final InputStream is = info.getInputStream();
				if (is == null) {
					continue;
				}
				zipOut.putNextEntry(new ZipEntry(zipUrl + "/" + info.getInputFileName()));
				// Transfer bytes from the file to the ZIP file
				while ((readLen = is.read(buf, 0, 1024)) != -1) {
					zipOut.write(buf, 0, readLen);
				}
			}

		}
	}
	public void addZip(final ZipOutputStream zipOut, final String fileUrl, final String zipUrl,String comment) throws IOException {
		int readLen = 0;
		final byte[] buf = new byte[1024];
		// name = new String((name).getBytes(), "UTF-8");
		zipOut.putNextEntry(new ZipEntry(zipUrl));
		// Transfer bytes from the file to the ZIP file
		InputStream is =new FileInputStream(fileUrl);
		if (is != null) {
			while ((readLen = is.read(buf, 0, 1024)) != -1) {
				zipOut.write(buf, 0, readLen);
			}
			is.close();
		}
		if(comment!=null&&!comment.isEmpty()){
			zipOut.setComment(comment);
		}
		
		zipOut.setEncoding("UTF-8");
	}
	public void addZip(final ZipOutputStream zipOut, final InputStream is, final String zipUrl,String comment) throws IOException {
		int readLen = 0;
		final byte[] buf = new byte[1024];
		// name = new String((name).getBytes(), "UTF-8");
		zipOut.putNextEntry(new ZipEntry(zipUrl));
		// Transfer bytes from the file to the ZIP file
		if (is != null) {
			while ((readLen = is.read(buf, 0, 1024)) != -1) {
				zipOut.write(buf, 0, readLen);
			}
			is.close();
		}
		if(comment!=null&&!comment.isEmpty()){
			zipOut.setComment(comment);
		}
		zipOut.setEncoding("UTF-8");
	}

}
