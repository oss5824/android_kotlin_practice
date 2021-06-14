package com.example.myapplication

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*

class TimePickerFragment: DialogFragment() {

    interface Callbacks{
        fun onTimeSelected(hour:Int,min:Int)
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val cal = Calendar.getInstance()
        val timeSetListener = TimePickerDialog.OnTimeSetListener{
            _,hour,minute->
            targetFragment?.let { fragment ->
                (fragment as Callbacks).onTimeSelected(hour, minute)
            }
        }
            return TimePickerDialog(context,timeSetListener,cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE),true)
    }

}