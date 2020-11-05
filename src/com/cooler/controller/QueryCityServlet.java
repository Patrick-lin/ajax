package com.cooler.controller;

import com.cooler.dao.QueryDao;
import com.cooler.entity.City;
import com.cooler.entity.Province;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class QueryCityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String json = "{}";
        QueryDao dao = new QueryDao();
        String provinceId = request.getParameter("provinceId");
        List<City> cityList =  dao.findAllcity(provinceId);
        //将返回数据转化为json格式
        if (cityList!=null){
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(cityList);
        }
        //返回数据
        PrintWriter writer = response.getWriter();
        writer.println(json);
        writer.flush();
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
