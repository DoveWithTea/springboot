package com.shine.springboot.datasource;

import com.alibaba.druid.sql.visitor.functions.Nil;
import com.mysql.cj.protocol.Resultset;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author :Shine
 * @date : 2022-08-26 16:23
 */

/**
 * description:

 * @return
 * @throws
 * @author Shine
 * @date 2022-08-26 19:33
 */
public class JdbcUtil {
    private static String className;
    private static String url;
    private static String user;
    private static String password;
    static
    {
        try {
            InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("dbinfo.properties");
            Properties props = new Properties();
            props.load(in);
            className = props.getProperty("className");
            url = props.getProperty("url");
            user = props.getProperty("user");
            password = props.getProperty("password");
            Class.forName(className);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * description: getConnetion

     * @return java.sql.Connection
     * @throws
     * @author Shine
     * @date 2022-08-26 19:33
     */
    public static Connection getConnetion() throws Exception
    {
        return DriverManager.getConnection(url, user, password);
    }
/**
 * description: close
 * @param rs description
 * @param stmt description
 * @param con description
 * @return void
 * @throws 
 * @author Shine
 * @date 2022-08-26 19:39
 */ 
    public static void close(ResultSet rs, Statement stmt, Connection con)
    {
        //返回数据集不为空可以直接关闭
        if (rs != null)
        {
            try {
                rs.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if (stmt != null)
        {
            try {
                stmt.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (con != null)
        {
            try {
                con.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
            con = null;
        }
    }
}

/**
 * @BelongsProject: springboot
 * @BelongsPackage: com.shine.springboot.datasource
 * @Author: Shine
 * @CreateTime: 2022-08-26  16:23
 * @Description: 数据库连接类
 * @Version: 1.0
 */