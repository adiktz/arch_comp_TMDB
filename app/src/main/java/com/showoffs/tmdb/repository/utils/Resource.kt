package com.showoffs.tmdb.repository.utils

/*
 * Copyright (C) Fitternity - All Rights Reserved
 * Written by gaurav <gauravraviji@gmail.com>, 10/17/2018
 *  
 *  This file is a part of the project 'TestApplication'
 */

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
</T> */
data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}