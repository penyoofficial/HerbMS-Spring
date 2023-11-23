package com.penyo.herbms.dao;

import com.penyo.herbms.pojo.ExperienceBean;

import java.sql.SQLException;
import java.util.List;

/**
 * 中药使用心得的数据访问代理
 *
 * @author Penyo
 * @see com.penyo.herbms.pojo.ExperienceBean
 */
public class ExperienceDAO extends AbstractDAO<ExperienceBean> {
  protected final RowMapper<ExperienceBean> rm = (rs) -> {
    ExperienceBean exp = null;
    try {
      exp = new ExperienceBean(rs.getInt("id"), rs.getInt("herbId"), rs.getString("derivation"), rs.getString("content"));
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return exp;
  };

  protected ExperienceDAO() {
  }

  @Override
  public int add(ExperienceBean o) {
    if (select(o.getId()) != null) return 0;

    final String SQL = "insert experiences(herbId, derivation, content) values(?, ?, ?)";
    return runRawSQLToUpdate(SQL, o.getHerbId(), o.getDerivation(), o.getContent());
  }

  @Override
  public int delete(int id) {
    final String SQL = "delete from experiences where id=?";
    return runRawSQLToUpdate(SQL, id);
  }

  @Override
  public int update(ExperienceBean o) {
    if (select(o.getId()) == null) return 0;

    final String SQL = "update experiences set herbId=?, derivation=?, content=? where id=?";
    return runRawSQLToUpdate(SQL, o.getHerbId(), o.getDerivation(), o.getContent(), o.getId());
  }

  @Override
  public ExperienceBean select(int id) {
    ExperienceBean exp = null;
    final String SQL = "select * from experiences where id=?";
    List<ExperienceBean> exps = runRawSQLToQuery(rm, SQL, id);
    if (exps != null && !exps.isEmpty()) exp = exps.get(0);
    return exp;
  }

  @Override
  public List<ExperienceBean> select(String... fields) {
    if (fields.length == 1 && fields[0].isEmpty()) return selectAll();

    final String SQL = "select * from experiences where " + "concat(derivation, content) like concat('%', ?, '%') and ".repeat(fields.length);
    return runRawSQLToQuery(rm, SQL.substring(0, SQL.length() - 5), (Object[]) fields);
  }

  @Override
  public List<ExperienceBean> selectAll() {
    final String SQL = "select * from experiences";
    return runRawSQLToQuery(rm, SQL);
  }
}
