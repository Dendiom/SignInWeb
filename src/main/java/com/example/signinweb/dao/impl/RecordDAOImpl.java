package com.example.signinweb.dao.impl;

import com.example.signinweb.bean.Record;
import com.example.signinweb.dao.RecordDAO;
import com.example.signinweb.lib.mysql.C3p0Helper;
import com.example.signinweb.util.SQLUtil;
import com.example.signinweb.util.TimeUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class RecordDAOImpl implements RecordDAO {

    @Override
    public List<Record> getRecords(String username, String week) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Helper.getDataSource());
        return queryRunner.query("select * from record where username = ? and week = ?",
                new BeanListHandler<>(Record.class), username, week);
    }

    @Override
    public Record getRecordByUsername(String username, String week, int dayOfWeek) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Helper.getDataSource());
        return queryRunner.query("select * from record where username = ? and week = ? and day_of_week = ?",
                new BeanHandler<>(Record.class), username, week, dayOfWeek);
    }

    @Override
    public Record getRecordById(long id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Helper.getDataSource());
        return queryRunner.query("select * from record where id = ?",
                new BeanHandler<>(Record.class), id);
    }

    @Override
    public Long insertRecord(String username, String week, int dayOfWeek, Date time, int periodOfDay) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Helper.getDataSource());
        BigInteger id = queryRunner.insert(SQLUtil.genInsertRecordUrl(periodOfDay),
                new ScalarHandler<>(), username, week, dayOfWeek, time);
        return id.longValue();
    }

    @Override
    public void updateRecord(long id, Date time, int count, int periodOfDay) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Helper.getDataSource());
        queryRunner.update(SQLUtil.genUpdateRecordUrl(periodOfDay), time, count, id);
    }

    public static void main(String[] args) {
        RecordDAO recordDAO = new RecordDAOImpl();
        try {
             long r = recordDAO.insertRecord("testUser", TimeUtil.getWeekIdentifier(), TimeUtil.getDayOfWeek(),
                    new Date(), 2);
            System.out.println(r);
            recordDAO.updateRecord(r, new Date(), 4000, TimeUtil.getDayPeriod());
            System.out.println(recordDAO.getRecordById(r));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
