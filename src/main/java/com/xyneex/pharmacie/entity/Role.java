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
package com.xyneex.pharmacie.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Timosamedet
 * @since Dec 31, 2021 8:27:19 PM
 */
@Entity
public class Role
{
    @Id
    private String roleName;
    private String roleDecription;

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }

    public String getRoleDecription()
    {
        return roleDecription;
    }

    public void setRoleDecription(String roleDecription)
    {
        this.roleDecription = roleDecription;
    }

}
