package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

// Создаем data класс User и реализовать Factory для создания экземпляров класса

data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = Date(), // Date - получаем текущую дату и время
    val isOnline: Boolean = false

) {
    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id: String) : this (id, "John", "Doe")

    init {

        println("It's a Live!!! \n" +
                " ${if (lastName === "Doe")"His name id $firstName $lastName" else "Any his name is $firstName $lastName!!!" } \n")
    }


    // Паттерн Factory с методом makeUser(fullName) принимающий в качесте аргумента полное имя пользователя и возвращающий экземпляр класса User

    companion object Factory{
        private var lastId : Int = -1
        fun makeUser(fullName:String?) :User {
            lastId++

            var (firstName, lastName) = Utils.parseFullName(fullName)   // деструктурное присваивание
            return User(id = "$lastId", firstName = firstName, lastName = lastName)
        }
    }

}