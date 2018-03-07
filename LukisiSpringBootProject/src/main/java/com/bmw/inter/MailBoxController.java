package com.bmw.inter;

import org.springframework.stereotype.Component;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lukisi Motsoeneng
 */
@Component
public interface MailBoxController
{
    public void sendEmail(String to, String cc);
}
