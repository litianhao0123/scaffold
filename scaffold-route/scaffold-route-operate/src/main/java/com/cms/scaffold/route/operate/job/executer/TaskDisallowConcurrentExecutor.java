package com.cms.scaffold.route.operate.job.executer;

import com.cms.scaffold.core.spring.SpringContextHolder;
import com.cms.scaffold.job.jobManager.bo.JobInfoBO;
import com.cms.scaffold.route.operate.job.utils.InvokeJobUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author zhangjiaheng@gmail.com
 * @Description 执行方法 不可并发
 **/
@DisallowConcurrentExecution
public class TaskDisallowConcurrentExecutor implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobInfoBO jobInfo = (JobInfoBO) context.getMergedJobDataMap().get("JobInfo");
        InvokeJobUtils invokeJobUtils = SpringContextHolder.getBean(InvokeJobUtils.class);
        invokeJobUtils.invokMethod(jobInfo);
    }
}
