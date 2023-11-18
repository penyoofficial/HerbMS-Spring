package com.penyo.herbms.dao;

import java.util.List;

import com.penyo.herbms.pojo.HerbBean;

/**
 * 中药的数据访问代理。
 *
 * @author Penyo
 * @see com.penyo.herbms.pojo.HerbBean
 */
public class HerbDAO extends AbstractDAO<HerbBean> {
  final RowMapper<HerbBean> rm = (rs) -> {
    HerbBean h = null;
    try {
      h = new HerbBean(rs.getInt("id"), rs.getInt("code"), rs.getString("name"), rs.getString("nickname"), rs.getString("type"), rs.getString("description"), rs.getString("efficacy"), rs.getString("taste"), rs.getString("origin"), rs.getString("dosage"), rs.getString("taboo"), rs.getString("processing"));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return h;
  };

  protected HerbDAO() {
  }

  @Override
  public int add(HerbBean o) {
    final String SQL = "insert herbs(code, name, nickname, type, description, efficacy, taste, origin, dosage, taboo, processing) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    return runRawSQLToUpdate(SQL, o.getCode(), o.getName(), o.getNickname(), o.getType(), o.getDescription(), o.getEfficacy(), o.getTaste(), o.getOrigin(), o.getDosage(), o.getTaboo(), o.getProcessing());
  }

  @Override
  public int delete(int id) {
    final String SQL = "delete from herbs where id=?";
    return runRawSQLToUpdate(SQL, id);
  }

  @Override
  public HerbBean select(int id) {
    HerbBean h = null;
    final String SQL = "select * from herbs where id=?";
    List<HerbBean> hs = runRawSQLToQuery(rm, SQL, id);
    if (hs != null && hs.size() > 0) h = hs.get(0);
    return h;
  }

  @Override
  public List<HerbBean> selectAll() {
    final String SQL = "select * from herbs";
    return runRawSQLToQuery(rm, SQL);
  }

  @Override
  public int update(HerbBean o) {
    final String SQL = "update herbs set code=?, name=?, nickname=?, type=?, description=?, efficacy=?, taste=?, origin=?, dosage=?, taboo=?, processing=? where id=?";
    return runRawSQLToUpdate(SQL, o.getCode(), o.getName(), o.getNickname(), o.getType(), o.getDescription(), o.getEfficacy(), o.getTaste(), o.getOrigin(), o.getDosage(), o.getTaboo(), o.getProcessing(), o.getId());
  }
}