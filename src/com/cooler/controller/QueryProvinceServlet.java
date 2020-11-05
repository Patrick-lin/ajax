package com.cooler.controller;

import com.cooler.dao.QueryDao;
import com.cooler.entity.Province;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class QueryProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String json = "{}";
        //调用dao获取数据库数据；
        QueryDao dao = new QueryDao();
        List<Province> provinceList = dao.queryAllProvince();
        //将几何数据转化为json对象
        if (provinceList!=null){
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(provinceList);
        }
        //返回数据
        PrintWriter writer = response.getWriter();
        writer.println(json);
        writer.flush();
        writer.close();
    }
}
