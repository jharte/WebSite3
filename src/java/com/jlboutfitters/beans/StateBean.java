/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.beans;

import com.jlboutfitters.object.StateObject;

/**
 *
 * @author JamesHarte
 */
public class StateBean extends BaseBean {

    public static final String PROP_STATE_ID = "stateId";
    public static final String PROP_STATE_CODE = "stateCode";
    public static final String PROP_STATE_NAME = "stateName";
    public static final String PROP_STATE_TAX_IND = "stateTaxInd";

    private int stateId = 0;
    private String stateCode = null;
    private String stateName = null;
    private String stateTaxInd = null;

    public StateBean() {
        super();
    }

    public StateBean(int _stateId, String _stateCode, String _stateName, String _stateTaxInd) {
        this();
        stateId = _stateId;
        stateCode = _stateCode;
        stateName = _stateName;
        stateTaxInd = _stateTaxInd;
    }

    public StateBean(StateObject stateObject) {
        this(stateObject.getStateId(), stateObject.getStateCode(), stateObject.getStateName(), stateObject.getStateTaxInd());
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int value) {
        int oldValue = stateId;
        stateId = value;
        propertySupport.firePropertyChange(PROP_STATE_ID, oldValue, stateId);
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String value) {
        String oldValue = stateCode;
        stateCode = value;
        propertySupport.firePropertyChange(PROP_STATE_CODE, oldValue, stateCode);
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String value) {
        String oldValue = stateName;
        stateName = value;
        propertySupport.firePropertyChange(PROP_STATE_NAME, oldValue, stateName);
    }

    public String getStateTaxInd() {
        return stateTaxInd;
    }

    public void setStateTaxInd(String value) {
        String oldValue = stateTaxInd;
        stateTaxInd = value;
        propertySupport.firePropertyChange(PROP_STATE_TAX_IND, oldValue, stateTaxInd);
    }
}
