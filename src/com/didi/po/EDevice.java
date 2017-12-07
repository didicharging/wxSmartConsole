package com.didi.po;

import java.math.BigDecimal;
import java.util.Date;

public class EDevice {
    private String id;

    private String deviceNo;

    private String userId;

    private String supplier;

    private String manager;

    private String owner;

    private String name;

    private Integer type;

    private String description;

    private Integer state;

    private BigDecimal shareMoney;

    private BigDecimal saveMoney;

    private String imgUrl;

    private Date createTime;

    private Date updateTime;

    private Integer rental;

    private BigDecimal price;

    private Integer rentalH;

    private Integer rentalM;

    private Integer rentalType;

    private Integer chargeDdb;

    private Integer isbuy;

    private Float kW;

    private Float kM;

    private Float kD;
    
    private Integer scaneCode;
    
    private BigDecimal money;
    
    private EUser owner_d;
    
    private EUser manager_d;
   
    private EUser user_d;
    
    private Integer changeDdb=111;
    
      
    public Integer getChangeDdb() {
		return changeDdb;
	}

	public void setChangeDdb(Integer changeDdb) {
		this.changeDdb = changeDdb;
	}

	public Integer getScaneCode() {
		return scaneCode;
	}

	public void setScaneCode(Integer scaneCode) {
		this.scaneCode = scaneCode;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public EUser getOwner_d() {
		return owner_d;
	}

	public void setOwner_d(EUser owner_d) {
		this.owner_d = owner_d;
	}

	public EUser getManager_d() {
		return manager_d;
	}

	public void setManager_d(EUser manager_d) {
		this.manager_d = manager_d;
	}

	public EUser getUser_d() {
		return user_d;
	}

	public void setUser_d(EUser user_d) {
		this.user_d = user_d;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo == null ? null : deviceNo.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public BigDecimal getShareMoney() {
        return shareMoney;
    }

    public void setShareMoney(BigDecimal shareMoney) {
        this.shareMoney = shareMoney;
    }

    public BigDecimal getSaveMoney() {
        return saveMoney;
    }

    public void setSaveMoney(BigDecimal saveMoney) {
        this.saveMoney = saveMoney;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getRental() {
        return rental;
    }

    public void setRental(Integer rental) {
        this.rental = rental;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getRentalH() {
        return rentalH;
    }

    public void setRentalH(Integer rentalH) {
        this.rentalH = rentalH;
    }

    public Integer getRentalM() {
        return rentalM;
    }

    public void setRentalM(Integer rentalM) {
        this.rentalM = rentalM;
    }

    public Integer getRentalType() {
        return rentalType;
    }

    public void setRentalType(Integer rentalType) {
        this.rentalType = rentalType;
    }

    public Integer getChargeDdb() {
        return chargeDdb;
    }

    public void setChargeDdb(Integer chargeDdb) {
        this.chargeDdb = chargeDdb;
    }

    public Integer getIsbuy() {
        return isbuy;
    }

    public void setIsbuy(Integer isbuy) {
        this.isbuy = isbuy;
    }

    public Float getkW() {
        return kW;
    }

    public void setkW(Float kW) {
        this.kW = kW;
    }

    public Float getkM() {
        return kM;
    }

    public void setkM(Float kM) {
        this.kM = kM;
    }

    public Float getkD() {
        return kD;
    }

    public void setkD(Float kD) {
        this.kD = kD;
    }
}