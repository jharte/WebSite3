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
public class EmployeeObject {
    private int employeeId;
    private String loginId;
    private String loginPw;
    private int loginPwQuestion;
    private String loginPwAnswer;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneCountryPfx;
    private String phoneLineNumber;
    private String phoneExtension;
    private String managerInd;

    public EmployeeObject() {
    }

    public EmployeeObject(int _employeeId,
                          String _loginId,
                          String _loginPw,
                          int _loginPwQuestion,
                          String _loginPwAnswer,
                          String _firstName,
                          String _lastName,
                          String _emailAddress,
                          String _phoneCountryPfx,
                          String _phoneLineNumber,
                          String _phoneExtension,
                          String _managerInd) {
        this();
        employeeId = _employeeId;
        loginId = _loginId;
        loginPw = _loginPw;
        loginPwQuestion = _loginPwQuestion;
        loginPwAnswer = _loginPwAnswer;
        firstName = _firstName;
        lastName = _lastName;
        emailAddress = _emailAddress;
        phoneCountryPfx = _phoneCountryPfx;
        phoneLineNumber = _phoneLineNumber;
        phoneExtension = _phoneExtension;
        managerInd = _managerInd;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int value) {
        employeeId = value;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String value) {
        loginId = value;
    }

    public String getLoginPw() {
        return loginPw;
    }

    public void setLoginPw(String value) {
        loginPw = value;
    }

    public int getLoginPwQuestion() {
        return loginPwQuestion;
    }

    public void setLoginPwQuestion(int value) {
        loginPwQuestion = value;
    }

    public String getLoginPwAnswer() {
        return loginPwAnswer;
    }

    public void setLoginPwAnswer(String value) {
        loginPwAnswer = value;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) {
        firstName = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String value) {
        lastName = value;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String value) {
        emailAddress = value;
    }

    public String getPhoneCountryPfx() {
        return phoneCountryPfx;
    }

    public void setPhoneCountryPfx(String value) {
        phoneCountryPfx = value;
    }

    public String getPhoneLineNumber() {
        return phoneLineNumber;
    }

    public void setPhoneLineNumber(String value) {
        phoneLineNumber = value;
    }

    public String getPhoneExtension() {
        return phoneExtension;
    }

    public void setPhoneExtension(String value) {
        phoneExtension = value;
    }

    public String getManagerInd() {
        return managerInd;
    }

    public void setManagerInd(String value) {
        managerInd = value;
    }
}
