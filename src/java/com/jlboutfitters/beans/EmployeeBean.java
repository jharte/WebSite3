/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.beans;

import com.jlboutfitters.object.EmployeeObject;

/**
 *
 * @author JamesHarte
 */
public class EmployeeBean extends UserBean {
    public static final String PROP_EMPLOYEE_ID = "employeeId";
    public static final String PROP_EMAIL_ADDRESS = "emailAddress";
    public static final String PROP_PHONE_NUMBER = "phoneNumber";
    public static final String PROP_MANAGER_IND = "managerInd";

    private int employeeId;
    private String emailAddress;
    private PhoneNumberBean phoneNumber;
    private String managerInd;

    public EmployeeBean() {
        super();
    }

    public EmployeeBean(EmployeeObject employeeObject, QuestionBean _loginPwQuestion) {
        super(USER_TYPE_EMPLOYEE, employeeObject.getLoginId(), employeeObject.getLoginPw(), employeeObject.getLoginPwAnswer(), employeeObject.getFirstName(), employeeObject.getLastName(), (QuestionBean)null);
        employeeId = employeeObject.getEmployeeId();
        emailAddress = employeeObject.getEmailAddress();
        phoneNumber = new PhoneNumberBean(employeeObject.getPhoneCountryPfx(), employeeObject.getPhoneLineNumber(), employeeObject.getPhoneExtension());
        managerInd = employeeObject.getManagerInd();
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int value) {
        int oldValue = employeeId;
        employeeId = value;
        propertySupport.firePropertyChange(PROP_EMPLOYEE_ID, oldValue, employeeId);
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String value) {
        String oldValue = emailAddress;
        emailAddress = value;
        propertySupport.firePropertyChange(PROP_EMAIL_ADDRESS, oldValue, emailAddress);
    }

    public PhoneNumberBean getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumberBean value) {
        PhoneNumberBean oldValue = phoneNumber;
        phoneNumber = value;
        propertySupport.firePropertyChange(PROP_PHONE_NUMBER, oldValue, phoneNumber);
    }

    public String getManagerInd() {
        return managerInd;
    }

    public void setManagerInd(String value) {
        String oldValue = managerInd;
        managerInd = value;
        propertySupport.firePropertyChange(PROP_MANAGER_IND, oldValue, managerInd);
    }
}
