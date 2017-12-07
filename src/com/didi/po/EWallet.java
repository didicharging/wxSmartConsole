package com.didi.po;

import java.math.BigDecimal;
import java.util.Date;

public class EWallet {
    private String id;

    private String userId;

    private Integer amount;

    private BigDecimal shareAmount;

    private Integer role;

    private Date deadtime;

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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getShareAmount() {
        return shareAmount;
    }

    public void setShareAmount(BigDecimal shareAmount) {
        this.shareAmount = shareAmount;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Date getDeadtime() {
        return deadtime;
    }

    public void setDeadtime(Date deadtime) {
        this.deadtime = deadtime;
    }
}