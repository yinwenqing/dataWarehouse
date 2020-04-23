package com.ywq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Test {

    public static void main(String[] args) {
        String str ="[\n" +
                "\t\t\t{\"ett\":\"1586609030972\",\n" +
                "\t\t\t\t\"en\":\"display\",\n" +
                "\t\t\t\t\"kv\":\n" +
                "\t\t\t\t\t{\"goodsid\":\"0\",\n" +
                "\t\t\t\t\t\"action\":\"2\",\n" +
                "\t\t\t\t\t\"extend1\":\"2\",\n" +
                "\t\t\t\t\t\"place\":\"1\",\n" +
                "\t\t\t\t\t\"category\":\"84\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t},\n" +
                "\t\t\t{\"ett\":\"1586639935792\",\"en\":\"newsdetail\",\"kv\":{\"entry\":\"3\",\"goodsid\":\"1\",\"news_staytime\":\"8\",\"loading_time\":\"16\",\"action\":\"1\",\"showtype\":\"1\",\"category\":\"89\",\"type1\":\"\"}},\n" +
                "\t\t\t{\"ett\":\"1586576122308\",\"en\":\"loading\",\"kv\":{\"extend2\":\"\",\"loading_time\":\"36\",\"action\":\"3\",\"extend1\":\"\",\"type\":\"1\",\"type1\":\"325\",\"loading_way\":\"1\"}},\n" +
                "\t\t\t{\"ett\":\"1586624964733\",\"en\":\"ad\",\"kv\":{\"entry\":\"2\",\"show_style\":\"4\",\"action\":\"1\",\"detail\":\"\",\"source\":\"4\",\"behavior\":\"1\",\"content\":\"2\",\"newstype\":\"3\"}},\n" +
                "\t\t\t{\"ett\":\"1586666509347\",\"en\":\"notification\",\"kv\":{\"ap_time\":\"1586636693753\",\"action\":\"4\",\"type\":\"3\",\"content\":\"\"}},{\"ett\":\"1586595906236\",\"en\":\"active_background\",\"kv\":{\"active_source\":\"3\"}},\n" +
                "\t\t\t{\"ett\":\"1586636801975\",\"en\":\"error\",\"kv\":{\"errorDetail\":\"java.lang.NullPointerException\\\\n at cn.lift.appIn.web.AbstractBaseController.validInbound(AbstractBaseController.java:72)\\\\n at cn.lift.dfdf.web.AbstractBaseController.validInbound\",\"errorBrief\":\"at cn.lift.appIn.control.CommandUtil.getInfo(CommandUtil.java:67)\"}},\n" +
                "\t\t\t{\"ett\":\"1586668295862\",\"en\":\"favorites\",\"kv\":{\"course_id\":0,\"id\":0,\"add_time\":\"1586665695179\",\"userid\":6}},\n" +
                "\t\t\t{\"ett\":\"1586602747113\",\"en\":\"praise\",\"kv\":{\"target_id\":9,\"id\":6,\"type\":2,\"add_time\":\"1586588867226\",\"userid\":3}}]";



        JSONArray jsonArray = JSON.parseArray(str);
        for (int i = 0; i < jsonArray.size(); i++) {
            System.out.println(jsonArray.getJSONObject(i));

            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String ett = (String) jsonObject.getString("ett");
            System.out.println(ett);
            String eventName = (String) jsonObject.getString("en");

            String eventJson = (String) jsonObject.getString("kv");
            // forward(Long.parseLong(ett), eventName, eventJson);
//            forward(ett, eventName, eventJson);
        }
    }
}
