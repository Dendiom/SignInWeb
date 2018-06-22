package com.example.signinweb.dao;

import com.example.signinweb.bean.Record;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface RecordDAO {
    List<Record> getRecords(String username, String week) throws SQLException;
    Record getRecordByUsername(String username, String week, int dayOfWeek) throws SQLException;
    Record getRecordById(long id) throws SQLException;
    Long insertRecord(String username, String week, int dayOfWeek, Date time, int periodOfDay) throws SQLException;
    void updateRecord(long id, Date time, int count, int periodOfDay, boolean in) throws SQLException;
}
