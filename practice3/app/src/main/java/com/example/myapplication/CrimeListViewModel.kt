package com.example.myapplication

import androidx.lifecycle.ViewModel

class CrimeListViewModel: ViewModel() {
    val crimes= mutableListOf<Crime>()

    init{
        for(i in 0 until 100){
            val crime=Crime()
            crime.title="Crime #$i"
            crime.isSolved=i%2==0
            crime.isPolice=if(i%3==0)2 else 1
            crimes+=crime
        }
    }
}