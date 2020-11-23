package kr.co.everex.kotlin_and_jectpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kr.co.everex.kotlin_and_jectpack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()

        binding.resultText.text = db.todoDao().getAll().toString()

        binding.addButton.setOnClickListener{
            db.todoDao().insert(Todo(binding.todoEdit.text.toString()))
            binding.resultText.text = db.todoDao().getAll().toString()
        }

    }
}