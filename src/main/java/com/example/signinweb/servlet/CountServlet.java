package com.example.signinweb.servlet;

import com.example.signinweb.Constants;
import com.example.signinweb.bean.Record;
import com.example.signinweb.bean.Result;
import com.example.signinweb.bean.User;
import com.example.signinweb.enums.Code;
import com.example.signinweb.service.RecordService;
import com.example.signinweb.service.impl.RecordServiceImpl;
import com.example.signinweb.util.TimeUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

public class CountServlet extends HttpServlet {

    private static final String GET = "get";
    private static final String SIGN_IN = "sign_in";
    private static final String SIGN_OUT = "sign_out";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(Constants.SessionAttrs.USER);

        if (method == null || GET.equals(method)) {
            getRecord(req, user, session);
        } else if (SIGN_IN.equals(method)) {
            signIn(req, user, session);
        } else if (SIGN_OUT.equals(method)) {
            signOut(req, user, session);
        }

        req.getRequestDispatcher("/main/count.jsp").forward(req, resp);
    }

    /**
     * 获取本周签到数据.
     */
    @SuppressWarnings(value = "unchecked")
    private void getRecord(HttpServletRequest req, User user, HttpSession session) {
        RecordService recordService = new RecordServiceImpl();
        Result result = recordService.getWeekRecords(user.getUsername(), TimeUtil.getWeekIdentifier());
        if (result.getCode() == Code.SUCCESS) {
            List<Record> records = (List) result.getObj();
            //处理数据
            long totalTime = 0;
            Record[] weekRecords = new Record[7];
            for (Record record : records) {
                totalTime += record.getCount();
                weekRecords[record.getDay_of_week() - 1] = record;
            }

            for (int i = 0; i < 7; i++) {
                if (weekRecords[i] == null) {
                    weekRecords[i] = new Record();
                }
            }

            //TODO total time and save to session
            float hour = (float) totalTime / (60 * 60);
            DecimalFormat decimalFormat = new DecimalFormat(".0");
            String hourStr = decimalFormat.format(hour);
            session.setAttribute(Constants.SessionAttrs.RECORD, weekRecords);
            session.setAttribute(Constants.SessionAttrs.TOTAL_TIME, hourStr);
            return;
        }

        req.setAttribute(Constants.ReqAttrs.ERROR, result);
    }

    /**
     * 签到.
     */
    private void signIn(HttpServletRequest req, User user, HttpSession session) {
        Record[] records = (Record[]) session.getAttribute(Constants.SessionAttrs.RECORD);
        if (records == null) {
            // avoid session timeout
            getRecord(req, user, session);
            records = (Record[]) session.getAttribute(Constants.SessionAttrs.RECORD);
        }

        RecordService recordService = new RecordServiceImpl();
        int periodOfDay = TimeUtil.getDayPeriod(); // 0, 1, 2
        int dayOfPeriod = TimeUtil.getDayOfWeek(); // 1~7
        Date now = new Date();
        Record record = records[dayOfPeriod - 1];

        if (record.getId() == null) { // no record exits
            Result result = recordService.signInFirstTime(user.getUsername(), now);
            if (result.getCode() == Code.SUCCESS) {
                getRecord(req, user, session);
                return;
            }

            req.setAttribute(Constants.ReqAttrs.ERROR, result);
            return;
        }

        // judge if have signed in
        switch (periodOfDay) {
            case 0:
                if (record.getIn_time_mor() != null) { // have signed in already
                    req.setAttribute(Constants.ReqAttrs.ERROR, new Result<>(Code.HAVE_SIGN_IN, "您已经签到"));
                    return;
                }
                break;
            case 1:
                if (record.getIn_time_noon() != null) { // have signed in already
                    req.setAttribute(Constants.ReqAttrs.ERROR, new Result<>(Code.HAVE_SIGN_IN, "您已经签到"));
                    return;
                }
                break;
            case 2:
                if (record.getIn_time_eve() != null) { // have signed in already
                    req.setAttribute(Constants.ReqAttrs.ERROR, new Result<>(Code.HAVE_SIGN_IN, "您已经签到"));
                    return;
                }
                break;
            default:
                break;
        }

        // need to update record
        Result result = recordService.signInUpdate(record.getId().longValue(), now);
        if (result.getCode() == Code.SUCCESS) {
            getRecord(req, user, session);
            return;
        }

        req.setAttribute(Constants.ReqAttrs.ERROR, result);
    }

    /**
     * 签出.
     */
    private void signOut(HttpServletRequest req, User user, HttpSession session) {
        Record[] records = (Record[]) session.getAttribute(Constants.SessionAttrs.RECORD);
        if (records == null) {
            // avoid session timeout
            getRecord(req, user, session);
            records = (Record[]) session.getAttribute(Constants.SessionAttrs.RECORD);
        }

        RecordService recordService = new RecordServiceImpl();
        int periodOfDay = TimeUtil.getDayPeriod(); // 0, 1, 2
        int dayOfPeriod = TimeUtil.getDayOfWeek(); // 1~7
        Date now = new Date();
        Record record = records[dayOfPeriod - 1];

        if (record.getId() == null) {
            req.setAttribute(Constants.ReqAttrs.ERROR, new Result<>(Code.NOT_SIGN_IN, "您还未签到"));
            return;
        }

        // judge if have signed out or not signed in
        switch (periodOfDay) {
            case 0:
                if (record.getIn_time_mor() == null) { // not signed in already
                    req.setAttribute(Constants.ReqAttrs.ERROR, new Result<>(Code.NOT_SIGN_IN, "您还未签到"));
                    return;
                }

                if (record.getOut_time_mor() != null) {
                    req.setAttribute(Constants.ReqAttrs.ERROR, new Result<>(Code.HAVE_SIGN_OUT, "您已经签出"));
                    return;
                }
                break;
            case 1:
                if (record.getIn_time_noon() == null) { // not signed in already
                    req.setAttribute(Constants.ReqAttrs.ERROR, new Result<>(Code.NOT_SIGN_IN, "您还未签到"));
                    return;
                }
                if (record.getOut_time_noon() != null) {
                    req.setAttribute(Constants.ReqAttrs.ERROR, new Result<>(Code.HAVE_SIGN_OUT, "您已经签出"));
                    return;
                }
                break;
            case 2:
                if (record.getIn_time_eve() == null) { // not signed in already
                    req.setAttribute(Constants.ReqAttrs.ERROR, new Result<>(Code.NOT_SIGN_IN, "您还未签到"));
                    return;
                }
                if (record.getOut_time_eve() != null) {
                    req.setAttribute(Constants.ReqAttrs.ERROR, new Result<>(Code.HAVE_SIGN_OUT, "您已经签出"));
                    return;
                }
                break;
            default:
                break;
        }

        Result result = recordService.signOut(record.getId().longValue(), now);
        if (result.getCode() == Code.SUCCESS) {
            getRecord(req, user, session);
            return;
        }

        req.setAttribute(Constants.ReqAttrs.ERROR, result);
    }
}
