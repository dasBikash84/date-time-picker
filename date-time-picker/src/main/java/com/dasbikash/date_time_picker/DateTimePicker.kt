package com.dasbikash.date_time_picker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.CalendarView
import android.widget.TimePicker
import java.util.*

class DateTimePicker(
    date:Date?=null,
    val doOnDateTimeSet:(Date)->Unit
){
    private val dateTime:Calendar
    init {
        dateTime = Calendar.getInstance()
        if (date != null){
            dateTime.time = date
        }
    }

    fun display(context: Context){
        val view = LayoutInflater.from(context).inflate(R.layout.view_date_time_picker,null,false)
        val calView = view.findViewById<CalendarView>(R.id.date_picker)
        val timePicker = view.findViewById<TimePicker>(R.id.time_picker)

        calView.visibility = View.VISIBLE
        timePicker.visibility = View.GONE

        calView.setOnDateChangeListener(object : CalendarView.OnDateChangeListener{
            override fun onSelectedDayChange(
                view: CalendarView,
                year: Int,
                month: Int,
                dayOfMonth: Int
            ) {
                dateTime.set(Calendar.YEAR,year)
                dateTime.set(Calendar.MONTH,month)
                dateTime.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                calView.visibility = View.GONE
                timePicker.visibility = View.VISIBLE
            }
        })

        timePicker.setOnTimeChangedListener(object : TimePicker.OnTimeChangedListener{
            override fun onTimeChanged(view: TimePicker?, hourOfDay: Int, minute: Int) {
                dateTime.set(Calendar.HOUR_OF_DAY,hourOfDay)
                dateTime.set(Calendar.MINUTE,minute)
            }
        })

        DialogUtils.showAlertDialog(context, DialogUtils.AlertDialogDetails(
            view = view,
            isCancelable = false,
            doOnPositivePress = {
                doOnDateTimeSet(dateTime.time)
            }
        ))
    }
}