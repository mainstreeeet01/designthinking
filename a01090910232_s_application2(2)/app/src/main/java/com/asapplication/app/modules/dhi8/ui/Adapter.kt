package com.asapplication.app.modules.dhi8.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asapplication.app.R
import com.asapplication.app.databinding.RowDhi3Binding
import com.asapplication.app.modules.dhi8.`data`.model.Dhi3RowModel
import kotlin.Int
import kotlin.collections.List

class Adapter(
  var list: List<Dhi3RowModel>
) : RecyclerView.Adapter<Adapter.RowDhi3VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowDhi3VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_dhi_3,parent,false)
    return RowDhi3VH(view)
  }

  override fun onBindViewHolder(holder: RowDhi3VH, position: Int) {
    val dhi3RowModel = Dhi3RowModel()
    // TODO uncomment following line after integration with data source
    // val dhi3RowModel = list[position]
    holder.binding.dhi3RowModel = dhi3RowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Dhi3RowModel>) {
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
      item: Dhi3RowModel
    ) {
    }
  }

  inner class RowDhi3VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowDhi3Binding = RowDhi3Binding.bind(itemView)
  }
}
