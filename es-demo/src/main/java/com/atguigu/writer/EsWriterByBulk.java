package com.atguigu.writer;

import com.atguigu.bean.Stu;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Bulk;
import io.searchbox.core.Index;

import java.io.IOException;

public class EsWriterByBulk {

    public static void main(String[] args) throws IOException {

        //1.创建工厂
        JestClientFactory jestClientFactory = new JestClientFactory();

        //2.创建配置信息
        HttpClientConfig httpClientConfig = new HttpClientConfig.Builder("http://hadoop102:9200").build();

        //3.设置配置信息
        jestClientFactory.setHttpClientConfig(httpClientConfig);

        //4.获取客户端对象
        JestClient jestClient = jestClientFactory.getObject();

        //5.创建多个Index对象
        Stu stu1 = new Stu("banzhang",16L);
        Stu stu2 = new Stu("ziyang",8L);
        Stu stu3 = new Stu("liuqian",186L);

        Index index1 = new Index.Builder(stu1).id("1006").build();
        Index index2 = new Index.Builder(stu2).id("1007").build();
        Index index3 = new Index.Builder(stu3).id("1008").build();

        //6.创建Bulk对象
        Bulk.Builder builder = new Bulk.Builder()
                .addAction(index1)
                .addAction(index2)
                .addAction(index3)
                .defaultIndex("stu")
                .defaultType("_doc");

        Bulk bulk = builder.build();

        //7.执行批量插入数据操作
        jestClient.execute(bulk);

        //8.关闭资源
        jestClient.close();
    }
}