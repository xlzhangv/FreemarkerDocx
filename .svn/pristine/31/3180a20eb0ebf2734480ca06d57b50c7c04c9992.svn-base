package com.xlzhang.zip;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

public class BuildZip {

	private BuildZip buildZip;
	private ZipOutputStream zipOutputStream;

	public BuildZip init() {
		if (buildZip == null) {
			buildZip = new BuildZip();
		}
		return buildZip;
	}

	/**
	 * 创建zip输出流对象
	 * 
	 * @param out
	 * @param comment
	 *            描述可以为null
	 * @return
	 */
	public BuildZip createZipOutputStream(OutputStream out, String comment) {
		zipOutputStream = new ZipOutputStream(out);
		zipOutputStream.setEncoding("UTF-8");
		if (comment != null && !comment.isEmpty()) {
			zipOutputStream.setComment(comment);
		}
		return this;
	}

	/**
	 * 关闭压缩包
	 * 
	 * @param hdzip
	 */
	public void closeZip() {
		try {
			this.zipOutputStream.closeEntry();
			this.zipOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public BuildZip addZipFiles(final List<ZipInputStreamInfo> streamInfos, final String zipUrl) throws IOException {
		final byte[] buf = new byte[1024];
		int readLen = 0;
		if (!streamInfos.isEmpty()) {
			for (final ZipInputStreamInfo info : streamInfos) {

				final InputStream is = info.getInputStream();
				if (is == null) {
					continue;
				}
				this.zipOutputStream.putNextEntry(new ZipEntry(zipUrl + "/" + info.getInputFileName()));
				// Transfer bytes from the file to the ZIP file
				while ((readLen = is.read(buf, 0, 1024)) != -1) {
					this.zipOutputStream.write(buf, 0, readLen);
				}
			}
		}
		return this;
	}

	public BuildZip addZip(final String fileUrl, final String zipUrl, String comment) throws IOException {
		int readLen = 0;
		final byte[] buf = new byte[1024];
		// name = new String((name).getBytes(), "UTF-8");
		this.zipOutputStream.putNextEntry(new ZipEntry(zipUrl));
		// Transfer bytes from the file to the ZIP file
		InputStream is = new FileInputStream(fileUrl);
		if (is != null) {
			while ((readLen = is.read(buf, 0, 1024)) != -1) {
				this.zipOutputStream.write(buf, 0, readLen);
			}
			is.close();
		}
		if (comment != null && !comment.isEmpty()) {
			this.zipOutputStream.setComment(comment);
		}

		this.zipOutputStream.setEncoding("UTF-8");
		return this;
	}

	public BuildZip addZip(final InputStream is, final String zipUrl, String comment) throws IOException {
		int readLen = 0;
		final byte[] buf = new byte[1024];
		// name = new String((name).getBytes(), "UTF-8");
		this.zipOutputStream.putNextEntry(new ZipEntry(zipUrl));
		// Transfer bytes from the file to the ZIP file
		if (is != null) {
			while ((readLen = is.read(buf, 0, 1024)) != -1) {
				this.zipOutputStream.write(buf, 0, readLen);
			}
			is.close();
		}
		if (comment != null && !comment.isEmpty()) {
			this.zipOutputStream.setComment(comment);
		}
		this.zipOutputStream.setEncoding("UTF-8");
		return this;
	}
}
