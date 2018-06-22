package com.example.signinweb.service;

import com.example.signinweb.bean.Record;
import com.example.signinweb.bean.Result;

import java.util.Date;
import java.util.List;

public interface RecordService {
    Result getWeekRecords(String username, String week);
    Result signInFirstTime(String username, Date time);
    Result signInUpdate(long id, Date time);
    Result signOut(long id, Date time);
}
