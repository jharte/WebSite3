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
public class StateObject {
    private int stateId = 0;
    private String stateCode = null;
    private String stateName = null;
    private String stateTaxInd = null;

    //private StateBean state = null;

    public StateObject() {
    }

    public StateObject(int _stateId, String _stateCode, String _stateName, String _stateTaxInd) {
        this();
        stateId = _stateId;
        stateCode = _stateCode;
        stateName = _stateName;
        stateTaxInd = _stateTaxInd;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int value) {
        stateId = value;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String value) {
        stateCode = value;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String value) {
        stateName = value;
    }

    public String getStateTaxInd() {
        return stateTaxInd;
    }

    public void setStateTaxInd(String value) {
        stateTaxInd = value;
    }
}
