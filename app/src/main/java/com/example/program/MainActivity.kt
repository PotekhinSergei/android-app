package com.example.program

import android.annotation.SuppressLint
import android.content.res.TypedArray
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var adapter: MyAdapter? = null
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val nav_view = findViewById<NavigationView>(R.id.nav_view)
        nav_view.setNavigationItemSelectedListener(this)

        var list = ArrayList<ListItem>()
        list.addAll(fillArras(resources.getStringArray(R.array.fish), resources.getStringArray(R.array.fish_content), getImageId(R.array.fish_image_array)))


        findViewById<RecyclerView>(R.id.rcView).hasFixedSize()
        findViewById<RecyclerView>(R.id.rcView).layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(list, this)
        findViewById<RecyclerView>(R.id.rcView).adapter = adapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.id_fish ->
            {
                Toast.makeText(this,"Id fish", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.fish),
                    resources.getStringArray(R.array.fish_content),
                    getImageId(R.array.fish_image_array)))
            }
            R.id.id_na ->
            {
                Toast.makeText(this,"Id na", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.na),
                    resources.getStringArray(R.array.na_content),
                    getImageId(R.array.na_image_array)))
            }
            R.id.id_sna ->
            {
                Toast.makeText(this,"Id sna", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.sna),
                    resources.getStringArray(R.array.sna_content),
                    getImageId(R.array.sna_image_array)))
            }
            R.id.id_history ->
            {
                Toast.makeText(this,"Id history", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.history),
                    resources.getStringArray(R.array.history_content),
                    getImageId(R.array.history_image_array)))
            }
        }
        return true
    }
    fun fillArras(titleArray: Array<String>, contentArray:Array<String>, imageArray:IntArray):List<ListItem>
    {
        var listItemArray = ArrayList<ListItem>()
        for (n in 0..titleArray.size - 1)
        {
            var listItem = ListItem(imageArray[n], titleArray[n], contentArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }
    fun getImageId(imageArrayId:Int):IntArray
    {
        var tArray:TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for (i in ids.indices)
        {
            ids[i] = tArray.getResourceId(i, 0)
        }
        tArray.recycle()
        return ids
    }
}