package com.easynotes.dao;

import org.apache.ibatis.annotations.Param;

import com.easynotes.core.base.BaseDao;
import com.easynotes.core.model.Dictionary;

public interface DictionaryDao extends BaseDao<Dictionary>{

	Dictionary queryByNameAndUserId(@Param("name")String name, @Param("userId")Integer userId);
   
}