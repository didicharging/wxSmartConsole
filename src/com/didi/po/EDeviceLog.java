package com.didi.po;

import java.util.Date;

public class EDeviceLog {
    private String id;

    private String userId;

    private String deviceId;

    private Date inDate;

    private Date outDate;

    private Integer totalFee;

    private Integer shareFee;

    private Integer walletFee;

    private String walletLogId;

    private Integer opration;

    private Integer ispay;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getShareFee() {
        return shareFee;
    }

    public void setShareFee(Integer shareFee) {
        this.shareFee = shareFee;
    }

    public Integer getWalletFee() {
        return walletFee;
    }

    public void setWalletFee(Integer walletFee) {
        this.walletFee = walletFee;
    }

    public String getWalletLogId() {
        return walletLogId;
    }

    public void setWalletLogId(String walletLogId) {
        this.walletLogId = walletLogId == null ? null : walletLogId.trim();
    }

    public Integer getOpration() {
        return opration;
    }

    public void setOpration(Integer opration) {
        this.opration = opration;
    }

    public Integer getIspay() {
        return ispay;
    }

    public void setIspay(Integer ispay) {
        this.ispay = ispay;
    }
}