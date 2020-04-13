package com.ywq.flume.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class aaa {

    public static void main(String[] args) {

        String dataStr = "{\"cm\":{\"ln\":\"-44.7\",\"sv\":\"V2.7.0\",\"os\":\"8.0.6\",\"g\":\"E436G83M@gmail.com\",\"mid\":\"1\",\"nw\":\"4G\",\"l\":\"pt\",\"vc\":\"5\",\"hw\":\"640*960\",\"ar\":\"MX\",\"uid\":\"1\",\"t\":\"1586594254684\",\"la\":\"-34.2\",\"md\":\"Huawei-8\",\"vn\":\"1.1.0\",\"ba\":\"Huawei\",\"sr\":\"G\"},\"ap\":\"app\",\"et\":[{\"ett\":\"1586659103877\",\"en\":\"display\",\"kv\":{\"goodsid\":\"1\",\"action\":\"2\",\"extend1\":\"2\",\"place\":\"2\",\"category\":\"23\"}},{\"ett\":\"1586661525641\",\"en\":\"newsdetail\",\"kv\":{\"entry\":\"1\",\"goodsid\":\"2\",\"news_staytime\":\"8\",\"loading_time\":\"6\",\"action\":\"3\",\"showtype\":\"1\",\"category\":\"100\",\"type1\":\"201\"}},{\"ett\":\"1586646333239\",\"en\":\"loading\",\"kv\":{\"extend2\":\"\",\"loading_time\":\"45\",\"action\":\"1\",\"extend1\":\"\",\"type\":\"2\",\"type1\":\"542\",\"loading_way\":\"2\"}},{\"ett\":\"1586630980747\",\"en\":\"notification\",\"kv\":{\"ap_time\":\"1586654775655\",\"action\":\"1\",\"type\":\"3\",\"content\":\"\"}},{\"ett\":\"1586604239371\",\"en\":\"praise\",\"kv\":{\"target_id\":8,\"id\":7,\"type\":4,\"add_time\":\"1586624644309\",\"userid\":1}}]}";

        JSONObject data = JSONObject.parseObject(dataStr);

        JSONArray jsonArray = data.getJSONArray("et");



        for (Object o : jsonArray){
            JSONObject obj = (JSONObject) o;

            String ett = obj.getString("ett");

            String en = obj.getString("en");

            JSONObject kv = obj.getJSONObject("kv");

            System.out.println(ett);
            System.out.println(en);
            System.out.println(JSON.toJSONString(kv));


        }


    }
}
