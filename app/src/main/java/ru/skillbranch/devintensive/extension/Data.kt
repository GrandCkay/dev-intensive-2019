package ru.skillbranch.devintensive.extension

import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR


// Форматируем вывода даты экземпляра класса Date по заданному паттерну
fun Date.fotmat(pattern: String="HH:mm:ss dd.MM.yy"):String {
    val dataFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dataFormat.format(this)
}

// Создаем функцию добавления к дата временного сдвига (extension для изменения значения экземпляра Data (добавление/вычитание) на указанную временную единицу)
fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND) : Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
     }
    this.time = time

    return this
}

fun Date.humanizeDiff(date:Date = Date()): String {
    // TODO implemented. To change body of created functions use File | Settings | File Templates.
    return String()
}

// Класс перечислений для обьявления какие единицы времени можем использовать в данной функции
enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}








