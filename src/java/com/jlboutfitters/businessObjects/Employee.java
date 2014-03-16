/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.businessObjects;

import com.jlboutfitters.beans.EmployeeBean;
import com.jlboutfitters.beans.QuestionBean;
import com.jlboutfitters.object.EmployeeObject;
import com.jlboutfitters.dao.EmployeeDAO;
import com.jlboutfitters.dao.QuestionDAO;
import com.jlboutfitters.object.QuestionObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author JamesHarte
 */
public class Employee {
    public static String URLFIELD_EMPLOYEE_ID = "EMPLOYEE_ID";

    public EmployeeBean readEmployee(int id)
            throws Exception
    {
        EmployeeBean employeeBean = null;

        EmployeeDAO employeeDAO = new EmployeeDAO();
        EmployeeObject employeeObject = employeeDAO.readEmployee(id);
        if (employeeObject != null)
        {
            QuestionDAO questionDAO = new QuestionDAO();
            QuestionObject questionObject = questionDAO.readQuestion(employeeObject.getLoginPwQuestion());
            QuestionBean questionBean = null;
            if (questionObject != null)
            {
                questionBean = new QuestionBean(questionObject);
            }
            employeeBean = new EmployeeBean(employeeObject, questionBean);
        }
        return employeeBean;
    }

    public ArrayList<EmployeeBean> readEmployees()
            throws Exception
    {
        EmployeeBean employeeBean = null;

        EmployeeDAO employeeDAO = new EmployeeDAO();
        ArrayList<EmployeeObject> employeeObjects = employeeDAO.readEmployees();
System.out.println("Employee "+employeeObjects.size());
        ArrayList<EmployeeBean> employeeBeans = new ArrayList<EmployeeBean>();
        Iterator<EmployeeObject> it = employeeObjects.iterator();
        while (it.hasNext())
        {
            EmployeeObject employeeObject = it.next();

            QuestionDAO questionDAO = new QuestionDAO();
            QuestionObject questionObject = questionDAO.readQuestion(employeeObject.getLoginPwQuestion());
            QuestionBean questionBean = null;
            if (questionObject != null)
            {
                questionBean = new QuestionBean(questionObject);
            }
            employeeBean = new EmployeeBean(employeeObject, questionBean);
            employeeBeans.add(employeeBean);;
        }
        return employeeBeans;
    }
}
