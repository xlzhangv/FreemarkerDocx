package com.xlzhang.word.data;

import java.util.ArrayList;
import java.util.List;

public class ChartData {
	private String titleIndex;
	private String legend;
	private List<SeriesData> sublist = new ArrayList<SeriesData>();
	/**
	 * @return the titleIndex
	 */
	public String getTitleIndex() {
		return titleIndex;
	}
	/**
	 * @param titleIndex the titleIndex to set
	 */
	public void setTitleIndex(String titleIndex) {
		this.titleIndex = titleIndex;
	}
	/**
	 * @return the legend
	 */
	public String getLegend() {
		return legend;
	}
	/**
	 * @param legend the legend to set
	 */
	public void setLegend(String legend) {
		this.legend = legend;
	}
	/**
	 * @return the sublist
	 */
	public List<SeriesData> getSublist() {
		return sublist;
	}
	/**
	 * @param sublist the sublist to set
	 */
	public void setSublist(List<SeriesData> sublist) {
		this.sublist = sublist;
	}
	
}
