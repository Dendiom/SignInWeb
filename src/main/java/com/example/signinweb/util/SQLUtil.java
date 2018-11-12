package com.example.signinweb.util;


import com.example.signinweb.bean.User;
import javafx.util.Pair;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;

public class SQLUtil {

    /**
     * 根据传入的实体类，生成sql语句和需要的params数组.
     *
     * @param user 实体类.
     * @return Pair<sql       ,               param       [       ]>.
     */
    public static Pair<String, Object[]> genUpdateUserSQL(User user) {
        Object[] obj = new Object[6];
        StringBuilder sql = new StringBuilder("update user set ");
        int len = 0;

        if (user.getNickname() != null) {
            obj[len++] = user.getNickname();
            sql.append("nickname = ?,");
        }

        if (user.getSex() != null) {
            obj[len++] = user.getSex() ? 1: 0;
            sql.append("sex = ?,");
        }

        if (user.getGrade() != null) {
            obj[len++] = user.getGrade();
            sql.append("grade= ?,");
        }

        if (user.getPhone() != null && !user.getPhone().equals("")) {
            obj[len++] = user.getPhone();
            sql.append("phone = ?,");
        }

        if (user.getMail() != null && !user.getMail().equals("")) {
            obj[len++] = user.getMail();
            sql.append("mail = ?,");
        }

        if (user.getDescription() != null && !user.getDescription().equals("")) {
            obj[len++] = user.getDescription();
            sql.append("description= ?,");
        }

        sql.deleteCharAt(sql.length() - 1);
        sql.append(" where id = ").append(user.getId());

        if (len < 6) {
            Object[] copy = new Object[len];
            System.arraycopy(obj, 0, copy, 0, len);
            return new Pair<>(sql.toString(), copy);
        }

        return new Pair<>(sql.toString(), obj);
    }

    /**
     * 根据传入的信息，生成插入记录的sql语句.
     *
     * @param periodOfDay 早上/下午/晚上 0/1/2.
     * @return String sql.
     */
    public static String genInsertRecordUrl(int periodOfDay) {
        if (periodOfDay == 0) {
            return "insert into record(username, week, day_of_week, in_time_mor) value(?, ?, ?, ?)";
        }

        if (periodOfDay == 1) {
            return "insert into record(username, week, day_of_week, in_time_noon) value(?, ?, ?, ?)";
        }

        if (periodOfDay == 2) {
            return "insert into record(username, week, day_of_week, in_time_eve) value(?, ?, ?, ?)";
        }

        return "";
    }

    /**
     * 根据传入的信息，生成更新记录的sql语句.
     *
     * @param periodOfDay 早上/下午/晚上 0/1/2.
     * @param in          签到还是签出.
     * @return String sql.
     */
    public static String genUpdateRecordUrl(int periodOfDay, boolean in) {
        if (periodOfDay == 0) {
            return in ? "update record set in_time_mor = ?, count = ? where id = ?" :
                    "update record set out_time_mor = ?, count = ? where id = ?";
        }

        if (periodOfDay == 1) {
            return in ? "update record set in_time_noon = ?, count = ? where id = ?" :
                    "update record set out_time_noon = ?, count = ? where id = ?";
        }

        if (periodOfDay == 2) {
            return in ? "update record set in_time_eve = ?, count = ? where id = ?" :
                    "update record set out_time_eve = ?, count = ? where id = ?";
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(genUpdateUserSQL(new User((long) 3, null, null, "d", true,
                null, "21", null, null)).getKey());

    }
}
