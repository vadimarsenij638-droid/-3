package com.assistant.diana

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import android.media.ToneGenerator
import android.media.AudioManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Створюємо інтерфейс програмно, щоб не мучитись з XML файлами
        val root = FrameLayout(this)
        val button = FrameLayout(this).apply {
            layoutParams = FrameLayout.LayoutParams(300, 300).apply {
                gravity = android.view.Gravity.CENTER
            }
            setBackgroundResource(R.drawable.jarvis_circle)
        }

        button.setOnClickListener {
            // Звук активації (як у Джарвіса)
            val tone = ToneGenerator(AudioManager.STREAM_MUSIC, 100)
            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 200)

            // Ефект пульсації
            val anim = AnimationUtils.makeInAnimation(this, true)
            button.startAnimation(anim)
            
            // Тут буде запит до Gemini
        }

        root.addView(button)
        setContentView(root)
    }
}

