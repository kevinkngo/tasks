package org.tasks.data

import androidx.room.*

@Dao
interface PrincipalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(principal: List<Principal>)

    @Query("""
DELETE
FROM principals
WHERE principal_list = :list
  AND principal NOT IN (:principals)""")
    fun deleteRemoved(list: Long, principals: List<String>)

    @Delete
    fun delete(principals: List<Principal>)

    @Query("SELECT * FROM principals")
    fun getAll(): List<Principal>
}