package com.atguigu;

import java.sql.*;

public class KylinTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //准备4个参数
        //Kylin_JDBC 驱动
        String KYLIN_DRIVER = "org.apache.kylin.jdbc.Driver";

        //Kylin_URL
        String KYLIN_URL = "jdbc:kylin://hadoop102:7070/first_project";

        //Kylin的用户名
        String KYLIN_USER = "ADMIN";

        //Kylin的密码
        String KYLIN_PASSWD = "KYLIN";

        //加载驱动
        Class.forName(KYLIN_DRIVER);

        //创建连接
        Connection connection = DriverManager.getConnection(KYLIN_URL, KYLIN_USER, KYLIN_PASSWD);

        //预编译SQL,设置占位符
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT PROVINCE_ID,count(*) FROM DWD_FACT_ORDER_DETAIL GROUP BY PROVINCE_ID");

        //执行查询
        ResultSet resultSet = preparedStatement.executeQuery();

        //resultSet解析
        while (resultSet.next()) {
            System.out.println("PROVINCE_ID:" + resultSet.getString(1)
                    + "，CT:" + resultSet.getLong(2));
        }

        //关闭资源
        resultSet.close();
        preparedStatement.close();
        connection.close();

    }

}
