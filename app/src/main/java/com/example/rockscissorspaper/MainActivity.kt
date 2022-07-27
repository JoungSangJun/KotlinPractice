package com.example.rockscissorspaper

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.example.rockscissorspaper.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    /* 0 : rock, 1 : scissors, 2 : paper */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*뷰 바인딩*/
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rock.setOnClickListener {
            start(0)
        }

        binding.scissors.setOnClickListener {
            start(1)
        }

        binding.paper.setOnClickListener {
            start(2)
        }

    }

    /*상대 가위바위보 정하는 함수*/
    private fun start(MyPosition: Int) {
        val enemy = findViewById<ImageView>(R.id.enemy)
        var enemyPosition: Int = 0

        /*상대방이 낸 것 랜덤지정*/
        when (Random.nextInt(3)) {
            0 -> {
                enemy.setImageResource(R.drawable.rock)
                enemyPosition = 0
            }
            1 -> {
                enemy.setImageResource(R.drawable.scissors)
                enemyPosition = 1
            }
            2 -> {
                enemy.setImageResource(R.drawable.paper)
                enemyPosition = 2
            }
        }

        /*버튼의 이벤트 핸들러 등록, Negative 클릭시 앱 종료*/
        val eventHandler = object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                if (p1 == DialogInterface.BUTTON_NEGATIVE) {
                    finish()
                }
            }
        }

        /*승자 정하는 조건문*/
        if (MyPosition == enemyPosition) {
            AlertDialog.Builder(this).run {
                setTitle("무승부입니다.")
                setMessage("다시 하시겠습니까?")
                setPositiveButton("Yes", null)
                setNegativeButton("NO", eventHandler)
                show()
            }
        } else if (MyPosition == 0 && enemyPosition == 1 || MyPosition == 1 && enemyPosition == 2 ||
            MyPosition == 2 && enemyPosition == 0
        ) {
            AlertDialog.Builder(this).run {
                setTitle("승리하였습니다.")
                setMessage("다시 하시겠습니까?")
                setPositiveButton("Yes", null)
                setNegativeButton("NO", eventHandler)
                show()
            }
        } else {
            AlertDialog.Builder(this).run {
                setTitle("패배하였습니다.")
                setMessage("다시 하시겠습니까?")
                setPositiveButton("Yes", null)
                setNegativeButton("NO", eventHandler)
                show()
            }
        }

    }
}