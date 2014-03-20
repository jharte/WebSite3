/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.beans;

/**
 *
 * @author JamesHarte
 */
public class UserBean extends BaseBean {
    public final static int USER_TYPE_CUSTOMER = 1;
    public final static int USER_TYPE_EMPLOYEE = 2;
    public final static int USER_TYPE_VENDOR   = 3;

    public static final String PROP_USER_TYPE = "userType";
    public static final String PROP_LOGIN_ID = "loginId";
    public static final String PROP_LOGIN_PW = "loginPw";
    public static final String PROP_LOGIN_PW_QUESTION = "loginPwQuestion";
    public static final String PROP_LOGIN_PW_ANSWER = "loginPwAnswer";
    public static final String PROP_FIRST_NAME = "firstName";
    public static final String PROP_LAST_NAME = "lastName";

    public static final String LABEL_USER_TYPE = "User Type";
    public static final String LABEL_LOGIN_ID = "Login Id";
    public static final String LABEL_LOGIN_PW = "Login Password";
    public static final String LABEL_LOGIN_PW_QUESTION = "Password Question";
    public static final String LABEL_LOGIN_PW_ANSWER = "Password Answer";
    public static final String LABEL_FIRST_NAME = "First Name";
    public static final String LABEL_LAST_NAME = "Last Name";

    private int userType;
    private String loginId;
    private String loginPw;
    private QuestionBean loginPwQuestion;
    private String loginPwAnswer;
    private String firstName;
    private String lastName;

    public UserBean() {
        super();
    }

    public UserBean(int _userType, String _loginId, String _loginPw, String _loginPwAnswer, String _firstName, String _lastName, QuestionBean _loginPwQuestion) {
        this();

        userType = _userType;
        loginId = _loginId;
        loginPw = _loginPw;
        loginPwQuestion = _loginPwQuestion;
        loginPwAnswer = _loginPwAnswer;
        firstName = _firstName;
        lastName = _lastName;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int value) {
        int oldValue = userType;
        userType = value;
        propertySupport.firePropertyChange(PROP_USER_TYPE, oldValue, userType);
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String value) {
        String oldValue = loginId;
        loginId = value;
        propertySupport.firePropertyChange(PROP_LOGIN_ID, oldValue, loginId);
    }

    public String getLoginPw() {
        return loginPw;
    }

    private void setLoginPw(String value) {
        String oldValue = loginPw;
        loginPw = value;
        propertySupport.firePropertyChange(PROP_LOGIN_PW, oldValue, loginPw);
    }

    public QuestionBean getLoginPwQuestion() {
        return loginPwQuestion;
    }

    public void setLoginPwQuestion(QuestionBean value) {
        QuestionBean oldValue = loginPwQuestion;
        loginPwQuestion = value;
        propertySupport.firePropertyChange(PROP_LOGIN_PW_QUESTION, oldValue, loginPwQuestion);
    }

    public String getLoginPwAnswer() {
        return loginPwAnswer;
    }

    public void setLoginPwAnswer(String value) {
        String oldValue = loginPwAnswer;
        loginPwAnswer = value;
        propertySupport.firePropertyChange(PROP_LOGIN_PW_ANSWER, oldValue, loginPwAnswer);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) {
        String oldValue = firstName;
        firstName = value;
        propertySupport.firePropertyChange(PROP_FIRST_NAME, oldValue, firstName);
    }

    public String getLastName() {
        return firstName;
    }

    public void setLastName(String value) {
        String oldValue = lastName;
        lastName = value;
        propertySupport.firePropertyChange(PROP_LAST_NAME, oldValue, lastName);
    }
}
