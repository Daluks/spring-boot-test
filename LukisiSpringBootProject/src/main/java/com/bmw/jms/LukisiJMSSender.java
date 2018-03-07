/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmw.jms;

import javax.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.aspectj.weaver.Shadow;
import org.hornetq.api.core.client.ServerLocator;
import org.hornetq.jms.client.HornetQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author Lukisi Motsoeneng
 */
@Component
public class LukisiJMSSender
{
    @Autowired
    private JmsTemplate jmsTemplate;
    
    public void sendMessage(String dest, String message)
    {
        //ActiveMQ
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("vm://localhos");
                
        
        //Hornetq
        ServerLocator serverLocator;
        
        HornetQConnectionFactory hornetQConnectionFactory = new HornetQConnectionFactory();
//        hornetQConnectionFactory.se
        
        
        jmsTemplate.setConnectionFactory(activeMQConnectionFactory);
        
        
        System.out.println("Sending Message.................");
        jmsTemplate.convertAndSend(dest, message);
        System.out.println("Message Sent");
    }
}
