package com.k19.controller;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import com.k19.DAO.RegisterDao;
import com.k19.models.Register;
public class TaskOne {
    private RegisterDao registerDao;
    public void RunTask(Register User){
        MyTask myTask = new MyTask();
        Timer timer = new Timer();
        registerDao.DeleteRegister(User);
        timer.schedule(myTask, 5000*60);
    }
}
