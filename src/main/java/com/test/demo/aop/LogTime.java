package com.test.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogTime {
    private final static Logger log = LoggerFactory.getLogger(LogTime.class);

    //定义切入点，用于前置和后置
    @Pointcut("execution(* com.test.demo.controller.*.*( ..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        log.debug("前置测试=============");
        logTime1(joinPoint);
    }
//
//    @After("log()")
//    public void doAfter(JoinPoint joinPoint){
//        log.info("后置测试==========================");
//        logTime1(joinPoint);
//    }
//
//    @AfterReturning(pointcut = "log()" , returning = "zjModels")
//    public void doAfterReturning(ZJModels zjModels){
//        log.info("后置返回测试: " , zjModels.toString());
//    }
//
    private void logTime1(JoinPoint joinPoint){
        //class_method
        log.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
        //args[]
        log.info("args={}",argsToString(joinPoint.getArgs()));
    }

//
//    @Around("log()")
//    public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
//        return logTime2(pjp);
//    }  @Around("log()")
//    public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
//        return logTime2(pjp);
//    }

    private Object logTime2(ProceedingJoinPoint pjp) throws Throwable{
        //获取方法名，包名，参数
        String methodName = pjp.getSignature().getName();
        String packageName = pjp.getSignature().getDeclaringTypeName();
        Object[] args = pjp.getArgs();

        Object obj = pjp.proceed();

        log.info(obj.toString());
        log.warn("Message: " + packageName + "," + methodName + "," + argsToString(args));
        log.info("around==================");

        return obj;
    }



    //公用设置
    private String argsToString(Object[] args){
        if (args == null) {
            return "null";
        }

        int iMax = args.length-1;
        final int maxLength = 100;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0 ;i <= iMax ; i++){
            String arg = String.valueOf(args[i]);
            sb.append(arg);
            if(arg.length() > maxLength){
                sb.append("...");
                return sb.toString();
            }
            sb.append(",");
        }
        sb.append("]");
        return sb.toString();

    }


}
