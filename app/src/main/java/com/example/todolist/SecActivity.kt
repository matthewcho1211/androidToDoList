package com.example.todolist

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import androidx.core.content.ContextCompat



class SecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sec)
        //將變數與 XML 元件綁定
        val btn_send = findViewById<Button>(R.id.btn_send)
        val delete_btn = findViewById<Button>(R.id.delete)
        val ed_time = findViewById<EditText>(R.id.ed_time)
        val ed_todo = findViewById<EditText>(R.id.ed_todo)
        val highBtn = findViewById<RadioButton>(R.id.hightBtn)
        val midBtn = findViewById<RadioButton>(R.id.midBtn)
        val lowBtn = findViewById<RadioButton>(R.id.lowBtn)
        val v = LayoutInflater.from(this).inflate(R.layout.adapter_row, null)

        val tv_todo = v.findViewById<TextView>(R.id.tv_todo)



        //設定按鈕監聽器
        btn_send.setOnClickListener {
            //判斷是否輸入資料
            when {
                ed_time.length() < 1 -> showToast("請輸入時間")
                ed_todo.length() < 1 -> showToast("請輸入事項")
                else -> {
                    if(highBtn.isChecked){
                        tv_todo.setTextColor(Color.RED)
                    }
                    if(midBtn.isChecked){
                        tv_todo.setTextColor(Color.BLUE)
                    }
                    if(lowBtn.isChecked){
                        tv_todo.setTextColor(Color.GREEN)
                    }
                    val b = Bundle()
                    b.putString("time", ed_time.text.toString())
                    b.putString("todo", ed_todo.text.toString())


                    //使用 setResult()回傳聯絡人資料
                    setResult(Activity.RESULT_OK, Intent().putExtras(b))
                    finish()
                }
            }





        }

        delete_btn.setOnClickListener {
            finish()
        }
    }
    //建立 showToast 方法顯示 Toast 訊息
    private fun showToast(msg: String) =
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}