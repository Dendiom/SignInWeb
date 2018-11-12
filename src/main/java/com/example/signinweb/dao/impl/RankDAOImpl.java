package com.example.signinweb.dao.impl;

import com.example.signinweb.bean.Rank;
import com.example.signinweb.dao.RankDAO;
import com.example.signinweb.lib.mysql.C3p0Helper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class RankDAOImpl implements RankDAO {
    public List<Rank> getRank(String week) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Helper.getDataSource());
        return queryRunner.query("select sum(count) as count, user.nickname, user.grade  from record,user " +
                " where record.week = ? and user.username = record.username " +
                "group by record.username order by count desc;", new BeanListHandler<>(Rank.class), week);
    }
}
