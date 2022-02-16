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

//  실제로 xml + 데이터 클래스 조합 => getView 함수 오버라이딩 (커스터마이징)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

//      convertView 변수를 tempRow변수에 담아둔다 => tempRow 비여있다면 xml(student_list_item)을 끌어와서 채워줌.
        var tempRow = convertView
        if (tempRow == null) {

//            xml 끌어올때 LayoutInflater.from(어느화면-StudentAdapter의 변수).inflate(xml, null)
            tempRow = LayoutInflater.from(mContext).inflate(R.layout.student_list_item, null)

        }

//      row 변수에 tempRow를 담음. - !!는 null상태가 아님을 명시
        val row = tempRow!!

        val data = mList[position]

        val txtStudentName = row.findViewById<TextView>(R.id.txtStudentName)
        val txtAge = row.findViewById<TextView>(R.id.txtAge)
        val txtAddress = row.findViewById<TextView>(R.id.txtAddress)

        txtStudentName.text = data.name
        txtAddress.text = data.address

        val age = 2022 - data.birthYear + 1
        txtAge.text = "(${age}세)"


//      row 값을 반환 - 최종결과
        return row

    }

}