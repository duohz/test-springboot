package utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Desc
 * @Author zhoud
 * @Date 2021/7/31 22:02
 **/
@Aspect
@Component
@Slf4j
public class AutoLogAspect {
    private static final String POINT_CUT_PATH = "execution(* com.example.demo.controller.MainController.*(..))";

    @Before(POINT_CUT_PATH)
    public void logBefore(JoinPoint joinPoint) {
        log.info("Enter function:" + joinPoint.getSignature().getName());
    }

    @After(POINT_CUT_PATH)
    public void logAfter(JoinPoint joinPoint) {
        log.info("Exit function:" + joinPoint.getSignature().getName());
    }
}
