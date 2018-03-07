/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmw.services;

import com.bmw.inter.MailBoxController;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lukisi Motsoeneng
 */
@Service
public class BMWMailboxService implements MailBoxController
{

    @Override
    public void sendEmail(String to, String cc)
    {
        System.out.println("Sending email to : "+to);
    }
    
}
