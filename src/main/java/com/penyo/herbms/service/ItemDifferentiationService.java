package com.penyo.herbms.service;

import com.penyo.herbms.pojo.ItemDifferentiationBean;
import com.penyo.herbms.util.NeedRebuild;

import java.util.ArrayList;
import java.util.List;

/**
 * 条辩的业务层
 *
 * @author lyh
 */
@NeedRebuild
public class ItemDifferentiationService extends AbstractService {
  /**
   * 添加单个元素。
   */
  public int add(ItemDifferentiationBean o) {
    return idtDAO.add(o);
  }

  /**
   * 根据 ID 删除单个元素。
   */
  public int deleteById(int id) {
    return idtDAO.delete(id);
  }

  /**
   * 根据 ID 查找单个元素。
   */
  public ItemDifferentiationBean selectById(int id) {
    return idtDAO.select(id);
  }

  /**
   * 修改单个元素。
   */
  public int update(ItemDifferentiationBean o) {
    return idtDAO.update(o);
  }

  /**
   * 根据字段查找元素。
   */
  public List<ItemDifferentiationBean> selectByField(String field) {
    if (field.isEmpty()) return idtDAO.selectAll();
    List<ItemDifferentiationBean> idts = new ArrayList<>();
    for (ItemDifferentiationBean h : idtDAO.selectAll())
      if (h.getType().contains(field)) idts.add(h);
    return idts;
  }
}
