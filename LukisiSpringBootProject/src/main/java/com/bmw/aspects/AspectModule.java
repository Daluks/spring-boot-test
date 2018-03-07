/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmw.aspects;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 *
 * @author Lukisi Motsoeneng
 */
@Log4j
@Aspect
@Component
@Configuration
public class AspectModule
{
    @Pointcut("execution(public void com.bmw.UserAdminController.*(..))")
    private void logMethodAction()
    {
    }
    
    @Before("execution(public void com.bmw.inter.MailBoxController.send*(..)) && args(to,cc))")
    private void logBeforeSendingMessage(String to, String cc)
    {
        log.info("We are about to send an email to ..."+to);
    }
    
    @After("execution(public void com.bmw.inter.MailBoxController.send*(..)) && args(to,cc))")
    private void logAfterSendingMessage(String to, String cc)
    {
        log.info("An Email was sent to : "+to);
    }
    

}
