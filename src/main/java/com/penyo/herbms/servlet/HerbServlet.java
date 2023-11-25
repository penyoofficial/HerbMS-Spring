package com.penyo.herbms.servlet;

import com.penyo.herbms.pojo.HerbBean;
import com.penyo.herbms.pojo.ExperienceBean;
import com.penyo.herbms.service.HerbService;
import com.penyo.herbms.service.ExperienceService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 中药和中药使用心得的请求处理代理
 *
 * @author Penyo
 * @see com.penyo.herbms.pojo.HerbBean
 * @see com.penyo.herbms.pojo.ExperienceBean
 */
@WebServlet("/herbServlet")
public class HerbServlet extends GenericServlet<HerbBean, ExperienceBean, HerbService, ExperienceService> {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    doProcess(req, resp, new HerbService(), new ExperienceService());
    params.clear();
  }

  @Override
  protected HerbBean getAInstance() {
    return new HerbBean(Integer.parseInt(params.get("id")), Integer.parseInt(params.get("code")), params.get("name"), params.get("nickname"), params.get("type"), params.get("description"), params.get("efficacy"), params.get("taste"), params.get("origin"), params.get("dosage"), params.get("taboo"), params.get("processing"));
  }

  @Override
  protected ExperienceBean getBInstance() {
    return new ExperienceBean(Integer.parseInt(params.get("id")), Integer.parseInt(params.get("herbId")), params.get("derivation"), params.get("content"));
  }
}
