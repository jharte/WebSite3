/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.object;

import java.sql.Date;

/**
 *
 * @author JamesHarte
 */
public class CustomerObject {
    private int customerId;
    private String loginId;
    private String loginPw;
    private int loginPwQuestion;
    private String loginPwAnswer;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Date birthDate;
    private String phoneCountryPfx;
    private String phoneLineNumber;
    private String phoneExtension;
    private int mailingAddressId;
    private int genderId;

    public CustomerObject() {
    }

    public CustomerObject(int _customerId,
                          String _loginId,
                          String _loginPw,
                          int _loginPwQuestion,
                          String _loginPwAnswer,
                          String _firstName,
                          String _lastName,
                          String _emailAddress,
                          Date _birthDate,
                          String _phoneCountryPfx,
                          String _phoneLineNumber,
                          String _phoneExtension,
                          int _mailingAddressId,
                          int _genderId) {
        this();
        customerId = _customerId;
        loginId = _loginId;
        loginPw = _loginPw;
        loginPwQuestion = _loginPwQuestion;
        loginPwAnswer = _loginPwAnswer;
        firstName = _firstName;
        lastName = _lastName;
        emailAddress = _emailAddress;
        birthDate = _birthDate;
        phoneCountryPfx = _phoneCountryPfx;
        phoneLineNumber = _phoneLineNumber;
        phoneExtension = _phoneExtension;
        mailingAddressId = _mailingAddressId;
        genderId = _genderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int value) {
        customerId = value;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date value) {
        birthDate = value;
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

    public int getMailingAddressId() {
        return mailingAddressId;
    }

    public void setMailingAddressId(int value) {
        mailingAddressId = value;
    }

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int value) {
        genderId = value;
    }
}
