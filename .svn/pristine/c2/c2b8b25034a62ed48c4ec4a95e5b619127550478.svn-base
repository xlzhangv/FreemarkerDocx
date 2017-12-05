package com.xlzhang.word;

import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.tools.zip.*;

import com.xlzhang.poi.PoiReadExcelUtil;
import com.xlzhang.poi.celltool.ReadWork;
import com.xlzhang.poi.data.vo.CellDataFiled;
import com.xlzhang.word.data.*;
import com.xlzhang.zip.ByteArrayOs2Is;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import org.joda.time.DateTime;

public class XMLToDocx {
    /**
     * @param docxTemplate docx的模板
     * @param toFilePath   需要导出的文件路径
     */

    public void outDocx(String toFilePath,TemplateData documentData,Map<String, SeriesData> chartData) {

      

        FreeMarkerWordUtil freeMarkerWordUtil = FreeMarkerWordUtil.getInstance().buildConfig(new BuildConfiguration() {

            public void setConfig(Configuration cfg) {
            	cfg.setClassLoaderForTemplateLoading(XMLToDocx.class.getClassLoader(), "template");
            }
        });

        
        try {
            File docxFile = new File(java.net.URLDecoder.decode(XMLToDocx.class.getClassLoader().getResource("template/template.docx").getPath(),"utf-8"));
            
            ZipFile zipFile = new ZipFile(docxFile);
            Enumeration<? extends ZipEntry> zipEntrys = zipFile.getEntries();
            ZipOutputStream zipout = new ZipOutputStream(new FileOutputStream(toFilePath));
            int len = -1;
            byte[] buffer = new byte[1024];
            while (zipEntrys.hasMoreElements()) {
                ZipEntry next = zipEntrys.nextElement();
                InputStream is = zipFile.getInputStream(next);
                // 把输入流的文件传到输出流中 如果是word/document.xml由我们输入
                zipout.putNextEntry(new ZipEntry(next.toString()));

                if ("word/document.xml".equals(next.toString())) {

                    ByteArrayOs2Is os2Is = new ByteArrayOs2Is();

                    freeMarkerWordUtil.createWord(os2Is, "document.xml", documentData);

                    InputStream in = os2Is.asInputStream();
                    while ((len = in.read(buffer)) != -1) {
                        zipout.write(buffer, 0, len);
                    }
                    in.close();
                } else if (next.toString().matches("word/charts/chart\\d+.xml")) {
                    ByteArrayOs2Is os2Is = new ByteArrayOs2Is();
                    String chartName = next.toString().substring(next.toString().lastIndexOf("/") + 1);
                    freeMarkerWordUtil.createWord(os2Is, chartName, chartData.get(chartName));
                    InputStream in = os2Is.asInputStream();
                    while ((len = in.read(buffer)) != -1) {
                        zipout.write(buffer, 0, len);
                    }
                    in.close();
                } else if (next.toString().lastIndexOf("word/embeddings/") != -1) {
                    System.err.println("忽略");
                    ByteArrayOs2Is os2Is = new ByteArrayOs2Is();
                    PoiReadExcelUtil excel = PoiReadExcelUtil.getInstance().readInputStream(is);

                    excel.readSheets(0, -1, new ReadWork() {

                        public void read(PoiReadExcelUtil readExcel, Workbook workbook, Sheet sheet, int sheetIndex,
                                         int startRow, int endRow) {
                            // 遍历每一
                            for (int r = startRow; r < endRow; r++) {
                                System.out.println(new String().format("开始行：%s;结束行：%s", startRow, endRow));
                                Row row = sheet.getRow(r);

                                int cellCount = row.getPhysicalNumberOfCells(); // 获取总列
                                for (int c = 0; c < cellCount; c++) {
                                    CellDataFiled cellDataFiled = readExcel.getCellDataFiled(sheet, r, c);
                                    cellDataFiled.getCell().setCellValue("");
                                }

                            }

                        }
                    }).copyWirte(os2Is);

                    excel.end();

                    InputStream in = os2Is.asInputStream();
                    while ((len = in.read(buffer)) != -1) {
                        zipout.write(buffer, 0, len);
                    }
                    in.close();
                } else {
                    while ((len = is.read(buffer)) != -1) {
                        zipout.write(buffer, 0, len);
                    }
                    is.close();
                }
            }
            zipout.close();
            System.err.println("完成.......");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void buildSeriesData(DateTime dateTime, Map<String, SeriesData> chartData) {

        SeriesData seriesData1 = new SeriesData();
        for (int i = 0; i < 24; i++) {
            seriesData1.getNames().add(dateTime.minusHours(i).toString("HH:00"));
            seriesData1.getValues1().add(100 * Math.random());//连接数

        }
        chartData.put("chart1.xml", seriesData1);
        //-----------------------------------------------------------
        SeriesData seriesData2 = new SeriesData();
        for (int i = 0; i < 24; i++) {
            seriesData2.getNames().add(dateTime.minusHours(i).toString("HH:00"));
            seriesData2.getValues1().add(100 * Math.random());//出口流量(MB)
            seriesData2.getValues2().add(100 * Math.random());//入口流量(MB)
            seriesData2.getValues3().add(100 * Math.random());//出口带宽占比
            seriesData2.getValues4().add(100 * Math.random());//入口带宽占比

        }
        chartData.put("chart2.xml", seriesData2);
        //-----------------------------------------------------------
        SeriesData seriesData3 = new SeriesData();
        for (int i = 0; i < 24; i++) {
            seriesData3.getNames().add(dateTime.minusHours(i).toString("HH:00"));
            seriesData3.getValues1().add(100 * Math.random()); //出口流量(MB)
            seriesData3.getValues2().add(100 * Math.random()); //入口流量(MB)
            seriesData3.getValues3().add(100 * Math.random()); //出口带宽占比
            seriesData3.getValues4().add(100 * Math.random()); //入口带宽占比

        }
        chartData.put("chart3.xml", seriesData3);
        //-----------------------------------------------------------
        SeriesData seriesData4 = new SeriesData();
        for (int i = 0; i < 24; i++) {
            seriesData4.getNames().add(dateTime.minusHours(i).toString("HH:00"));
            seriesData4.getValues1().add(100 * Math.random());//出口流量(MB)
            seriesData4.getValues2().add(100 * Math.random());//入口流量(MB)
            seriesData4.getValues3().add(100 * Math.random());//出口带宽占比
            seriesData4.getValues4().add(100 * Math.random());//入口带宽占比

        }
        chartData.put("chart4.xml", seriesData4);
        //-----------------------------------------------------------
        SeriesData seriesData5 = new SeriesData();
        for (int i = 0; i < 24; i++) {
            seriesData5.getNames().add(dateTime.minusHours(i).toString("HH:00"));
            seriesData5.getValues1().add(100 * Math.random());//出口流量(MB)
            seriesData5.getValues2().add(100 * Math.random());//入口流量(MB)
            seriesData5.getValues3().add(100 * Math.random());//出口带宽占比
            seriesData5.getValues4().add(100 * Math.random());//入口带宽占比

        }
        chartData.put("chart5.xml", seriesData5);
        //-----------------------------------------------------------
        SeriesData seriesData6 = new SeriesData();
        for (int i = 0; i < 24; i++) {
            seriesData6.getNames().add(dateTime.minusHours(i).toString("HH:00"));
            seriesData6.getValues1().add(100 * Math.random());//出口流量(MB)
            seriesData6.getValues2().add(100 * Math.random());//入口流量(MB)
            seriesData6.getValues3().add(100 * Math.random());//出口带宽占比
            seriesData6.getValues4().add(100 * Math.random());//入口带宽占比

        }
        chartData.put("chart6.xml", seriesData6);
        //-----------------------------------------------------------
        SeriesData seriesData7 = new SeriesData();
        for (int i = 0; i < 24; i++) {
            seriesData7.getNames().add(dateTime.minusHours(i).toString("HH:00"));
            seriesData7.getValues1().add(100 * Math.random());//出口流量(MB)
            seriesData7.getValues2().add(100 * Math.random());//入口流量(MB)
            seriesData7.getValues3().add(100 * Math.random());//出口带宽占比
            seriesData7.getValues4().add(100 * Math.random());//入口带宽占比

        }
        chartData.put("chart7.xml", seriesData7);
        //-----------------------------------------------------------
        SeriesData seriesData8 = new SeriesData();
        for (int i = 0; i < 24; i++) {
            seriesData8.getNames().add(dateTime.minusHours(i).toString("HH:00"));
            seriesData8.getValues1().add(100 * Math.random());//出口流量(MB)
            seriesData8.getValues2().add(100 * Math.random());//入口流量(MB)
            seriesData8.getValues3().add(100 * Math.random());//出口带宽占比
            seriesData8.getValues4().add(100 * Math.random());//入口带宽占比

        }
        chartData.put("chart8.xml", seriesData8);
        //-----------------------------------------------------------
        SeriesData seriesData9 = new SeriesData();
        for (int i = 0; i < 24; i++) {
            seriesData9.getNames().add(dateTime.minusHours(i).toString("HH:00"));
            seriesData9.getValues1().add(100 * Math.random());//出口流量(MB)
            seriesData9.getValues2().add(100 * Math.random());//入口流量(MB)
            seriesData9.getValues3().add(100 * Math.random());//出口带宽占比
            seriesData9.getValues4().add(100 * Math.random());//入口带宽占比

        }
        chartData.put("chart9.xml", seriesData9);
        //-----------------------------------------------------------
        SeriesData seriesData10 = new SeriesData();
        for (int i = 0; i < 24; i++) {
            seriesData10.getNames().add(dateTime.minusHours(i).toString("HH:00"));
            seriesData10.getValues1().add(100 * Math.random());//CPU-TOTAL（%）
            seriesData10.getValues2().add(100 * Math.random());//avg memory（%）

        }
        chartData.put("chart10.xml", seriesData10);
        //-----------------------------------------------------------
        SeriesData seriesData11 = new SeriesData();
        for (int i = 0; i < 24; i++) {
            seriesData11.getNames().add(dateTime.minusHours(i).toString("HH:00"));
            seriesData11.getValues1().add(100 * Math.random());//响应时间（ms）
            seriesData11.getValues2().add(100 * Math.random());//不可达率（%）

        }
        chartData.put("chart11.xml", seriesData11);
    }

    public static void main(String[] args) {

        // 设置docx的模板路径 和文件名
        String toFilePath = "/Users/zhangxiaolong/Downloads/template/test1.docx";
        
        try {
			System.err.println(java.net.URLDecoder.decode(XMLToDocx.class.getClassLoader().getResource("template/template.docx").getPath(),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        DateTime dateTime = new DateTime();

        TemplateData data = new TemplateData();

        data.setA("一级网核心路由器—城域网核心交换机1（10.254.254.10）");
        data.setB("一级网核心路由器—城域网核心交换机2（10.254.254.11）");
        data.setCreateDate(dateTime.toString("yyyy/MM/dd"));
        data.setDevice("NE500E-2");
        data.setFactory("华为");
        data.setInspectDate(dateTime.minusDays(1).toString("yyyy-MM-dd 08:00")+"~"+dateTime.toString("yyyy-MM-dd 08:00"));
        data.setIp("10.254.254.5");
        data.setPosition("公安部信息中心机房");
        data.setPurpose("一级网核心路由器");
        data.setHcount(0);
        data.setCount(0);
        data.setLeve1(0);
        data.setLeve2(0);
        data.setLeve3(0);
        data.setLeve4(0);
        data.setConclusion("巡检设备未发现异常!");


        Map<String, SeriesData> chartData = new HashMap<String, SeriesData>();

        for (int i = 0; i < 24; i++) {
            CMGrid cMGrid = new CMGrid();
            cMGrid.setTime(dateTime.minusHours(i).toString("yyyy-MM-dd HH:00"));
            cMGrid.setIp("10.254.254.5");
            cMGrid.setCpu(100 * Math.random());
            cMGrid.setMemory(100 * Math.random());
            data.getCmgrid().add(cMGrid);
            CNGrid cNGrid = new CNGrid();
            cNGrid.setTime(dateTime.minusHours(i).toString("yyyy-MM-dd HH:00"));
            cNGrid.setIp("10.254.254.5");
            cNGrid.setCount(Math.round(10000 * Math.random()));
            data.getCngrid().add(cNGrid);
            TIGrid tIGrid = new TIGrid();
            tIGrid.setTime(dateTime.minusHours(i).toString("yyyy-MM-dd HH:00"));
            tIGrid.setIp("10.254.254.5");
            tIGrid.setDelay(100 * Math.random());
            tIGrid.setRate(0 * Math.random());
            data.getTigrid().add(tIGrid);
        }

        buildSeriesData(dateTime, chartData);

        new XMLToDocx().outDocx(toFilePath,data,chartData);
    }
}
