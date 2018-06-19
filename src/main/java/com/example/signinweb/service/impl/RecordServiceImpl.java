package com.example.signinweb.service.impl;

import com.example.signinweb.bean.Record;
import com.example.signinweb.bean.Result;
import com.example.signinweb.dao.RecordDAO;
import com.example.signinweb.dao.impl.RecordDAOImpl;
import com.example.signinweb.enums.Code;
import com.example.signinweb.service.RecordService;
import com.example.signinweb.util.TimeUtil;

import java.sql.SQLException;
import java.util.List;

public class RecordServiceImpl implements RecordService {

    RecordDAO recordDAO = new RecordDAOImpl();

    @Override
    public Result getWeekRecords(String username, String week) {
        try {
            List<Record> records = recordDAO.getRecords(username, week);
            return new Result<>(Code.SUCCESS, records);
        } catch (SQLException e) {
            e.printStackTrace();
            return new Result<>(Code.MYSQL_ERROR, "mysql error");
        }
    }

    @Override
    public Result signIn() {
        return null;
    }

    @Override
    public Result signOut() {
        return null;
    }
}
