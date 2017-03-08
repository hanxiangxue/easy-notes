package com.easynotes.dao;

import org.apache.ibatis.annotations.Param;

import com.easynotes.core.base.BaseDao;
import com.easynotes.core.model.Record;

public interface RecordDao extends BaseDao<Record>{
    Integer delete(@Param("entry")String entry,@Param("dictionaryId")Integer dictionaryId);

    Record queryByPrimaryKey(@Param("entry")String entry,@Param("dictionaryId")Integer dictionaryId);

	Integer deleteBatch(@Param("entries")String[] entries, @Param("dictionaryId")Integer dictionaryId);


}