package com.meitu.mini1.configure;

import com.meitu.mini1.service.HotService;
import com.meitu.mini1.service.ParameterService;
import com.meitu.mini1.service.TackFindAllHot;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class TaskCronChange implements SchedulingConfigurer {

    @Resource
    private ParameterService parameterService;

    @Resource
    private HotService hotService;

    @Resource
    private TackFindAllHot tackFindAllHot;

    public static  String cron;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        //项目部署时，会在这里执行一次，从数据库拿到cron表达式
        cron = parameterService.getParaByType(3);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("" + LocalDateTime.now());
                //调用周期x小时查询热词数据
                // tackFindAllHot.dataToRedis();
            }
        };
        Trigger trigger = new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                //任务触发，可修改任务的执行周期.
                //每一次任务触发，都会执行这里的方法一次，重新获取下一次的执行时间
                cron = parameterService.getParaByType(3);
                CronTrigger trigger = new CronTrigger(cron);
                Date nextExec = trigger.nextExecutionTime(triggerContext);
                return nextExec;
            }
        };
        taskRegistrar.addTriggerTask(task, trigger);
    }
}