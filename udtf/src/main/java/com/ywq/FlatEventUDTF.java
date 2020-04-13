package com.ywq;


import com.aliyun.odps.udf.ExecutionContext;
import com.aliyun.odps.udf.UDFException;
import com.aliyun.odps.udf.UDTF;
import com.aliyun.odps.udf.annotation.Resolve;
import com.alibaba.fastjson.*;

// TODO define input and output types, e.g. "string,string->string,bigint".
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
            forward(Long.parseLong(ett), eventName, eventJson);
        }
    }

    @Override
    public void close() throws UDFException {
    }
}