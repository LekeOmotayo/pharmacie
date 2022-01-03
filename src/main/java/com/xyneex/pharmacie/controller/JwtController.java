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

import com.xyneex.pharmacie.entity.JwtRequest;
import com.xyneex.pharmacie.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Timosamedet
 * @since Jan 1, 2022 1:39:34 PM
 */
@Controller
@CrossOrigin
public class JwtController
{
    @Autowired
    private JwtService jwtService;

    @GetMapping(
            {
                "/"
            })
    public String homePage()
    {
        return "index";
    }

    @PostMapping(
            {
                "/authenticate"
            })
    @ResponseBody
    public String createJwtToken(JwtRequest jwtRequest) throws Exception
    {
        jwtService.createJwtToken(jwtRequest);
        return "You have successfully login";
    }
}
