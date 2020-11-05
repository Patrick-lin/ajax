package com.cooler.dao;

import com.cooler.entity.City;
import com.cooler.entity.Province;
import com.cooler.jdbc.JDBCutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QueryDao {
    //查询所有省份信息
    public List<Province> queryAllProvince(){
        String queryAllProvinceSql = "select * from province";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List provinceList = new ArrayList();
        try {
            connection = JDBCutil.getConnection("mysql");
            preparedStatement = connection.prepareStatement(queryAllProvinceSql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer provinceId = (Integer) resultSet.getInt("Id");
                String provinceName = resultSet.getString("Name");
                String abbreviation = resultSet.getString("abbreviation");
                String mainCity = resultSet.getString("mainCity");
                Province province = new Province(provinceId,provinceName,abbreviation,mainCity);
                provinceList.add(province);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            JDBCutil.closeSources(connection, preparedStatement, resultSet);
        }
        return provinceList;
    }

    public List<City> findAllcity(String provinceId) {
        String queryAllCitySql = "select * from city where provinceid = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List cityList = new ArrayList();
        try {
            connection = JDBCutil.getConnection("mysql");
            preparedStatement = connection.prepareStatement(queryAllCitySql);
            preparedStatement.setInt(1, Integer.parseInt(provinceId));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer cityId = (Integer) resultSet.getInt("Id");
                String cityName = resultSet.getString("Name");
                Integer provinceid = resultSet.getInt("provinceid");
                City city = new City(cityId,cityName,provinceid);
                cityList.add(city);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            JDBCutil.closeSources(connection, preparedStatement, resultSet);
        }
        return cityList;
    }
}
