package com.example.wycodelib.customview

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.wycodelib.R
import com.example.wycodelib.customview.adapter.CustomViewAdapter
import com.example.wycodelib.customview.bean.TypeBean
import com.example.wycodelib.customview.weight.SuperDividerItemDecoration
import kotlinx.android.synthetic.main.activity_custom_view.*
import java.util.*

/**
 * @ClassName CustomView
 * @Description TODO
 * @Author User
 * @Date 2020/5/25 11:15
 * @Version 1.0
 * e-mail：oom1391069@163.com
 */
class CustomView : AppCompatActivity(), BaseQuickAdapter.OnItemClickListener {

    private val typeBeans = ArrayList<TypeBean>()

    private var adapter: CustomViewAdapter? = null

    private val data: List<TypeBean>
        get() {
            typeBeans.add(TypeBean("", 0))
            return typeBeans
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)

        adapter = CustomViewAdapter(data)
        adapter!!.onItemClickListener = this

        rv_custom_view.layoutManager = LinearLayoutManager(this)
        rv_custom_view.adapter = adapter
        rv_custom_view.addItemDecoration(SuperDividerItemDecoration.Builder(this).build())

    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        when(typeBeans[position].type){

        }
    }
}