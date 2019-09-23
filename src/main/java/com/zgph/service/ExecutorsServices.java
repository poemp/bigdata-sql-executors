package com.zgph.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sangfor
 */
@Service
public class ExecutorsServices {


    private static final Logger logger = LoggerFactory.getLogger(ExecutorsServices.class);

    @Autowired()
    @Qualifier("prodDatabases")
    private DataSource dataSource;


    /**
     * 执行sql
     *
     * @param sql
     * @return
     */
    public List<Map<String, Object>> exec(String sql) throws RuntimeException {
        Connection connection = null;
        List<Map<String, Object>> list = new ArrayList<>(10000);
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int colsLen = metaData.getColumnCount();
            while (resultSet.next()) {
                LinkedHashMap<String, Object> map = new LinkedHashMap<>();
                for (int i = 0; i < colsLen; i++) {
                    String colsName = metaData.getColumnName(i + 1);
                    Object colsValue = resultSet.getObject(colsName);
                    map.put(colsName, colsValue);
                }
                list.add(map);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e);

        }
        return list;
    }
}
