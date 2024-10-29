package com.example.bt3_29_10

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adapter.StudentAdapter
import com.example.data.Student

class MainActivity : AppCompatActivity() {

    private lateinit var studentAdapter: StudentAdapter
    private lateinit var fullStudentList: List<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etSearch = findViewById<EditText>(R.id.etSearch)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Tạo danh sách sinh viên mẫu
        fullStudentList = listOf(
            Student("Nguyen Van A", "20123456"),
            Student("Tran Thi B", "20123457"),
            Student("Le Van C", "20123458"),
            Student("Pham Thi D", "20123459"),
            Student("Vo Thi E", "20123460"),
            Student("Nguyen Hoang F", "20123461"),
            Student("Dang Huu G", "20123462"),
            Student("Pham Minh H", "20123463"),
            Student("Le Hoai I", "20123464"),
            Student("Nguyen Van J", "20123465"),
            Student("Tran Anh K", "20123466"),
            Student("Pham Thi L", "20123467"),
            Student("Nguyen Thanh M", "20123468"),
            Student("Do Van N", "20123469"),
            Student("Ho Thi O", "20123470"),
            Student("Vu Minh P", "20123471"),
            Student("Le Thi Q", "20123472"),
            Student("Nguyen Hoang R", "20123473"),
            Student("Bui Van S", "20123474"),
            Student("Hoang Thi T", "20123475"),
            Student("Vo Minh U", "20123476"),
            Student("Le Thi V", "20123477"),
            Student("Nguyen Van W", "20123478"),
            Student("Pham Thi X", "20123479"),
            Student("Dang Hoai Y", "20123480"),
            Student("Tran Thi Z", "20123481")
        )

        // Thiết lập RecyclerView với StudentAdapter
        studentAdapter = StudentAdapter(fullStudentList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = studentAdapter

        // Lắng nghe sự thay đổi của ô tìm kiếm
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val keyword = s.toString().trim()
                if (keyword.length > 2) {
                    searchStudents(keyword)
                } else {
                    // Hiển thị toàn bộ danh sách nếu từ khóa có ít hơn 3 ký tự
                    studentAdapter.updateList(fullStudentList)
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun searchStudents(keyword: String) {
        val filteredList = fullStudentList.filter {
            it.name.contains(keyword, ignoreCase = true) || it.mssv.contains(keyword, ignoreCase = true)
        }
        studentAdapter.updateList(filteredList)
    }
}
