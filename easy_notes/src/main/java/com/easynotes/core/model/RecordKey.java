package com.easynotes.core.model;

public class RecordKey {
    private String entry;//词条

    private Integer dictionaryId;//所属字典的id

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public Integer getDictionaryId() {
        return dictionaryId;
    }

    public void setDictionaryId(Integer dictionaryId) {
        this.dictionaryId = dictionaryId;
    }
}