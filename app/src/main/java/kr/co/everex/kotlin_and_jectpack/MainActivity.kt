package kr.co.everex.kotlin_and_jectpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.co.everex.kotlin_and_jectpack.databinding.ActivityMainBinding
import java.util.EnumSet.of
import java.util.List.of


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.lifecycleOwner = this // 라이브 데이터 때문에 하는 것.

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel



        // 데이터 관찰 가능하게 observe 패턴 사용
//        viewModel.getAll().observe(this, Observer {
//            // it을 활용 하던가, todos ->
//            binding.resultText.text = it.toString()
//        })
//        binding.addButton.setOnClickListener {
//            lifecycleScope.launch(Dispatchers.IO) {
//                viewModel.insert(Todo(binding.todoEdit.text.toString()))
//            }
//        }



    }

}