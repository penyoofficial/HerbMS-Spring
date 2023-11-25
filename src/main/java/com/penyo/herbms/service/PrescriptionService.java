package com.penyo.herbms.service;

import com.penyo.herbms.pojo.PrescriptionBean;

import java.util.List;

/**
 * 经方的业务代理
 *
 * @author Penyo
 */
public class PrescriptionService extends GenericService<PrescriptionBean> {
  @Override
  public int add(PrescriptionBean o) {
    return pDAO.add(o);
  }

  @Override
  public int delete(int id) {
    return pDAO.delete(id);
  }

  @Override
  public int update(PrescriptionBean o) {
    return pDAO.update(o);
  }

  @Override
  public PrescriptionBean selectById(int id) {
    return pDAO.selectById(id);
  }

  @Override
  public List<PrescriptionBean> selectByFields(List<String> fields) {
    return pDAO.selectByFields(fields);
  }
}
