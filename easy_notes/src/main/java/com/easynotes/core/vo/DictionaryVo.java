package com.easynotes.core.vo;

import com.easynotes.core.base.BaseVo;
import com.easynotes.core.model.Dictionary;

@SuppressWarnings("serial")
public class DictionaryVo extends BaseVo<Dictionary>{
	private Integer id;//字典id

    private String name;//字典名

    private Integer type;//字典类型
      

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    
}
