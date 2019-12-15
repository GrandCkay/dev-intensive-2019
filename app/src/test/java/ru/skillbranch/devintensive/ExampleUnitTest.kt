package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extension.TimeUnits
import ru.skillbranch.devintensive.extension.add
import ru.skillbranch.devintensive.extension.fotmat
import ru.skillbranch.devintensive.extension.toUserView
import ru.skillbranch.devintensive.models.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {

        val user2 = User("2", "John", "Cena")
  }
    @Test
    fun test_factory() {
        val user = User.makeUser("John Cena")
//        val user2 = User.makeUser("John Doe")
//        val user = User.makeUser("John Wick")

        val user2 = user.copy(id = "2", lastName = "Doe", lastVisit = Date())   // метод copy позволяет копировать класс и переопределять поля класса
        print("$user \n$user2")
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Wick")

        fun getUserInfo() = user
        val (id, fistName, lastName) = getUserInfo()

        println("$id, $fistName, $lastName")
        println("${user.component1()}, ${user.component2()}, ${user.component3()}")
    }

    @Test
    fun text_copy() {
        val user = User.makeUser("John Wick")
        var user2 = user.copy(lastVisit = Date())
        var user3 = user.copy(lastVisit = Date().add(-20, TimeUnits.SECOND))
        var user4 = user.copy(lastName = "Cena", lastVisit = Date().add(2, TimeUnits.HOUR))


        println("""
            ${user.lastVisit?.fotmat()}
            ${user2.lastVisit?.fotmat()}
            ${user3.lastVisit?.fotmat()}
            ${user4.lastVisit?.fotmat()}
        """.trimIndent())

// Сравнение по дате, хеш и адресу
//        if (user == (user2)) {
//            println("equals data and has \n ${user.hashCode()} $user \n ${user2.hashCode()} $user2")
//        } else {
//            println("not equals data and has \n ${user.hashCode()} $user \n ${user2.hashCode()} $user2")
//        }
//
//        if (user === (user2)) {  // === для сравнение ссылок
//            println("equals adress \n ${System.identityHashCode(user)} ${System.identityHashCode(user2)}")
//        } else {
//            println("not equals adress \n ${System.identityHashCode(user)} ${System.identityHashCode(user2)}")
//        }
    }


    @Test
    fun text_data_maping(){
        val user = User.makeUser("Вася ")
        val newUser = user.copy(lastVisit = Date().add(-7, TimeUnits.SECOND))
        println(newUser)
        val userView = newUser.toUserView()

        userView.printMe()
    }

    @Test
    fun text_abctract_factory() {
        val user = User.makeUser("Вася Пупкин")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type = "text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any image url", type = "image")

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }








}














