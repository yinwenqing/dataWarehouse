package com.ywq;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.odps.udf.ExecutionContext;
import com.aliyun.odps.udf.UDFException;
import com.aliyun.odps.udf.UDTF;
import com.aliyun.odps.udf.annotation.Resolve;

//    public static void main(String[] args) {
//
//        String dataStr = "";
//        JSONObject data = JSONObject.parseObject(dataStr);
//
//        JSONArray jsonArray = data.getJSONArray("et");
//
//
//        for (Object o : jsonArray) {
//            JSONObject obj = (JSONObject) o;
//
//            String ett = obj.getString("ett");
//
//            String en = obj.getString("en");
//
//            JSONObject kv = obj.getJSONObject("kv");
//
//            System.out.println(ett);
//            System.out.println(en);
//            System.out.println(JSON.toJSONString(kv));
//        }
//    }

@Resolve({ "string->bigint,string,string" })
public class FlatEventUDTF extends UDTF {
    @Override
    public void setup(ExecutionContext ctx) throws UDFException {
    }

    @Override
    public void process(Object[] args) throws UDFException {
        String event = (String) args[0];
        JSONArray jsonArray = JSON.parseArray(event);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String ett = (String) jsonObject.getString("ett");
            String eventName = (String) jsonObject.getString("en");

            String eventJson = (String) jsonObject.getString("kv");
            // forward(Long.parseLong(ett), eventName, eventJson);
            forward(ett, eventName, eventJson);
        }
    }

    @Override
    public void close() throws UDFException {

    }
}