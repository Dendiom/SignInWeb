package com.example.signinweb.dao;

import com.example.signinweb.bean.Record;
import com.example.signinweb.bean.Result;

import java.util.List;

public interface RecordDAO {
    List<Record> getRecords(String username, long week);
    void updateRecord();
}
