package com.wj.hr.dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.wj.hr.bean.Website;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Properties;

public class WebsiteDao {
    private static JdbcTemplate tpl;
    static {
        try {
            // 获取连接池
            Properties properties = new Properties();
            properties.load(WebsiteDao.class.getClassLoader().getResourceAsStream("druid.properties"));
            DataSource ds = DruidDataSourceFactory.createDataSource(properties);
            // 创建tpl
            tpl = new JdbcTemplate(ds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 删除记录
     */
    public boolean remove(Integer id) {
        return false;
    }

    /**
     * 添加或更新
     */
    public boolean save(Website website) {
        return false;
    }

    /**
     * 获取单个对象
     */
    public Website get(Integer id) {
        return null;
    }

    /**
     * 获取多个对象ç
     */
    public List<Website> list () {
        String sql = "SELECT id, created_time, footer FROM website";
        return tpl.query(sql, new BeanPropertyRowMapper<Website>(Website.class));
    }

    /**
     * 获取统计值
     */
    public int count() {
        return 0;
    }

}
