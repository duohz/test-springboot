package com.example.demo.exam;

import com.example.demo.entity.CommonLog;
import com.example.demo.service.CommonLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Desc spring嵌套回滚测试
 * 如果内外层方法使用了@Transaction(rollbackOn=Exception.class)注解
 * 内外任意一个抛出异常，内外都回滚
 * 1.内层抛出异常，外层抛出异常，内外都回滚
 * 2.内层抛出异常，外层捕获后不抛出，内外都回滚，会抛出Transaction rolled back because it has been marked as rollback-only
 * 3.内层抛出异常，外层捕获后抛出，内外都回滚
 * 4.内层执行成功，外层抛出异常，内外都回滚
 * <p>
 * 如果外层使用注解，内层不使用注解
 * 外层抛出异常，内外都回滚；外层捕获异常不抛出，内外都不回滚；其他内外回滚
 * 1.内层抛出异常，外层抛出异常，内外都回滚
 * 2.内层抛出异常，外层捕获后不抛出,内外都不会滚
 * 3.内层抛出异常，外层捕获后抛出，内外都回滚
 * 4.内层执行成功，外层抛出异常，内外都回滚
 * <p>
 * 如果外层不使用注解，内层使用注解
 * 内外是否抛出异常，外层都不回滚；内层发生异常，内层回滚
 * 1.内层抛出异常，外层抛出异常，外层不回滚，内层回滚
 * 2.内层抛出异常，外层捕获后不抛出，外层不回滚，内层回滚
 * 3.内层抛出异常，外层捕获后抛出，外层不回滚，内层回滚
 * 4.内层执行成功，外层抛出异常，内外都不回滚
 * <p>
 * 如果外层使用注解，内层使用新事务注解@Transaction(propagation=Propagation.REQUIRES_NEW,rollbackOn=Exception.class)
 * 内外谁抛出异常谁回滚
 * 1.内层抛出异常，外层抛出异常，外层不回滚，内层回滚
 * 2.内层抛出异常，外层捕获后不抛出，外层不回滚，内层回滚
 * 3.内层抛出异常，外层捕获后抛出，外层回滚，内层回滚
 * 4.内层执行成功，外层抛出异常，内层不回滚，外层回滚
 * <p>
 * @Author zhoud
 * @Date 2021/8/4 20:40
 **/
@Service
public class SpringRollBack {

    @Autowired
    private CommonLogService commonLogService;

    @Transactional(rollbackOn = Throwable.class)
    public void testA(CommonLog commonLog) throws Exception {
        commonLogService.saveCommonLog(commonLog);
        testB();
    }

    public void testB() throws Exception {
        testC();
    }

    public void testC() throws Exception {
        throw new Exception("testC throws exception!");
    }

    public void saveCommonLog(CommonLog commonLog) {
        commonLogService.saveCommonLog(commonLog);
    }

    public List<CommonLog> queryLogs() {
        return commonLogService.queryAll();
    }
}
