package com.showoffs.tmdb.repository.utils

/*
 * Copyright (C) Fitternity - All Rights Reserved
 * Written by gaurav <gauravraviji@gmail.com>, 10/17/2018
 *  
 *  This file is a part of the project 'TestApplication'
 */

/**
 * Status of a resource that is provided to the UI.
 *
 *
 * These are usually created by the Repository classes where they return
 * `LiveData<Resource<T>>` to pass back the latest data to the UI with its fetch status.
 */
enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}