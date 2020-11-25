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

        // 데이터 바인딩 적용 build.gradle Module 수준
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        // 라이브 데이터 때문에 하는 것. = live data 의 라이프사이클 인식을 위해서
        binding.lifecycleOwner = this

        // 뷰모델 선언
        // AndroidViewModel 사용 할 경우 viewmodel 객체 설정
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel // 뷰모델 연결

        /**
         * 아래 해당 코드 연산 처리는
         * Data binding 을 통해 Xml 쪽으로 넘긴다.
         * 그럼으로써 메인Activity 의 코드 량을 줄여준다.
         *
        1. observe 패턴 을 사용한 변경된 데이터 인식 변경
        전체 결과 텍스트
        android:text="@{viewModel.todos.toString()}"
         *
        2. 버튼 클릭을 통한 데이터 처리
        EditText 에서
        android:text="@={viewModel.newTodo}"
         *
        추가 버튼에서
        android:onClick="@{() -> viewModel.insert(viewModel.newTodo)}"
         */
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