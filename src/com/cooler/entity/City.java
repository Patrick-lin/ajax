package com.cooler.entity;

import java.util.Objects;

public class City {
    private Integer cityId;
    private String cityName;
    private Integer provinceId;

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", provinceId=" + provinceId +
                '}';
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public City(Integer cityId, String cityName, Integer provinceId) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.provinceId = provinceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(getCityId(), city.getCityId()) &&
                Objects.equals(getCityName(), city.getCityName()) &&
                Objects.equals(getProvinceId(), city.getProvinceId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCityId(), getCityName(), getProvinceId());
    }
}
