package com.example.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.data.Item


val mAdapter = MyAdapter()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycleView = findViewById(R.id.recycler_view)as RecyclerView

        mAdapter.updateList(getItemList())     //傳入資料
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = mAdapter
    }

    fun getItemList (): ArrayList<Item> {
        val myItemList = arrayListOf<Item>()
        //生成資料
        for(i in 0..20) {
            myItemList.add(Item("test"+i.toString(), R.drawable.bylobster_logo))
        }
            return myItemList;
    }
}