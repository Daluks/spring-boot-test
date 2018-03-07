/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmw.jms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


/**
 *
 * @author QXU1114
 */
@Component
public class LukisiJMSListener
{
    @JmsListener(destination = "inbound.queue")
    public void receiveMessage(final Message message, Session session)
    {
        try
        {
           
            System.out.println("Receive message : "+message);
            ActiveMQTextMessage mqMsg = (ActiveMQTextMessage) message;
            System.out.println("The Text Message is : "+mqMsg.getText());

        } catch (JMSException ex)
        {
            Logger.getLogger(LukisiJMSListener.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
