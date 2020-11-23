package kr.co.everex.kotlin_and_jectpack

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo (
    var title: String
) {
    @PrimaryKey(autoGenerate = true) val id: Int = 0
}