/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.businessObjects;

import com.jlboutfitters.beans.QuestionBean;
import com.jlboutfitters.object.QuestionObject;
import com.jlboutfitters.dao.QuestionDAO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author JamesHarte
 */
public class Question {
    public QuestionBean readQuestion(int id)
            throws Exception
    {
        QuestionBean questionBean = null;

        QuestionDAO questionDAO = new QuestionDAO();
        QuestionObject questionObject = questionDAO.readQuestion(id);
        if (questionObject != null)
        {
            questionBean = new QuestionBean(questionObject);
        }
        return questionBean;
    }

    public ArrayList<QuestionBean> readQuestions()
            throws Exception
    {
        QuestionDAO questionDAO = new QuestionDAO();
        ArrayList<QuestionObject> questionObjects = questionDAO.readQuestions();
        ArrayList<QuestionBean> questionBeans = new ArrayList<QuestionBean>();
        Iterator<QuestionObject> it = questionObjects.iterator();
        while (it.hasNext())
        {
            QuestionObject questionObject = it.next();
            questionBeans.add(new QuestionBean(questionObject));
        }
        return questionBeans;
    }
}
