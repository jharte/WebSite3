/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.beans;

import com.jlboutfitters.object.QuestionObject;

/**
 *
 * @author JamesHarte
 */
public class QuestionBean extends BaseBean {

    public static final String PROP_QUESTION_ID = "questionId";
    public static final String PROP_QUESTION_TEXT = "questionText";

    private int questionId = 0;
    private String questionText = null;

    public QuestionBean() {
        super();
    }

    public QuestionBean(int _questionId, String questionText) {
        this();
        questionId = _questionId;
        questionText = questionText;
    }

    public QuestionBean(QuestionObject questionObject) {
        this(questionObject.getQuestionId(), questionObject.getQuestionText());
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int value) {
        int oldValue = questionId;
        questionId = value;
        propertySupport.firePropertyChange(PROP_QUESTION_ID, oldValue, questionId);
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String value) {
        String oldValue = questionText;
        questionText = value;
        propertySupport.firePropertyChange(PROP_QUESTION_TEXT, oldValue, questionText);
    }
}
