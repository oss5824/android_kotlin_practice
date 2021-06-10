package com.example.myapplication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment

class CrimeFragment: Fragment() {

    private lateinit var crime: Crime
    private lateinit var titleField:EditText
    private lateinit var dateButton: Button
    private lateinit var solvedCheckBox: CheckBox

    //TODO 프래그먼트 생명주기가 액티비티 생명주기와 다른점은 프래그먼트 생명주기 함수는 안드로이드
    //TODO 운영체제가 아닌 호스팅 액티비티의 FragmentManager가 호출한다는점으로
    //TODO 프래그먼트는 액티비티가 내부적으로 처리해서 안드로이드 운영체제는 액티비티가 사용하는
    //TODO 프래그먼트에 관해서는 아무것도 모름름

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime=Crime()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_crime,container,false)

        titleField=view.findViewById(R.id.crime_title) as EditText
        dateButton=view.findViewById(R.id.crime_date) as Button
        solvedCheckBox=view.findViewById(R.id.crime_solved) as CheckBox

        dateButton.apply{
            text=crime.date.toString()
            isEnabled=false
        }

        return view
    }

    override fun onStart() {
        super.onStart()

        val titleWatcher=object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                crime.title=s.toString()
            }

            override fun afterTextChanged(s: Editable?) {
                TODO("Not yet implemented")
            }

        }
        titleField.addTextChangedListener(titleWatcher)
        solvedCheckBox.apply{
            setOnCheckedChangeListener{_,isChecked->
                crime.isSolved=isChecked
            }
        }

    }
}