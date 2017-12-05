package com.xlzhang.word.data;

import java.util.ArrayList;
import java.util.List;

public class TemplateData {
    private String createDate;
    private String device;
    private String ip;
    private String purpose;
    private String factory;
    private String position;
    private String a;
    private String b;
    private String inspectDateCN;
    private String inspectDate;
    private Integer count;
    private Integer hcount;
    private Integer leve1;
    private Integer leve2;
    private Integer leve3;
    private Integer leve4;
    private String conclusion;
    private List<CMGrid> cmgrid = new ArrayList<CMGrid>();//设备连接数
    private List<CNGrid> cngrid = new ArrayList<CNGrid>();//CPU&内存使用率
    private List<TIGrid> tigrid = new ArrayList<TIGrid>();//设备响应时间&不可达率

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getInspectDateCN() {
        return inspectDateCN;
    }

    public void setInspectDateCN(String inspectDateCN) {
        this.inspectDateCN = inspectDateCN;
    }

    public String getInspectDate() {
        return inspectDate;
    }

    public void setInspectDate(String inspectDate) {
        this.inspectDate = inspectDate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getHcount() {
        return hcount;
    }

    public void setHcount(Integer hcount) {
        this.hcount = hcount;
    }

    public Integer getLeve1() {
        return leve1;
    }

    public void setLeve1(Integer leve1) {
        this.leve1 = leve1;
    }

    public Integer getLeve2() {
        return leve2;
    }

    public void setLeve2(Integer leve2) {
        this.leve2 = leve2;
    }

    public Integer getLeve3() {
        return leve3;
    }

    public void setLeve3(Integer leve3) {
        this.leve3 = leve3;
    }

    public Integer getLeve4() {
        return leve4;
    }

    public void setLeve4(Integer leve4) {
        this.leve4 = leve4;
    }

    public List<CMGrid> getCmgrid() {
        return cmgrid;
    }

    public void setCmgrid(List<CMGrid> cmgrid) {
        this.cmgrid = cmgrid;
    }

    public List<CNGrid> getCngrid() {
        return cngrid;
    }

    public void setCngrid(List<CNGrid> cngrid) {
        this.cngrid = cngrid;
    }

    public List<TIGrid> getTigrid() {
        return tigrid;
    }

    public void setTigrid(List<TIGrid> tigrid) {
        this.tigrid = tigrid;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}
