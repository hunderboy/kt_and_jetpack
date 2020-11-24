package kr.co.everex.kotlin_and_jectpack

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room

class MainViewModel(application: Application) : AndroidViewModel(application) {
//class MainViewModel : ViewModel() {

    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "database-name"
    ).build()


    fun getAll(): LiveData<List<Todo>> {
        return db.todoDao().getAll()
    }

    // suspend : 난 무조건 코루틴 안에서 비동기로 처리되어야 한다
    fun insert(todo: Todo) {
        db.todoDao().insert(todo)
    }
}