package com.didi.po;

import java.util.Date;

public class EScaneLog {
    private String id;

    private String userId;

    private String deviceId;

    private Date startDate;

    private Date endDate;

    private Integer opration;
    
    private EUser user;
    
    private EDevice device;
    
   
    public EDevice getDevice() {
		return device;
	}

	public void setDevice(EDevice device) {
		this.device = device;
	}

	public EUser getUser() {
		return user;
	}

	public void setUser(EUser user) {
		this.user = user;
	}

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getOpration() {
        return opration;
    }

    public void setOpration(Integer opration) {
        this.opration = opration;
    }

	@Override
	public String toString() {
		return "EScaneLog [id=" + id + ", userId=" + userId + ", deviceId=" + deviceId + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", opration=" + opration + "]";
	}
    
    
}