/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmw;

import com.bmw.dao.UserDTO;
import com.bmw.inter.MailBoxController;
import com.bmw.jms.LukisiJMSSender;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import za.co.lukisi.calculator.Calculator;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.*;

/**
 *
 * @author QXU1114
 */
@Log4j
@RestController
@Component
public class UserAdminController
{
    @Autowired
    private LukisiJMSSender jMSSender;
    
//    @Autowired
//    private Calculator calculator;
//    
    @Autowired
    private MailBoxController mailboxService;
    
    @RequestMapping("/users")
    @ResponseBody
    public List<UserDTO> getAllUsers()
    {
        List<UserDTO> users = new ArrayList();
        UserDTO user = new UserDTO();
        user.setName("Test");
        user.setSurname("test");
        user.setUserId("QXU1114");
        users.add(user);
        
        UserDTO user2 = new UserDTO();
        user2.setName("name");
        user2.setSurname("surname");
        user2.setUserId("QXU1116");
        users.add(user2);
        return users;
    }
    
    @RequestMapping("/")
    public String getWelcome()
    {
       return "Welcome to Lukisi's world";
    }
    
    @RequestMapping("/sendjms")
    public void sendJMS(@RequestParam(value = "message") String sMessage, Model map)
    {
       jMSSender.sendMessage("inbound.queue", "This is Lukisi reporting "+sMessage);
    }
     
    
    @RequestMapping("/sendjmsform")
    public void sendJMSForm(@PathVariable String sMessage, Model map)
    {
        jMSSender.sendMessage("inbound.queue", "This is Lukisi reporting "+sMessage);
    }
    
    @RequestMapping("/sendEmail")
    public void sendEmail(@RequestParam(value = "to") String sTo, Model map) throws Exception
    {
        mailboxService.sendEmail(sTo, "joe@mall.co.za");
    }
    
    @RequestMapping("/add")
    @ResponseBody
    public String addValues(@RequestParam(value = "a") String a, @RequestParam(value = "b") String b, Model map) throws Exception
    {
        Predicate <Integer> predicate = c-> c >10;
                
//        Function <Integer, Integer> function = x -> x;
        
        BiFunction<Integer, Integer, Integer> biFunction = (x,y) -> x+y;
        
        biFunction.apply(2, 3);
        
        final int consumerVal = 2;
        
        Consumer <Integer> consumer = (g) ->
        {
            int x = g + consumerVal;
            System.out.println("Consumer result is "+x);
        };
        
        consumer.accept(Integer.parseInt(a));
        
        
        return "Test Calculator";
    }
    
    
       
}
