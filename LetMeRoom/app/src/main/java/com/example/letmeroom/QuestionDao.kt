package com.example.letmeroom

import androidx.room.*

@Dao
interface QuestionDao {
    // 모든 질문들을 가져오기
    @Query("SELECT * FROM questions")
    fun getAllQuestions(): List<Question>
    // 질문 가져오기
    @Query("SELECT * FROM questions WHERE number=:number")
    fun getQuestion(number: Int): Question
    // 답변한 모든 질문들을 가져오기
    @Query("SELECT * FROM questions WHERE NOT content=''")
    fun getAnsweredQuestions(): List<Question>
    // 답변하지 않은 모든 질문들을 가져오기
    @Query("SELECT * FROM questions WHERE content=''")
    fun getUnAnsweredQuestions(): List<Question>

    @Query("SELECT COUNT(*) FROM questions")
    fun getQuestionCount(): Int


    // 질문의 답변 수정하기
    @Query("UPDATE questions SET answer=:answer WHERE number=:number")
    fun updateAnswer(number: Int, answer: String)

    @Insert
    fun addQuestion(question: Question)
    @Insert
    fun addQuestions(questions: List<Question>)
}