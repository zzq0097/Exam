package com.zzq.exam_stu_server.controller;

import com.zzq.exam_stu_server.domain.entity.User;
import com.zzq.exam_stu_server.service.AnswerService;
import com.zzq.exam_stu_server.service.ExamService;
import com.zzq.exam_stu_server.service.LoginService;
import com.zzq.exam_stu_server.service.RegisterService;
import com.zzq.exam_stu_server.util.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class StuLoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private RegisterService registerService;
    @Autowired
    private ExamService examService;
    @Autowired
    private AnswerService answerService;

    @RequestMapping("login")
    public JsonBean getExamId(HttpSession session, String username, String password){
        return loginService.login(session,username,password);
    }

    @RequestMapping("register")
    public JsonBean toRegister(User user){
        return registerService.userRegister(user);
    }

    @RequestMapping("getPaper")
    public JsonBean getPaper(Integer examId){
        return examService.getPaper(examId);
    }

    @RequestMapping(value = "submitExam",method = RequestMethod.POST)
    public JsonBean submitExam(@RequestBody String json){
        return answerService.getAnswer(json);
    }
}
