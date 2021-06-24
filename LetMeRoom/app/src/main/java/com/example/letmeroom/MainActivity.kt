package com.example.letmeroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import com.example.letmeroom.databinding.ActivityMainBinding
import java.lang.NullPointerException
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)  }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var i = 1

        val service = QuestionDatabase.getInstance(applicationContext)!!.dao()

        binding.btnPrev.setOnClickListener {
            if (i <= 1) {
                Toast.makeText(applicationContext, "첫번째 질문입니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else {
                getQuestion(service, --i)
            }
        }
        binding.btnNext.setOnClickListener {
            try {
                getQuestion(service, ++i)
            } catch(e: NullPointerException) {
                Toast.makeText(applicationContext, "마지막 질문입니다.", Toast.LENGTH_SHORT).show()
                i--
                return@setOnClickListener
            }
        }
        binding.btnSubmit.setOnClickListener {
            service.updateAnswer(i, binding.answer.text.toString())
            Toast.makeText(applicationContext, "저장되었습니다", Toast.LENGTH_SHORT).show()
        }

        try {
            service.addQuestions(QList.getQList())
        } catch (e: RuntimeException) {

        }

        getQuestion(service, i)
    }

    fun getQuestion(service: QuestionDao, i: Int) {
        Log.d("Ssamone", "$i")
        Thread {
            var question = service.getQuestion(i)

            runOnUiThread {
                binding.tvNum.text = "#${question.number}"
                binding.tvContent.text = question.content
                binding.answer.setText(question.answer)
            }
        }.run()
    }
}