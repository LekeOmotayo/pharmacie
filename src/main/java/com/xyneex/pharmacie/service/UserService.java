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
package com.xyneex.pharmacie.service;

import com.xyneex.pharmacie.dao.RoleDAO;
import com.xyneex.pharmacie.dao.UserDAO;
import com.xyneex.pharmacie.entity.Role;
import com.xyneex.pharmacie.entity.User;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Timosamedet
 * @since Jan 1, 2022 1:36:20 AM
 */
@Service
public class UserService
{

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user)
    {
        Role role = roleDAO.findById("User").get();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRole(roles);

        user.setUserPassword(getEncondedPassword(user.getUserPassword()));
        return userDAO.save(user);

    }

    public void initRolesAndUser()
    {
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDecription("Admmin role");
        roleDAO.save(adminRole);

        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserPassword(getEncondedPassword("admin@pass"));
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDAO.save(adminUser);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDecription("Default role for newly created record ");
        roleDAO.save(userRole);
        /*
        User user = new User();
        user.setUserName("user123");
        user.setUserFirstName("user");
        user.setUserLastName("user");
        user.setUserPassword(getEncondedPassword("user@pass"));
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDAO.save(user);
         */
    }

    public String getEncondedPassword(String password)
    {
        return passwordEncoder.encode(password);
    }

}
