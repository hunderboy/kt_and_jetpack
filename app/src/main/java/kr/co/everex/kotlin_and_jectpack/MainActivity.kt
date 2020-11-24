package kr.co.everex.kotlin_and_jectpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kr.co.everex.kotlin_and_jectpack.databinding.ActivityMainBinding
import java.util.EnumSet.of
import java.util.List.of


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val mymodel : MyViewModel by viewModels()

        val model : MainViewModel by androidViewModel(application)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // 데이터 관찰 가능하게 observe 패턴 사용
        viewModel.getAll().observe(this, Observer {
            // it을 활용 하던가, todos ->
            binding.resultText.text = it.toString()
        })

        binding.addButton.setOnClickListener {
            viewModel.insert(Todo(binding.todoEdit.text.toString()))
//            lifecycleScope.launch(Dispatchers.IO) {
//            }
        }

    }

}