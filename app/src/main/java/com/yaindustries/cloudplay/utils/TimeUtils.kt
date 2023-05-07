package com.yaindustries.cloudplay.utils

import java.util.Calendar

object TimeUtils {
    private val calendarInstance = Calendar.getInstance()
    val currentHourIn24 = calendarInstance.get(Calendar.HOUR_OF_DAY)
}