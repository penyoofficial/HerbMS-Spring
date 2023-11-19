package com.penyo.herbms.pojo;

/**
 * 中药使用心得的数据容器
 *
 * @author Penyo
 */
public class ExperienceBean extends AbstractBean {
  /**
   * 中草药 ID（外键）
   */
  private int herbId;
  /**
   * 出处
   */
  private String derivation;
  /**
   * 心得内容
   */
  private String content;

  public ExperienceBean() {
  }

  public ExperienceBean(int id, int herbId, String derivation, String content) {
    super(id);
    this.herbId = herbId;
    this.derivation = derivation;
    this.content = content;
  }

  public int getHerbId() {
    return herbId;
  }

  public void setHerbId(int herbId) {
    this.herbId = herbId;
  }

  public String getDerivation() {
    return derivation;
  }

  public void setDerivation(String derivation) {
    this.derivation = derivation;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
