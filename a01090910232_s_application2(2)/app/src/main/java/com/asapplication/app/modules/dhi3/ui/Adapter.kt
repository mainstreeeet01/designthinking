package com.asapplication.app.modules.dhi3.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asapplication.app.R
import com.asapplication.app.databinding.RowDhi0Binding
import com.asapplication.app.modules.dhi3.`data`.model.Dhi0RowModel
import kotlin.Int
import kotlin.collections.List

class Adapter(
  var list: List<Dhi0RowModel>
) : RecyclerView.Adapter<Adapter.RowDhi0VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowDhi0VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_dhi_0,parent,false)
    return RowDhi0VH(view)
  }

  override fun onBindViewHolder(holder: RowDhi0VH, position: Int) {
    val dhi0RowModel = Dhi0RowModel()
    // TODO uncomment following line after integration with data source
    // val dhi0RowModel = list[position]
    holder.binding.dhi0RowModel = dhi0RowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Dhi0RowModel>) {
    list = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
  }

  interface OnItemClickListener {
    fun onItemClick(
      view: View,
      position: Int,
      item: Dhi0RowModel
    ) {
    }
  }

  inner class RowDhi0VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowDhi0Binding = RowDhi0Binding.bind(itemView)
  }
}
