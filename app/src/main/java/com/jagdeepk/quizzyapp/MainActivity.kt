package com.jagdeepk.quizzyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jagdeepk.quizzyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var quizModelList : MutableList<QuizModel>
    lateinit var adapter: QuizListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        quizModelList = mutableListOf()
        getDataFromFirebase()
    }

    private fun setupRecyclerView(){
        adapter = QuizListAdapter(quizModelList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

    }
    private fun getDataFromFirebase(){
        val listQuestionModel= mutableListOf<QuestionModel>()
        listQuestionModel.add(QuestionModel("What is android?", mutableListOf("Language", "OS","Product", "None"), "OS"))
                listQuestionModel.add(QuestionModel("Who owns android?", mutableListOf("Apple", "Google","Samsung", "Microsoft"), "Google"))

                listQuestionModel.add(QuestionModel("Which assistant android uses?", mutableListOf("Siri", "Google assistant","Cortona", "alexa"),"Google"))


                //dummy data
        quizModelList.add(QuizModel("1","Programming","All the basic programing","10", listQuestionModel))
       // quizModelList.add(QuizModel("2","Computer","All the basic computer ques","10"))
       // quizModelList.add(QuizModel("3","Geography","All the basic geo ","18"))
        setupRecyclerView()
    }
}
