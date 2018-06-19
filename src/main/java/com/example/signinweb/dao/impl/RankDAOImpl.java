package com.example.signinweb.dao.impl;

import com.example.signinweb.bean.Rank;
import com.example.signinweb.dao.RankDAO;
import com.example.signinweb.lib.mysql.C3p0Helper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class RankDAOImpl implements RankDAO{
    public List<Rank> getRank(String week) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Helper.getDataSource());
        return queryRunner.query("select user.nickname, user.grade, sum(if(record.week=?, record.count, 0)) as count " +
                "from record,user  where user.username = record.username " +
                "group by record.username order by count desc;", new BeanListHandler<>(Rank.class), week);
    }

    public static void main(String[] args) {
        RankDAO rankDAO = new RankDAOImpl();
        try {
            List<Rank> ranks = rankDAO.getRank("1527436800");
            System.out.println(ranks);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
