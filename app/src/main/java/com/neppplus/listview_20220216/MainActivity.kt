package com.neppplus.listview_20220216

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.neppplus.listview_20220216.adapters.StudentAdapter
import com.neppplus.listview_20220216.datas.StudentData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mAdapter : StudentAdapter
    val mStudentList = ArrayList<StudentData>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        mStudentList.add( StudentData( "조경진", 1988, "서울시 동대문구" ) )
        mStudentList.add( StudentData( "고재천", 1988, "서울시 중랑구" ) )
        mStudentList.add( StudentData( "방우진", 1983, "경기도 고양시" ) )
        mStudentList.add( StudentData( "서정민", 1984, "경기도 광명시" ) )
        mStudentList.add( StudentData( "이승민", 1994, "서울시 도봉구" ) )
        mStudentList.add( StudentData( "이영종", 1991, "서울시 동대문구" ) )
        mStudentList.add( StudentData( "이윤주", 1989, "서울시 동대문구" ) )
        mStudentList.add( StudentData( "이진실", 1994, "서울시 동대문구" ) )
        mStudentList.add( StudentData( "정동준", 1992, "서울시 동대문구" ) )
        mStudentList.add( StudentData( "최재훈", 1994, "서울시 동대문구" ) )
        mStudentList.add( StudentData( "이성노", 1988, "서울시 동대문구" ) )

        mAdapter = StudentAdapter( this, R.layout.student_list_item, mStudentList)
        studentListView.adapter = mAdapter
        
        studentListView.setOnItemClickListener { parent, view, position, id -> 
            
            val clickedStudent = mStudentList[position]

            Toast.makeText(this, "${clickedStudent.name}학생 클릭됨", Toast.LENGTH_SHORT).show()
            
        }
        
        studentListView.setOnItemLongClickListener { parent, view, position, id -> 
            
            val longClickedStudent = mStudentList[position]

//            Toast.makeText(this, "${longClickedStudent.name} 학생이 길게 클릭됨", Toast.LENGTH_SHORT).show()

            mStudentList.remove( longClickedStudent )

            mAdapter.notifyDataSetChanged()

            return@setOnItemLongClickListener true
        }
        
        
    }
}