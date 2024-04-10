package com.jagdeepk.quizzyapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jagdeepk.quizzyapp.databinding.QuizItemRecyclerRowBinding

class QuizListAdapter(private val quizModelList: List<QuizModel>) :
    RecyclerView.Adapter<QuizListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = QuizItemRecyclerRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return quizModelList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(quizModelList[position])
    }

    // Nested ViewHolder class
    class MyViewHolder(private val binding: QuizItemRecyclerRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: QuizModel) {
            binding.apply {

                quizTitleText.text = model.title
                // Bind other views with data from the model as needed
                quizSubtitleText.text = model.subtitle
                quizTimeText.text = model.time + " min"
                root.setOnClickListener {
                    val intent = Intent(root.context, QuizActivity::class.java)
                    QuizActivity.questionModelList=model.questionList
                    QuizActivity.time=model.time
                    root.context.startActivity(intent)
                }
            }
        }
    }
}
