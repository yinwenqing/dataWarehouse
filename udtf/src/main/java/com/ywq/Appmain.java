package com.ywq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Appmain {
    public static void main(String[] args) {
        String event = "[{\\'ett\\':\\'1586622450438\\',\\'en\\':\\'newsdetail\\',\\'kv\\':{\\'entry\\':\\'1\\',\\'goodsid\\':\\'41\\',\\'news_staytime\\':\\'18\\',\\'loading_time\\':\\'9\\',\\'action\\':\\'4\\',\\'showtype\\':\\'4\\',\\'category\\':\\'82\\',\\'type1\\':\\'201\\'}},{\\'ett\\':\\'1586582889921\\',\\'en\\':\\'loading\\',\\'kv\\':{\\'extend2\\':\\'\\',\\'loading_time\\':\\'6\\',\\'action\\':\\'1\\',\\'extend1\\':\\'\\',\\'type\\':\\'1\\',\\'type1\\':\\'542\\',\\'loading_way\\':\\'1\\'}},{\\'ett\\':\\'1586618912077\\',\\'en\\':\\'error\\',\\'kv\\':{\\'errorDetail\\':\\'at cn.lift.dfdfdf.control.CommandUtil.getInfo(CommandUtil.java:67)\\\\n at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\\\\n at java.lang.reflect.Method.invoke(Method.java:606)\\\\n\\',\\'errorBrief\\':\\'at cn.lift.appIn.control.CommandUtil.getInfo(CommandUtil.java:67)\\'}},{\\'ett\\':\\'1586660448678\\',\\'en\\':\\'praise\\',\\'kv\\':{\\'target_id\\':2,\\'id\\':5,\\'type\\':4,\\'add_time\\':\\'1586578786346\\',\\'userid\\':0}}]";
        JSONArray jsonArray = JSON.parseArray(event);
        System.out.println(jsonArray);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String ett = (String) jsonObject.getString("ett");
            String eventName = (String) jsonObject.getString("en");
            String eventJson = (String) jsonObject.getString("kv");
            System.out.println(Long.parseLong(ett));
            System.out.println(eventName);
            System.out.println(eventJson);
        }


    }
}
