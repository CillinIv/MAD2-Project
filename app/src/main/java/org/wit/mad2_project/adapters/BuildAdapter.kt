package org.wit.mad2_project.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.wit.mad2_project.R
import org.wit.mad2_project.databinding.CardBuildBinding
import org.wit.mad2_project.models.BuildModel

interface BuildClickListener {
    fun onBuildClick(build: BuildModel)
}

class BuildAdapter constructor(private var builds: List<BuildModel>,
                               private val listener: BuildClickListener)
    : RecyclerView.Adapter<BuildAdapter.MainHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardBuildBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val build = builds[holder.adapterPosition]
        holder.bind(build)
    }

    override fun getItemCount(): Int = builds.size

    inner class MainHolder(val binding : CardBuildBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(build: BuildModel) {
            //binding.buildTitle.text = build.paymentmethod
            binding.imageIcon.setImageResource(R.mipmap.ic_launcher_round)
            binding.root.setOnClickListener { listener.onBuildClick(build) }
            //binding.executePendingBindings()
        }
    }
}