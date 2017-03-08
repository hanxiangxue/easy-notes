package com.easynotes.core.model;

import java.util.Date;
/**
 * 记录javabean.一个字典里面不能有两个（含以上）相同的entry
 * @author Administrator
 *
 */
public class Record extends RecordKey {
    private Integer state;//记录状态。1为有效，0为注销

    private Date createTime;//创建时间

    private Date updateTime;//更新时间

    private String paraphrase;//词条对应的解释

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getParaphrase() {
        return paraphrase;
    }

    public void setParaphrase(String paraphrase) {
        this.paraphrase = paraphrase;
    }

	@Override
	public String toString() {
		return "Record [state=" + state + ", createTime=" + createTime + ", updateTime=" + updateTime + ", paraphrase="
				+ paraphrase + "]";
	}
    
}