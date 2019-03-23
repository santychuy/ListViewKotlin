package com.androidapps.techson.listview

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_view_row.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configListView()

    }

    private fun configListView(){
        val listView = ListView

        listView.adapter = MyCustomAdapter(this) //Parecido a los delegados en iOS
    }

}

//En iOS viene siendo los delegados del ListView (TableViewController)
private class MyCustomAdapter(context: Context): BaseAdapter(){

    //Manera rara de tener el parametro pasado
    private val mContext: Context
    private val names = arrayListOf<String>(
        "Donald Trump", "Steve Jobs", "Elon Musk", "Tim Cook", "Donald Trump", "Steve Jobs", "Elon Musk", "Tim Cook",
        "Donald Trump", "Steve Jobs", "Elon Musk", "Tim Cook"
    )

    init {
        this.mContext = context
    }



    override fun getCount(): Int {
        return names.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItem(position: Int): Any {
        return "Test String"
    }

    //Responsable de llenar todas las filas
    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(mContext)
        val rowMain = layoutInflater.inflate(R.layout.list_view_row, viewGroup, false)

        rowMain.tvRow.text = "Row Number: $position"
        rowMain.tvName.text = "Name: ${names.get(position)}"

        return rowMain
    }

}
