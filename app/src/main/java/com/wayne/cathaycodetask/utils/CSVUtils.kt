package com.wayne.cathaycodetask.utils

import android.content.Context
import com.opencsv.CSVReader
import com.wayne.cathaycodetask.model.api.vo.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.io.InputStreamReader

/**
 * 臺北市立動物園_館區簡介並沒有提供API，
 * 只有提供csv檔案可以下載，
 * 不確定是要直接下載CSV檔案後讀取，
 * 還是要將CSV檔案存入App，
 * 於週四晚間麻煩CakeResume的Janice詢問，
 * 週五晚間，Janice回覆目前還未獲得公司回應。
 * */
object CSVUtils {
    suspend fun getCategories(context: Context): List<Category> {
        return withContext(Dispatchers.IO) {
            val categories: ArrayList<Category> = arrayListOf()
            try {
                val reader = CSVReader(InputStreamReader(context.assets.open("館區介紹_20200206.csv")))
                reader.readNext() // 第一行跳過
                var nextLine: Array<String>? = reader.readNext()
                while (nextLine!= null) {
                    val category = Category(
                        nextLine[1],
                        nextLine[2],
                        nextLine[3],
                        nextLine[4],
                        nextLine[5],
                        nextLine[7]
                    )
                    categories.add(category)
                    nextLine = reader.readNext()
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return@withContext categories
        }
    }
}