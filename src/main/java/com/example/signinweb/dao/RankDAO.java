package com.example.signinweb.dao;

import com.example.signinweb.bean.Rank;

import java.sql.SQLException;
import java.util.List;

public interface RankDAO {
    List<Rank> getRank(String week) throws SQLException;
}
