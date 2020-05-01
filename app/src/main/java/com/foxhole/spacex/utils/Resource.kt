package com.foxhole.spacex.utils

/**
 * Created by Musfick Jamil on 4/19/2020$.
 */

data class Resource<T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS, ERROR, LOADING, REFRESHED, REFRESHING
    }
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

        fun <T> refreshing(data: T?): Resource<T> {
            return Resource(Status.REFRESHING, data, null)
        }

        fun <T> refreshed(data: T?): Resource<T> {
            return Resource(Status.REFRESHED, data, null)
        }
    }
}