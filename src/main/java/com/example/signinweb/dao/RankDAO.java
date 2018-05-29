package com.example.signinweb.dao;

import com.example.signinweb.bean.Rank;

import java.util.List;

public interface RankDAO {
    List<Rank> getRank(long week);
}
