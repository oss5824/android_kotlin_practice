package com.example.myapplication.database

import androidx.room.TypeConverter
import java.util.*

//TODO Room은 기본 데이터 타입을 SQLite 데이터베이스 테이블에 쉽게 저장할 수 있지만, 이외의 다른타입은 문제가 생길 수 있음
//TODO Room이 저장 방법을 모르는 Dat와 UUID 속성에 대해 이런 타입의 데이터를 데이터베이스 테이블에 저장하거나 가져오는
//TODO 방법을 Room에게 알려주어야 함

class CrimeTypeConverters {
    @TypeConverter
    fun fromDate(date: Date?):Long?{
        return date?.time
    }
    @TypeConverter
    fun toDate(millisSinceEpoch:Long?):Date?{
        return millisSinceEpoch?.let{
            Date(it)
        }
    }
    @TypeConverter
    fun toUUID(uuid:String?):UUID?{
        return UUID.fromString(uuid)
    }
    @TypeConverter
    fun fromUUID(uuid:UUID?):String?{
        return uuid?.toString()
    }
}