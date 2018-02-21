/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmw;

import com.bmw.model.UserDTO;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author QXU1114
 */
@Log4j
@RestController
public class UserAdminController
{

    @RequestMapping("/users")
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
        user2.setUserId("QXU1114");
        users.add(user2);
        return users;
    }
    
    
}
