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

import com.xyneex.pharmacie.entity.Role;
import com.xyneex.pharmacie.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Timosamedet
 * @since Dec 31, 2021 8:31:57 PM
 */
@RestController
public class RoleController
{
    @Autowired
    private RoleService roleService;

    @PostMapping(
            {
                "/createNewRole"
            })
    public Role createNewRole(@RequestBody Role role)
    {
        return roleService.createNewRole(role);
    }
}
