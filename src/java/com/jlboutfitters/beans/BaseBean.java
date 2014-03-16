/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author JamesHarte
 */
public class BaseBean implements Serializable {

    //public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    //private String sampleProperty;
    protected PropertyChangeSupport propertySupport;

    public BaseBean() {
        propertySupport = new PropertyChangeSupport(this);
    }

    public static String spaceToNbsp(String value)
    {
        return (value==null)?null:value.replace(" ", "&nbsp;");
    }

    //public String getSampleProperty() {
    //    return sampleProperty;
    //}

    //public void setSampleProperty(String value) {
    //    String oldValue = sampleProperty;
    //    sampleProperty = value;
    //    propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
    //}

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
}
