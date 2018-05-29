package com.example.signinweb.util;


import com.example.signinweb.bean.User;
import javafx.util.Pair;

import java.math.BigInteger;
import java.util.Arrays;

public class SQLUtil {

    public static Pair<String, Object[]> genUpdateUserSQL(User user) {
        Object[] obj = new Object[6];
        StringBuilder sql = new StringBuilder("update user set ");
        int len = 0;

        if (user.getNickname() != null) {
            obj[len++] = user.getNickname();
            sql.append("nickname = ?,");
        }

        if (user.getSex() != null) {
            obj[len++] = user.getSex();
            sql.append("sex = ?,");
        }

        if (user.getGrade() != null) {
            obj[len++] = user.getGrade();
            sql.append("grade= ?,");
        }

        if (user.getPhone() != null) {
            obj[len++] = user.getPhone();
            sql.append("phone = ?,");
        }

        if (user.getMail() != null) {
            obj[len++] = user.getMail();
            sql.append("mail = ?,");
        }

        if (user.getDescription() != null) {
            obj[len++] = user.getDescription();
            sql.append("description= ?,");
        }

        sql.deleteCharAt(sql.length() - 1);
        sql.append(" where id = ").append(user.getId());

        if (len < 6) {
            Object[] copy = new Object[len];
            System.arraycopy(obj, 0, copy, 0, len);
            return new Pair<String, Object[]>(sql.toString(), copy);
        }

        return new Pair<String, Object[]>(sql.toString(), obj);
    }

    public static void main(String[] args) {
        System.out.println(genUpdateUserSQL(new User((long)3, null, null, "d", 3,
                null,"21", null, null)).getKey());

    }
}
