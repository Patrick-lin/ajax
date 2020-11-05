package com.cooler.entity;

public class Province {
    private Integer provinceId;
    private String provinceName;
    private String abbreviation;
    private String mainCity;

    public Province(Integer provinceId, String provinceName, String abbreviation, String mainCity) {
        this.provinceId = provinceId;
        this.provinceName = provinceName;
        this.abbreviation = abbreviation;
        this.mainCity = mainCity;
    }

    @Override
    public String toString() {
        return "Province{" +
                "provinceId=" + provinceId +
                ", provinceName='" + provinceName + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", mainCity='" + mainCity + '\'' +
                '}';
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getMainCity() {
        return mainCity;
    }

    public void setMainCity(String mainCity) {
        this.mainCity = mainCity;
    }
}
