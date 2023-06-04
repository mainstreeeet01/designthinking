package com.asapplication.app.modules.dhi6.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asapplication.app.R
import com.asapplication.app.databinding.RowDhi1Binding
import com.asapplication.app.modules.dhi6.`data`.model.Dhi1RowModel
import kotlin.Int
import kotlin.collections.List

class Adapter(
  var list: List<Dhi1RowModel>
) : RecyclerView.Adapter<Adapter.RowDhi1VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowDhi1VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_dhi_1,parent,false)
    return RowDhi1VH(view)
  }

  override fun onBindViewHolder(holder: RowDhi1VH, position: Int) {
    val dhi1RowModel = Dhi1RowModel()
    // TODO uncomment following line after integration with data source
    // val dhi1RowModel = list[position]
    holder.binding.dhi1RowModel = dhi1RowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Dhi1RowModel>) {
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
      item: Dhi1RowModel
    ) {
    }
  }

  inner class RowDhi1VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowDhi1Binding = RowDhi1Binding.bind(itemView)
  }
}
