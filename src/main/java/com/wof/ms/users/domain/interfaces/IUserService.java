/*
 * Copyright (c) 2019 by ViliV. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * ViliV. ("Confidential Information").
 * You may not disclose such Confidential Information, and may only
 * use such Confidential Information in accordance with the terms of
 * the agreement you entered into with ViliV.
 */

package com.wof.ms.users.domain.interfaces;

import com.wof.ms.users.model.Users;
import java.util.List;

/**
 * Interface for User service which allows this application to make calls to business logic from the controller layer.
 *
 * @author santiago.vasco
 */
public interface IUserService extends IService {

    /**
     * Get All Users.
     */
    List<Users> getAll();

}
