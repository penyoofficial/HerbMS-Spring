package com.penyo.herbms.servlet;

import com.penyo.herbms.pojo.PrescriptionInfoBean;
import com.penyo.herbms.pojo.PrescriptionBean;
import com.penyo.herbms.service.PrescriptionInfoService;
import com.penyo.herbms.service.PrescriptionService;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 经方和经方概要的请求处理层
 *
 * @author hawkkie
 * @see com.penyo.herbms.pojo.PrescriptionInfoBean
 * @see com.penyo.herbms.pojo.PrescriptionBean
 */
@WebServlet(name = "PrescriptionServlet", urlPatterns = "/WEB-INF/views/prescriptionServlet")
public class PrescriptionServlet extends AbstractServlet<PrescriptionInfoBean, PrescriptionBean, PrescriptionInfoService, PrescriptionService> {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    doProcess(req, new PrescriptionInfoService(), new PrescriptionService());
    resp.sendRedirect("prescription.jsp");
  }

  @Override
  protected PrescriptionInfoBean getAInstance(Map<String, String> params) {
    return new PrescriptionInfoBean(Integer.parseInt(params.get("id")), params.get("name"), params.get("nickname"), params.get("description"));
  }

  @Override
  protected PrescriptionBean getBInstance(Map<String, String> params) {
    return new PrescriptionBean(Integer.parseInt(params.get("id")), Integer.parseInt(params.get("prescriptionId")), Integer.parseInt("herbId"), params.get("dosage"), params.get("usage"));
  }
}
