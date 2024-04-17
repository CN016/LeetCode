package com.my016.arithmetic.learn;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * HTTP工具类
 * by ：016
 * <p>
 * <p>
 * 基于Java的HttpURLConnection编写的http方法，封装了常见的请求
 */
public class HttpUtil {

    public static class Request {
        private String url;
        private Param param;
        private Header header;
        private String body;
        private String method;
        private Proxy proxy;
        private Response response;
        public Request(String url) {
            this.url = url;
            this.method = "GET";
        }
        public Request(String url, Param param) {
            this.url = url;
            this.param = param;
            this.method = "GET";
        }
        public Request(String url, Header header){
            this.url = url;
            this.header = header;
            this.method = "GET";
        }
        public Request(String url, Param param, Header header) {
            this.url = url;
            this.param = param;
            this.header = header;
            this.method = "GET";
        }
        public Request(String url, Header header, Proxy proxy){
            this.url = url;
            this.header = header;
            this.proxy = proxy;
            this.method = "GET";
        }
        public Request(String url, Param param, Proxy proxy){
            this.url = url;
            this.param = param;
            this.proxy = proxy;
            this.method = "GET";
        }
        public Request(String url, Param param, Header header, String body) {
            this.url = url;
            this.param = param;
            this.header = header;
            this.body = body;
            this.method = "POST";
        }
        public Request(String url, Header header, String body) {
            this.url = url;
            this.header = header;
            this.body = body;
            this.method = "POST";
        }
        public Request(String url, String body) {
            this.url = url;
            this.body = body;
            this.method = "POST";
        }
        public Request(String url, Param param, Header header, String body, Proxy proxy) {
            this.url = url;
            this.param = param;
            this.header = header;
            this.body = body;
            this.proxy = proxy;
            this.method = "POST";
        }

        public void setParam(Param param) {
            this.param = param;
        }

        public void setHeader(Header header) {
            this.header = header;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public void setProxy(Proxy proxy) {
            this.proxy = proxy;
        }

        public String getUrl() {
            return url;
        }

        public Param getParam() {
            return param;
        }

        public Header getHeader() {
            return header;
        }

        public String getBody() {
            return body;
        }

        public String getMethod() {
            return method;
        }

        public Proxy getProxy() {
            return proxy;
        }

        public Response getResponse() {
            return response;
        }

        private static class Response{
            private Request request;
            private int code;
            private String body;
            private String message;
            private String contentType;
            private String charset;
            private String encoding;
            private String contentLength;
            private String server;
            private String date;
            private String connection;
            private String contentEncoding;
            private String location;
            private String cookie;
            private String setCookie;
            private String expires;
            private String cacheControl;
            private String pragma;
            private String vary;
            private String acceptRanges;
            private String etag;
            private String lastModified;
        }
    }

    public static Header getHeader() {
        return new Header();
    }

    public static Param getParam() {
        return new Param();
    }

    public static String jsonPost(String url, String body) {
        InputStream inputStream = doJsonPost(url, body);
        return getString(inputStream);
    }

    public static String jsonPost(String url, String body, Proxy proxy) {
        InputStream inputStream = doJsonPost(url, body, proxy);
        return getString(inputStream);
    }

    public static String jsonPost(String url, Param param, String body) {
        InputStream inputStream = doJsonPost(url, param, body);
        return getString(inputStream);
    }

    public static String jsonPost(String url, Param param, String body, Proxy proxy) {
        InputStream inputStream = doJsonPost(url, param, body, proxy);
        return getString(inputStream);
    }

    public static String jsonPost(String url, Header header, String body) {
        InputStream inputStream = doJsonPost(url, header, body);
        return getString(inputStream);
    }

    public static String jsonPost(String url, Header header, String body, Proxy proxy) {
        InputStream inputStream = doJsonPost(url, header, body, proxy);
        return getString(inputStream);
    }

    public static String jsonPost(String url, Param param, Header header, String body) {
        InputStream inputStream = doJsonPost(url, param, header, body);
        return getString(inputStream);
    }

    public static String jsonPost(String url, Param param, Header header, String body, Proxy proxy) {
        InputStream inputStream = doJsonPost(url, param, header, body, proxy);
        return getString(inputStream);
    }

    public static String jsonPut(String url, Param param, Header header, String body, Proxy proxy) {
        InputStream inputStream = doJsonPut(url, param, header, body, proxy);
        return getString(inputStream);
    }

    public static InputStream doJsonPost(String url, Param param, Header header, String body) {
        header.setHeader("Content-Type", "application/json");
        return doPost(url, param, header, body);
    }

    public static InputStream doJsonPost(String url, Param param, Header header, String body, Proxy proxy) {
        header.setHeader("Content-Type", "application/json");
        return doPost(url, param, header, body, proxy);
    }

    public static InputStream doJsonPost(String url, Header header, String body) {
        header.setHeader("Content-Type", "application/json");
        return doPost(url, header, body);
    }

    public static InputStream doJsonPost(String url, Header header, String body, Proxy proxy) {
        header.setHeader("Content-Type", "application/json");
        return doPost(url, header, body, proxy);
    }

    public static InputStream doJsonPost(String url, Param param, String body) {
        Header header = new Header().setHeader("Content-Type", "application/json");
        return doPost(url, param, header, body);
    }

    public static InputStream doJsonPost(String url, Param param, String body, Proxy proxy) {
        Header header = new Header().setHeader("Content-Type", "application/json");
        return doPost(url, param, header, body, proxy);
    }

    public static InputStream doJsonPost(String url, String body) {
        Header header = new Header().setHeader("Content-Type", "application/json");
        return doPost(url, header, body);
    }

    public static InputStream doJsonPost(String url, String body, Proxy proxy) {
        Header header = new Header().setHeader("Content-Type", "application/json");
        return doPost(url, header, body, proxy);
    }

    public static InputStream doJsonPut(String url, Param param, Header header, String body, Proxy proxy) {
        header.setHeader("Content-Type", "application/json");
        return doPut(url, param, header, body, proxy);
    }

    public static byte[] postThenByteResponse(String url, Param param, Header header, String body) {
        try {
            return doPost(url, param, header, body).readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
            throw new HttpException("获取响应失败");
        }
    }

    public static byte[] postThenByteResponse(String url, Param param, Header header, String body, Proxy proxy) {
        try {
            return doPost(url, param, header, body, proxy).readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
            throw new HttpException("获取响应失败");
        }
    }

    public static byte[] postThenByteResponse(String url, Header header, String body) {
        try {
            return doPost(url, header, body).readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
            throw new HttpException("获取响应失败");
        }
    }

    public static byte[] postThenByteResponse(String url, Header header, String body, Proxy proxy) {
        try {
            return doPost(url, header, body, proxy).readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
            throw new HttpException("获取响应失败");
        }
    }

    public static String post(String url, Param param, Header header, String body) {
        InputStream inputStream = doPost(url, param, header, body);
        return getString(inputStream);
    }

    public static String post(String url, Param param, Header header, String body, Proxy proxy) {
        InputStream inputStream = doPost(url, param, header, body, proxy);
        return getString(inputStream);
    }

    public static String post(String url, Header header, String body) {
        InputStream inputStream = doPost(url, header, body);
        return getString(inputStream);
    }

    public static String post(String url, String body) {
        InputStream inputStream = doPost(url, null, body);
        return getString(inputStream);
    }

    public static String post(String url, String body, Proxy proxy) {
        InputStream inputStream = doPost(url, null, null, body, proxy);
        return getString(inputStream);
    }

    public static String post(String url) {
        InputStream inputStream = doPost(url, null, null);
        return getString(inputStream);
    }

    public static String post(String url, Proxy proxy) {
        InputStream inputStream = doPost(url, null, null, null, proxy);
        return getString(inputStream);
    }

    public static String post(String url, Header header, String body, Proxy proxy) {
        InputStream inputStream = doPost(url, header, body, proxy);
        return getString(inputStream);
    }

    public static String put(String url, Param param, Header header, String body, Proxy proxy) {
        InputStream inputStream = doPut(url, param, header, body, proxy);
        return getString(inputStream);
    }

    public static String put(String url, Param param, Header header, String body) {
        InputStream inputStream = doPut(url, param, header, body, null);
        return getString(inputStream);
    }

    public static String put(String url, String body) {
        InputStream inputStream = doPut(url, null, null, body, null);
        return getString(inputStream);
    }

    public static String put(String url, String body, Proxy proxy) {
        InputStream inputStream = doPut(url, null, null, body, proxy);
        return getString(inputStream);
    }

    public static String put(String url, Header header, String body) {
        InputStream inputStream = doPut(url, null, header, body, null);
        return getString(inputStream);
    }

    public static String put(String url, Header header, String body, Proxy proxy) {
        InputStream inputStream = doPut(url, null, header, body, proxy);
        return getString(inputStream);
    }

    public static String put(String url) {
        InputStream inputStream = doPut(url, null, null, null, null);
        return getString(inputStream);
    }

    public static String put(String url, Proxy proxy) {
        InputStream inputStream = doPut(url, null, null, null, proxy);
        return getString(inputStream);
    }

    public static byte[] getThenByteResponse(String url, Param param, Header header) {
        try {
            return doGet(url, param, header).readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
            throw new HttpException("获取响应失败");
        }
    }

    public static byte[] getThenByteResponse(String url, Param param, Header header, Proxy proxy) {
        try {
            return doGet(url, param, header, proxy).readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
            throw new HttpException("获取响应失败");
        }
    }

    public static byte[] getThenByteResponse(String url, Header header) {
        try {
            return doGet(url, header).readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
            throw new HttpException("获取响应失败");
        }
    }

    public static byte[] getThenByteResponse(String url, Header header, Proxy proxy) {
        try {
            return doGet(url, header, proxy).readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
            throw new HttpException("获取响应失败");
        }
    }

    public static byte[] getThenByteResponse(String url) {
        try {
            return doGet(url).readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
            throw new HttpException("获取响应失败");
        }
    }

    public static byte[] getThenByteResponse(String url, Proxy proxy) {
        try {
            return doGet(url, proxy).readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
            throw new HttpException("获取响应失败");
        }
    }

    public static String get(String url, Param param, Header header) {
        InputStream inputStream = doGet(url, param, header);
        return getString(inputStream);
    }

    public static String get(String url, Param param, Header header, Proxy proxy) {
        InputStream inputStream = doGet(url, param, header, proxy);
        return getString(inputStream);
    }

    public static String get(String url, Header header) {
        InputStream inputStream = doGet(url, header);
        return getString(inputStream);
    }

    public static String get(String url, Param param, Proxy proxy) {
        InputStream inputStream = doGet(url, param, proxy);
        return getString(inputStream);
    }

    public static String get(String url) {
        InputStream inputStream = doGet(url);
        return getString(inputStream);
    }

    public static String get(String url, Proxy proxy) {
        InputStream inputStream = doGet(url, proxy);
        return getString(inputStream);
    }

    public static String get(String url, Param param) {
        InputStream inputStream = doGet(url, param);
        return getString(inputStream);
    }

    public static String get(String url, Header header, Proxy proxy) {
        InputStream inputStream = doGet(url, header, proxy);
        return getString(inputStream);
    }

    public static String delete(String url) {
        InputStream inputStream = doDelete(url);
        return getString(inputStream);
    }

    public static String delete(String url, Proxy proxy) {
        InputStream inputStream = doDelete(url, proxy);
        return getString(inputStream);
    }

    public static String delete(String url, Param param, Proxy proxy) {
        InputStream inputStream = doDelete(url, param, proxy);
        return getString(inputStream);
    }

    public static String delete(String url, Param param) {
        InputStream inputStream = doDelete(url, param);
        return getString(inputStream);
    }

    public static String delete(String url, Header header, Proxy proxy) {
        InputStream inputStream = doDelete(url, header, proxy);
        return getString(inputStream);
    }

    public static String delete(String url, Header header) {
        InputStream inputStream = doDelete(url, header);
        return getString(inputStream);
    }

    public static String delete(String url, Param param, Header header) {
        InputStream inputStream = doDelete(url, param, header);
        return getString(inputStream);
    }

    public static String delete(String url, Param param, Header header, Proxy proxy) {
        InputStream inputStream = doDelete(url, param, header, proxy);
        return getString(inputStream);
    }

    public static InputStream doDelete(String url, Param param, Header header, Proxy proxy) {
        HttpURLConnection connection = initRequest(url, param, proxy);
        return baseDelete(connection, header);
    }

    public static InputStream doDelete(String url, Param param, Header header) {
        HttpURLConnection connection = initRequest(url, param, null);
        return baseDelete(connection, header);
    }

    public static InputStream doDelete(String url, Header header) {
        HttpURLConnection connection = initRequest(url, null, null);
        return baseDelete(connection, header);
    }

    public static InputStream doDelete(String url, Header header, Proxy proxy) {
        HttpURLConnection connection = initRequest(url, null, proxy);
        return baseDelete(connection, header);
    }

    public static InputStream doDelete(String url, Param param) {
        HttpURLConnection connection = initRequest(url, param, null);
        return baseDelete(connection, null);
    }

    public static InputStream doDelete(String url, Param param, Proxy proxy) {
        HttpURLConnection connection = initRequest(url, param, proxy);
        return baseDelete(connection, null);
    }

    public static InputStream doDelete(String url, Proxy proxy) {
        HttpURLConnection connection = initRequest(url, null, proxy);
        return baseDelete(connection, null);
    }

    public static InputStream doDelete(String url) {
        HttpURLConnection connection = initRequest(url, null, null);
        return baseDelete(connection, null);
    }

    public static InputStream doGet(String url, Param param, Header header) {
        HttpURLConnection connection = initRequest(url, param, null);
        return baseGet(connection, header);
    }

    public static InputStream doGet(String url, Param param, Header header, Proxy proxy) {
        HttpURLConnection connection = initRequest(url, param, proxy);
        return baseGet(connection, header);
    }

    public static InputStream doGet(String url, Header header) {
        HttpURLConnection connection = initRequest(url, null, null);
        return baseGet(connection, header);
    }

    public static InputStream doGet(String url, Param param) {
        HttpURLConnection connection = initRequest(url, param, null);
        return baseGet(connection, null);
    }

    public static InputStream doGet(String url, Param param, Proxy proxy) {
        HttpURLConnection connection = initRequest(url, param, proxy);
        return baseGet(connection, null);
    }

    public static InputStream doGet(String url) {
        HttpURLConnection connection = initRequest(url, null, null);
        return baseGet(connection, null);
    }

    public static InputStream doGet(String url, Proxy proxy) {
        HttpURLConnection connection = initRequest(url, null, proxy);
        return baseGet(connection, null);
    }

    public static InputStream doGet(String url, Header header, Proxy proxy) {
        HttpURLConnection connection = initRequest(url, null, proxy);
        return baseGet(connection, header);
    }

    public static InputStream doPost(String url, Header header, String body) {
        HttpURLConnection connection = initRequest(url, null, null);
        return basePost(connection, header, body);
    }

    public static InputStream doPost(String url, Header header, String body, Proxy proxy) {
        HttpURLConnection connection = initRequest(url, null, proxy);
        return basePost(connection, header, body);
    }

    public static InputStream doPost(String url, Param param, Header header, String body) {
        HttpURLConnection connection = initRequest(url, param, null);
        return basePost(connection, header, body);
    }

    public static InputStream doPost(String url, Param param, Header header, String body, Proxy proxy) {
        HttpURLConnection connection = initRequest(url, param, proxy);
        return basePost(connection, header, body);
    }

    public static InputStream doPut(String url, Param param, Header header, String body, Proxy proxy) {
        HttpURLConnection connection = initRequest(url, param, proxy);
        return basePut(connection, header, body);
    }

    private static InputStream baseGet(HttpURLConnection connection, Header header) {
        try {
            connection.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        return baseRequest(connection, header);
    }

    private static InputStream baseDelete(HttpURLConnection connection, Header header) {
        try {
            connection.setRequestMethod("DELETE");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        return baseRequest(connection, header);
    }

    private static InputStream basePut(HttpURLConnection connection, Header header, String body) {
        try {
            connection.setRequestMethod("PUT");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }

        return bodyHandle(connection, header, body);
    }

    private static String getString(InputStream inputStream) {
        try {
            byte[] bytes = inputStream.readAllBytes();
            return new String(bytes, 0, bytes.length, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            throw new HttpException("获取响应失败");
        }
    }

    private static InputStream baseRequest(HttpURLConnection connection, Header header) {
        setHeader(connection, header);

        // 获取输入流
        try {
            if (connection.getResponseCode() == 200){
                return connection.getInputStream();
            }else {
                return connection.getErrorStream();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new HttpException("获取响应失败");
        }
    }




    private static InputStream basePost(HttpURLConnection connection, Header header, String body) {
        try {
            connection.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }

        return bodyHandle(connection, header, body);
    }

    private static InputStream bodyHandle(HttpURLConnection connection, Header header, String body) {
        // 启用输出
        connection.setDoOutput(true);

        if (isEmpty(body)) {
            return baseRequest(connection, header);
        }
        // 获取输出流，写入请求体数据
        setHeader(connection, header);
        try (OutputStream outputStream = connection.getOutputStream()) {
            byte[] requestBodyBytes = body.getBytes(StandardCharsets.UTF_8);
            outputStream.write(requestBodyBytes);
            return baseRequest(connection, null);
        } catch (IOException e) {
            e.printStackTrace();
            throw new HttpException("请求体设置异常");
        }

    }

    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }

    private static HttpURLConnection initRequest(String url, Param param, Proxy proxy) {
        URL u;
        url = handleUrl(url, param);
        try {
            u = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new HttpException("URL格式错误");
        }
        try {
            return proxy == null ? (HttpURLConnection) u.openConnection() : (HttpURLConnection) u.openConnection(proxy);
        } catch (IOException e) {
            e.printStackTrace();
            throw new HttpException("连接异常");
        }
    }

    public static class Param {

        private static final Map<String, String> param = new HashMap<>();

        private int size = 0;

        public String getParam(String key) {
            return param.get(key);
        }

        public Param setParam(String key, String value) {
            param.put(key, value);
            size++;
            return this;     //链式调用
        }

        public String showParam() {
            return param.toString();
        }

        private List<String[]> getAllParam() {
            return getList(param);
        }

        public int getSize() {
            return size;
        }
    }

    private static String handleUrl(String url, Param param) {
        if (param == null || param.size == 0) {
            return url;
        } else {
            url += "?";
        }
        List<String[]> allParam = param.getAllParam();
        String[] k = allParam.get(0);
        String[] v = allParam.get(1);
        if (isEmpty(k) || isEmpty(v)) {
            return url;
        }
        StringBuilder urlBuilder = new StringBuilder(url);
        for (int i = 0; i < k.length; i++) {
            urlBuilder.append(k[i]).append("=").append(v[i]).append(i == k.length - 1 ? "" : "&");
        }
        url = urlBuilder.toString();
        return url;
    }

    private static void setHeader(HttpURLConnection connection, Header header) {
        if (header == null || header.size == 0) {
            return;
        }
        List<String[]> allHeader = header.getAllHeader();
        String[] k = allHeader.get(0);
        String[] v = allHeader.get(1);
        if (isEmpty(k) || isEmpty(v)) {
            return;
        }
        for (int i = 0; i < k.length; i++) {
            connection.setRequestProperty(k[i], v[i]);
        }
    }

    public static class Header {

        private static final Map<String, String> header = new HashMap<>();

        private int size = 0;

        public String getHeader(String key) {
            return header.get(key);
        }

        public Header setHeader(String key, String value) {
            header.put(key, value);
            size++;
            return this;          //链式调用
        }

        public String showHeader() {
            return header.toString();
        }

        /**
         * 获取所有头
         *
         * @return 返回一个字符串数组的集合，该集合只有两个数组元素，第一个是请求头的key，第二个是请求头的value
         */
        private List<String[]> getAllHeader() {
            return getList(header);
        }

        public int getSize() {
            return size;
        }
    }

    private static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    private static List<String[]> getList(Map<String, String> param) {
        Set<String> keySet = param.keySet();
        String[] k = keySet.toArray(new String[0]);
        String[] v = new String[k.length];
        for (int i = 0; i < k.length; i++) {
            v[i] = param.get(k[i]);
        }
        List<String[]> r = new List<>();
        r.add(k).add(v);
        return r;
    }

    private static class List<T> {

        private final Node<T> head;

        private Node<T> end;

        private long length;

        public List() {
            head = new Node<>();
            head.next = null;
            end = null;
            length = 0;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{");
            Node<T> p = head.next;
            for (long i = 0; i < length; i++) {
                stringBuilder.append(p).append(i == length - 1 ? "" : ",");
                p = p.next;
            }
            return stringBuilder.append("}").toString();
        }

        public List<T> add(T data) {
            Node<T> tNode = new Node<>();
            tNode.setT(data);
            tNode.setNext(null);
            Objects.requireNonNullElse(end, head).next = tNode;
            end = tNode;
            length++;
            return this;
        }

        public T get(long index) {
            if (index >= length) {
                return null;
            }
            Node<T> p = head.next;
            for (long i = 0; i < index; i++) {
                p = p.next;
            }
            return p.getT();
        }

        public long size() {
            return length;
        }

        private static class Node<T> {

            private T t;
            private Node<T> next;

            @Override
            public String toString() {
                return "{" +
                        t.toString() +
                        '}';
            }

            public T getT() {
                return t;
            }

            public void setT(T t) {
                this.t = t;
            }

            public Node<T> getNext() {
                return next;
            }

            public void setNext(Node<T> next) {
                this.next = next;
            }
        }
    }

    private static class HttpException extends RuntimeException {

        private final String msg;

        public HttpException(String msg) {
            super(msg);
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }

    }


}
