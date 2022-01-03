/*
 * Copyright (c) 2018, Xyneex Technologies. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * You are not meant to edit or modify this source code unless you are
 * authorized to do so.
 *
 * Please contact Xyneex Technologies, #1 Orok Orok Street, Calabar, Nigeria.
 * or visit www.xyneex.com if you need additional information or have any
 * questions.
 */
package com.xyneex.pharmacie.controller;

import com.xyneex.pharmacie.entity.User;
import com.xyneex.pharmacie.service.UserService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Timosamedet
 * @since Jan 1, 2022 1:34:24 AM
 */
@Controller
public class UserController
{

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRoleAndUser()
    {
        userService.initRolesAndUser();

    }

    @RequestMapping(
            {
                "/"
            })
    public String homePage()
    {
        return ("index");
    }

    /*
    @PostMapping(
            {
                "/registerNewUser"
            }
    )
    
     */
    // @ResponseBody
    @RequestMapping(value = "registerNewUser", method = RequestMethod.POST)
    @ResponseBody
    public String registerNewUser(User user)
    {
        userService.registerNewUser(user);

        return "Your account was created successfull!";
    }

    @GetMapping(
            {
                "/forAdmin"
            })
    @ResponseBody
    //@PreAuthorize("hasRole('Admin')")
    public String forAdmin()
    {
        return "This URL is only accessible to admin";

    }

    @GetMapping(
            {
                "/forUser"
            })
    //@PreAuthorize("hasRole('User')")
    @ResponseBody
    public String forUser()
    {
        return "This URL is only accessbile to the ordinary user";
    }
}
