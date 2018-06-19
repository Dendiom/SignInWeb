package com.example.signinweb.service.impl;

import com.example.signinweb.bean.Rank;
import com.example.signinweb.bean.Result;
import com.example.signinweb.dao.RankDAO;
import com.example.signinweb.dao.impl.RankDAOImpl;
import com.example.signinweb.enums.Code;
import com.example.signinweb.service.RankService;

import java.sql.SQLException;
import java.util.List;

public class RankServiceImpl implements RankService {

    RankDAO rankDAO = new RankDAOImpl();

    @Override
    public Result getRank(String week) {
        try {
            List<Rank> rank = rankDAO.getRank(week);
            return new Result<>(Code.SUCCESS, rank);
        } catch (SQLException e) {
            e.printStackTrace();
            e.printStackTrace();
            return new Result<>(Code.MYSQL_ERROR, "mysql error");
        }
    }
}
