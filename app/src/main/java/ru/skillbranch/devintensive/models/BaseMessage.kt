package ru.skillbranch.devintensive.models

import java.util.*

// Создаем абстрактный класс BaseMessage и два его наследника TextMessage и ImageMessage.

abstract class BaseMessage (
    val id: String,
    val from: User?,
    val chat: Chat,
    val isIncoming: Boolean = false,
    val date: Date = Date()
) {
    // Абстрактный метод formatMessage() - возвращает строку содержащюю информацию о id сообщения, имени получателя/отправителя, виде сообщения ("получил/отправил") и типе сообщения ("сообщение"/"изображение")
    abstract fun formatMessage(): String


    // Реализовываем AbstractFactory для создания экземпляров классов наследников
// Реализуем паттерн AbstractFactory с методом makeMessage(from, chat, date, type, payload, isIncoming = false) принимающий в качесте аргументов пользователя создавшего сообщение, чат к которому относится сообщение, дата сообщения и его тип ("text/image"), полезную нагрузку
     companion object AbstractFactory {
        var lastId = -1
        fun makeMessage(from: User?, chat: Chat, data:Date = Date(), type:String = "text", payload:Any?): BaseMessage {
            lastId++
            return when(type) {
                "image" -> ImageMessage("$lastId", from, chat, date = data, image = payload as String)
                else -> TextMessage("$lastId", from, chat, date = data, text = payload as String)
            }
        }
    }
}