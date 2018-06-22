package com.example.signinweb.service.impl;

import com.example.signinweb.bean.Record;
import com.example.signinweb.bean.Result;
import com.example.signinweb.dao.RecordDAO;
import com.example.signinweb.dao.impl.RecordDAOImpl;
import com.example.signinweb.enums.Code;
import com.example.signinweb.service.RecordService;
import com.example.signinweb.util.TimeUtil;

import java.sql.SQLException;
import java.util.Date;
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
    public Result signInFirstTime(String username, Date time) {
        try {
            long id = recordDAO.insertRecord(username, TimeUtil.getWeekIdentifier(), TimeUtil.getDayOfWeek(),
                    time, TimeUtil.getDayPeriod());
            return new Result<>(Code.SUCCESS, id);
        } catch (SQLException e) {
            e.printStackTrace();
            return new Result<>(Code.MYSQL_ERROR, "mysql error");
        }
    }

    @Override
    public Result signInUpdate(long id, Date time) {
        try {
            Record record = recordDAO.getRecordById(id);
            int count = record.getCount() + 1800;
            recordDAO.updateRecord(id, time, count, TimeUtil.getDayPeriod(), true);
            return new Result<>(Code.SUCCESS, "");
        } catch (SQLException e) {
            e.printStackTrace();
            return new Result<>(Code.MYSQL_ERROR, "mysql error");
        }
    }


    @Override
    public Result signOut(long id, Date time) {
        try {
            Record record = recordDAO.getRecordById(id);
            int count = record.getCount();
            long inTime = 0;
            int periodOfDay = TimeUtil.getDayPeriod();

            switch (periodOfDay) {
                case 0:
                    inTime = record.getIn_time_mor().getTime() / 1000;
                    break;
                case 1:
                    inTime = record.getIn_time_noon().getTime() / 1000;
                    break;
                case 2:
                    inTime = record.getIn_time_eve().getTime() / 1000;
                    break;
                default:
                    break;
            }

            int add = (int)(time.getTime() / 1000 - inTime);
            if (add > 1800) {
                count = count + add - 1800;
            }

            recordDAO.updateRecord(id, time, count, periodOfDay, false);
            return new Result<>(Code.SUCCESS, "");
        } catch (SQLException e) {
            e.printStackTrace();
            return new Result<>(Code.MYSQL_ERROR, "mysql error");
        }
    }
}
