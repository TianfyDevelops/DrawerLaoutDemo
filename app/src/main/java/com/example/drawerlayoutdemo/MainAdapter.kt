package com.example.drawerlayoutdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.drawerlayoutdemo.databinding.MainItemLayoutBinding

/**
 *
 * @ProjectName:    DrawerLayoutDemo
 * @Package:        com.example.drawerlayoutdemo
 * @ClassName:      MainAdapter
 * @Description:     java类作用描述
 * @Author:         tianfy
 * @CreateDate:     2021/3/17 21:46
 * @UpdateUser:     更新者：
 * @UpdateDate:     2021/3/17 21:46
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */
class MainAdapter(private val itemName: Array<out String>) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private lateinit var onItemClickListener: (position: Int) -> Unit

    class MainViewHolder(val binding: MainItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = MainItemLayoutBinding.inflate(LayoutInflater.from(parent.context))
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.binding.tvItem.text = itemName[position]
        holder.binding.root.setOnClickListener {
            onItemClickListener.invoke(position)
        }
    }

    override fun getItemCount(): Int = itemName.size


    fun setOnItemClickListener(onItemClickListener: (position: Int) -> Unit) {
        this.onItemClickListener = onItemClickListener
    }

}