/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.object;

//import java.beans.*;
//import java.io.Serializable;

/**
 *
 * @author JamesHarte
 */
public class QuestionObject {
    private int questionId = 0;
    private String questionText = null;

    //private QuestionBean question = null;

    public QuestionObject() {
    }

    public QuestionObject(int _questionId, String _questionText) {
        this();
        questionId = _questionId;
        questionText = _questionText;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int value) {
        questionId = value;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String value) {
        questionText = value;
    }
}
