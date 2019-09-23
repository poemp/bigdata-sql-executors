package com.zgph.controller;

import com.zgph.utils.Result;
import com.zgph.service.ExecutorsServices;
import com.zgph.service.vo.RequestVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 执行查询的sql
 *
 * @author sangfor
 */
@RestController
@RequestMapping("/v1/executor")
public class ExecutorController {

    private static final Logger logger = LoggerFactory.getLogger(ExecutorController.class);

    @Autowired
    private ExecutorsServices executorsServices;


    /**
     * 执行sql
     *
     * @param requestVO 请求
     * @return 返回的数据
     */
    @PostMapping(value = "/execSql")
    public Result<List<Map<String, Object>>> execSql(@RequestBody RequestVO requestVO) {
        if (StringUtils.isEmpty(requestVO.getSql())) {
            return new Result<>(1, null, "sql can`t be empty");
        }
        logger.info("executor sql: \n\t\t" + requestVO.getSql());
        List<Map<String, Object>> mapList;
        try {
            mapList = this.executorsServices.exec(requestVO.getSql());
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new Result<>(1, new ArrayList<>());
        }
        return new Result<>(0, mapList);
    }

}
