package com.wof.ms.users.controller;

import com.wof.ms.users.domain.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Abstract class for the controller.
 * @author santiago.vasco
 */
public abstract class AbstractController<T extends IService> {

    /**
     * Services to handle the business logic for each controller implementation.
     */
    @Autowired
    protected T service;
}
