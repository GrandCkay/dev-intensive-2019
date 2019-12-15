package ru.skillbranch.devintensive.utils

object Utils {

    fun parseFullName (fullName:String?): Pair<String?, String?> {

        // TODO FIX ME!!!
        val parts: List<String>? = fullName?.split(" ") // метод split разделяет fullName " " (пустым пробелом)  // ? безопасный метод так как fullName может быть пустым

        var firstName = parts?.getOrNull(0) // getOrNull возвращается null если в колекции нет объекта с индексом 0
        var lastName = parts?.getOrNull(1)

        return firstName to lastName    // return Pair(firstName, lastName)
    }

    fun transliteration(payload: String, divider: String = " "): String {
    //  TODO implemented // To change body of created functions use File | Settings | File Templates.
    return String()
    }

    fun toInitials(firstName: String?, lastName: String?): String {
    // TODO implemented // To change body of created functions use File | Settings | File Templates.
    return String()
    }
}