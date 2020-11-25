package kr.co.everex.kotlin_and_jectpack

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "database-name"
    ).build()

    // Todo 객체를 포함하는 List 형태의 LiveData
    var todos : LiveData<List<Todo>>

    // 추가할 Text
    // 추가 버튼 누를 시에 EditText 의 입력된 Text 가 newTodo 에 할당됨
    // 할당된 Text가 MainViewModel 의  insert 함수를 통해 viewModelScope(ViewModel 비동기 처리를 통해 처리됨)
    var newTodo: String? = null

    init {
        todos = getAll()
    }
    // 데이터 전체 추출
    fun getAll(): LiveData<List<Todo>> {
        return db.todoDao().getAll()
    }

    // suspend : 난 무조건 코루틴 안에서 비동기로 처리되어야 한다
    fun insert(todo: String) {
//        db.todoDao().insert(todo)

        //Todo Room 접근은 비동기 처리를 통해 접근해야 한다.
        viewModelScope.launch(Dispatchers.IO) {
            db.todoDao().insert(Todo(todo))
        }
    }

}