package com.test.demo.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.apache.http.nio.reactor.IOReactorException;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


public class HttpClientUtil {


    public void jUnitTest() {
        get();
    }

    // org.apache.http.impl.client.CloseableHttpClient
    //连接池生成工具
    private static CloseableHttpClient httpclient = null;

    // 直接默认固定,因为以下三个参数在新建的method中仍然可以重新配置并被覆盖.
    private static final int connectionRequestTimeout = 5000;// ms毫秒,从池中获取链接超时时间
    private static final int connectTimeout = 5000;// ms毫秒,建立链接超时时间
    private static final int socketTimeout = 30000;// ms毫秒,读取超时时间

    // 总配置,主要涉及是以下两个参数,如果要作调整没有用到properties会比较后麻烦,但鉴于一经粘贴,随处可用的特点,就不再做依赖性配置化处理了.
    // 而且这个参数同一家公司基本不会变动.
    private static final int maxTotal = 500;// 最大总并发,很重要的参数
    private static final int maxPerRoute = 100;// 每路并发,很重要的参数

    // 正常情况这里应该配成MAP或LIST
    // 细化配置参数,用来对每路参数做精细化处理,可以管控各ip的流量,比如默认配置请求baidu:80端口最大100个并发链接,
//    private static final String detailHostName = "http://www.baidu.com";// 每个细化配置之ip(不重要,在特殊场景很有用)
//    private static final int detailPort = 80;// 每个细化配置之port(不重要,在特殊场景很有用)
//    private static final int detailMaxPerRoute = 100;// 每个细化配置之最大并发数(不重要,在特殊场景很有用)

    //获取链接池
    public static CloseableHttpClient getHttpclient(){
        if(null == httpclient){
            synchronized (HttpClientUtil.class){
                if(null ==httpclient){
                    httpclient = init();
                }
            }
        }
        return init();
    }

    //链接池初始化
    private static CloseableHttpClient init(){
        CloseableHttpClient newHttpClient = null;
        //建立链接池管理器
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        //设置
        //默认的每个路由的最大连接数
        cm.setDefaultMaxPerRoute(maxPerRoute);
        //最大连接数
        cm.setMaxTotal(maxTotal);
        /**
         * request请求相关配置
         */
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(socketTimeout)
                .setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .build();

        /**
         * 创建httpClient
         */
        newHttpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .setDefaultRequestConfig(requestConfig)
                .build();

        return newHttpClient;
    }


    public void get(){
        CloseableHttpClient testHttpClient = getHttpclient();
        System.out.println("测试获取连接======");
        try{
            //创建httpgetter
            HttpGet getter = new HttpGet("http://10.16.58.119:9002/email");
            System.out.println("execution:" + getter.getURI() + ", method:" + getter.getMethod());
            //执行getter
            CloseableHttpResponse httpResponse = testHttpClient.execute(getter);//处理异常
            System.out.println("测试执行=======");
            try{
                HttpEntity httpEntity = httpResponse.getEntity();
                System.out.println("================================");
                // 打印响应状态
                System.out.println(httpResponse.getStatusLine());
                if (httpEntity != null) {
                    // 打印响应内容长度
                    System.out.println("Response content length: " + httpEntity.getContentLength());
                    // 打印响应内容
                    System.out.println("Response content: " + EntityUtils.toString(httpEntity));
                }
                System.out.println("==================================");
            }catch (Exception e){
                System.out.println("内部异常==========================");
                e.printStackTrace();
            }
        }catch(Exception e){
            System.out.println("外部异常==========================");
            e.printStackTrace();
        }
    }




    public void post(){
        CloseableHttpClient postHttpClient = getHttpclient();

        try{

            HttpPost post = new HttpPost("http://10.16.58.119:9002/email");
            System.out.println("execution:" + post.getURI() + ", method:" + post.getMethod());

            String filePath = "F:\\IDEA\\ZJTest1\\exportTest.xls";
            File file = new File(filePath);



            String title = "test";
            String content = "test";
            String toEmail = "249358019@qq.com";
            String copyEmail = "2102902590@qq.com";
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//            builder.addTextBody("title",title);
//            builder.addTextBody("content",content);
//            builder.addTextBody("toEmail" , toEmail);
//            builder.addTextBody("copyEmail" , copyEmail);
//            builder.addBinaryBody("attachment" , file);
//            post.setEntity(builder.build());

            List<NameValuePair> list = new ArrayList<>();
            list.add(new BasicNameValuePair("title" , title));
            list.add(new BasicNameValuePair("content" , content));
            list.add(new BasicNameValuePair("toEmail" , toEmail));
            list.add(new BasicNameValuePair("copyEmail" , copyEmail));
            post.setHeader("Content-type", "application/form-data");
            HttpEntity entity = new UrlEncodedFormEntity(list ,"UTF-8");
            post.setEntity(entity );
            System.out.println(post.getAllHeaders());
            System.out.println(post.getEntity());
            System.out.println(post.getParams());

//            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//            StringBody strBody = StringBody.create(title);


//            //设置header信息
            //指定报文头【Content-type】、【User-Agent】
//            post.setHeader("content-Type", "multipart/form-data");

//            post.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");


            CloseableHttpResponse httpResponse = postHttpClient.execute(post);//处理异常
            System.out.println("测试执行=======");
            try{
                HttpEntity httpEntity = httpResponse.getEntity();
                System.out.println("================================");
                // 打印响应状态
                System.out.println(httpResponse.getStatusLine());
                System.out.println(httpResponse.getEntity());

                System.out.println("==================================");
            }catch (Exception e){
                System.out.println("内部异常==========================");
                e.printStackTrace();
            }
        }catch(Exception e){
            System.out.println("外部异常==========================");
            e.printStackTrace();
        }
    }

}
