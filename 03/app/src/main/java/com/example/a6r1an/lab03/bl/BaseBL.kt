package com.example.a6r1an.lab03.bl

/**
 * Created by Josue on 25/03/2018.
 */
interface BaseBL<K,T>{
    fun create(obj: T): T
    fun read(key: K): T?
    fun readAll(): List<T>
    fun update(obj: T): T?
    fun delete(key: K): T?
}