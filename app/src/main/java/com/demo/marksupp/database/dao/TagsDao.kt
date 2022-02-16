package com.demo.marksupp.database.dao

import androidx.room.Dao
import com.demo.marksupp.database.entity.Tags

@Dao
abstract class TagsDao : BaseDao<Tags>() {
}