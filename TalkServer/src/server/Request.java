package server;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.*;

//接收
public class Request {
    private String requestInfo;
    private String method;
    private String url;
    private String queryStr;
    private Map<String, List<String>> parameterMap;

    public Request(Socket client){
        parameterMap = new HashMap<String, List<String>>();
        byte[] datas = new byte[1024*1024];
        int len;
        try{
            len = client.getInputStream().read(datas);
            if(len == -1){
                return;
            }
            this.requestInfo = new String(datas,0,len);
        }catch (IOException e){
            e.printStackTrace();
            return;
        }
        //分解字符串
        parseRequestInfo();
    }

    private void parseRequestInfo(){
        System.out.println("======分解用户请求======");
        System.out.println(requestInfo);
        //获取请求方式 开头到第一个空格
        method = requestInfo.substring(0,requestInfo.indexOf(" "));
        //获取url
        int startIdx = requestInfo.indexOf("/");
        int endIdx = requestInfo.indexOf(" HTTP/");
        url = requestInfo.substring(startIdx,endIdx);
        //获取请求参数
        int queryIdx = url.indexOf("?");//英文问号 英文问号 英文问号
        if(queryIdx>0){
            String[] urlArray = url.split("\\?");
            url = urlArray[0];
            queryStr = urlArray[1];
        }

        if(method.equals("POST")){
            String qstr = requestInfo.substring(requestInfo.indexOf("\r\n\r\n")).trim();
            if(null == queryStr){
                queryStr = qstr;
            }else{
                queryStr += "&"+qstr;
            }
        }
        queryStr = null==queryStr?"":queryStr;
        System.out.println("\n\n\nmethod:" +method+ "   url:" +url+ "   queryStr:"+queryStr);

        convertMap();
    }

    public void convertMap(){
        String[] keyValues = queryStr.split("&");
        if(!queryStr.equals("")) {
            for (String q : keyValues) {
                String key = q.substring(0, q.indexOf("="));
                String value = q.substring(q.indexOf("=")+1);
                value = decode(value, "UTF-8");
                //存储到map中
                if (!parameterMap.containsKey(key)) {
                    parameterMap.put(key, new ArrayList<String>());
                }
                parameterMap.get(key).add(value);
            }
        }
    }

    //处理中文
    private String decode(String value,String enc){
        try{
            return java.net.URLDecoder.decode(value,enc);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return null;
    }

    public String[] getParameterValues(String key){
        List<String> values = this.parameterMap.get(key);
        if(null == values || values.size()<1){
            return null;
        }
        return values.toArray(new String[0]);
    }

    public String getParameterValue(String key){
        String[] strings = getParameterValues(key);
        if(strings != null) {
            return strings[0];
        }else{
            return null;
        }
    }

    public String getMethod() {
        if(method==null){
            method = "";
        }
        return method;
    }

    public String getUrl() {
        return url;
    }
}
