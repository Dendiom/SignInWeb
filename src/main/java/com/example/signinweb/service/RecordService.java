package com.example.signinweb.service;

import com.example.signinweb.bean.Record;
import com.example.signinweb.bean.Result;

import java.util.List;

public interface RecordService {
    Result getWeekRecords(String username, String week);
    Result signIn();
    Result signOut();
}
