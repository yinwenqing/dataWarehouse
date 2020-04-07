package com.ywq.flume.interceptor;


import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class LogETLInterceptor implements Interceptor {

    @Override
    public void initialize() {

    }

    @Override
    public org.apache.flume.Event intercept(org.apache.flume.Event event) {
        //1. 获取数据
        byte[] body=event.getBody();

        String log = new String(body, Charset.forName("UTF-8"));

        // 2. 校验 启动日志（json)    事件日志（服务器事件|json)
        if(log.contains("start")){
            //校验启动日志
            if(LogUtils.valuateStart(log)){
                return event;
            }
        }else{
            if(LogUtils.valuateEvent(log)){
                return event;
            }

        }


        return null;
    }

    @Override
    public List<org.apache.flume.Event> intercept(List<org.apache.flume.Event> events) {
        ArrayList<Event> interceptors = new ArrayList<>();

        for (org.apache.flume.Event event : events) {
            Event interceptor1=intercept(event);

            if(interceptor1!=null){
                interceptors.add(interceptor1);
            }
        }
        return interceptors;
    }

    @Override
    public void close() {

    }

    public static class Builder implements Interceptor.Builder{

        @Override
        public Interceptor build() {
            return new LogETLInterceptor();
        }

        @Override
        public void configure(org.apache.flume.Context context) {

        }
    }
}


