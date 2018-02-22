/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmw.dao;

import lombok.Data;

/**
 *
 * @author QXU1114
 */

@Data
public class UserDTO
{
    private String userId;
    private String name;
    private String surname;
    private JobRolesDTO job_role;
    public String getUserId()
    {
        return userId;
    }
 
    public void setUserId(String userId)
    {
        this.userId = userId;
}

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

//    public String getSurname()
//    {
//        return surname;
//    }
//
//    public void setSurname(String surname)
//    {
//        this.surname = surname;
//    }

    public JobRolesDTO getJob_role()
    {
        return job_role;
    }

    public void setJob_role(JobRolesDTO job_role)
    {
        this.job_role = job_role;
    }
    
    
    
}
