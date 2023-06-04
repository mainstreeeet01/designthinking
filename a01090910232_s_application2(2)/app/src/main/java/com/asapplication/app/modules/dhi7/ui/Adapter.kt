package com.asapplication.app.modules.dhi7.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asapplication.app.R
import com.asapplication.app.databinding.RowDhi2Binding
import com.asapplication.app.modules.dhi7.`data`.model.Dhi2RowModel
import kotlin.Int
import kotlin.collections.List

class Adapter(
  var list: List<Dhi2RowModel>
) : RecyclerView.Adapter<Adapter.RowDhi2VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowDhi2VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_dhi_2,parent,false)
    return RowDhi2VH(view)
  }

  override fun onBindViewHolder(holder: RowDhi2VH, position: Int) {
    val dhi2RowModel = Dhi2RowModel()
    // TODO uncomment following line after integration with data source
    // val dhi2RowModel = list[position]
    holder.binding.dhi2RowModel = dhi2RowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Dhi2RowModel>) {
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
      item: Dhi2RowModel
    ) {
    }
  }

  inner class RowDhi2VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowDhi2Binding = RowDhi2Binding.bind(itemView)
  }
}
