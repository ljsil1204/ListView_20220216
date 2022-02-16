package com.neppplus.listview_20220216.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.neppplus.listview_20220216.R
import com.neppplus.listview_20220216.datas.StudentData

// 어댑터 클래스가 ArrayAdapter<데이터표현용 클래스(학생데이터)>() 상속받음 -> 재료는 StudentAdapter에서 만들어서 ArrayAdapter()에 전달
class StudentAdapter(
    val mContext: Context,
    val resId:Int,
    val mList: ArrayList<StudentData>
) : ArrayAdapter<StudentData>( mContext, resId, mList ) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if (tempRow == null) {

            tempRow = LayoutInflater.from(mContext).inflate(R.layout.student_list_item, null)

        }

        val row = tempRow!!

        val data = mList[position]

        val txtStudentName = row.findViewById<TextView>(R.id.txtStudentName)
        val txtAge = row.findViewById<TextView>(R.id.txtAge)
        val txtAddress = row.findViewById<TextView>(R.id.txtAddress)

        txtStudentName.text = data.name
        txtAddress.text = data.address

        val age = 2022 - data.birthYear + 1
        txtAge.text = "(${age}세)"


        return row

    }

}