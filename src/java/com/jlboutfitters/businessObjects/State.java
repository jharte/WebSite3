/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.businessObjects;

import com.jlboutfitters.beans.StateBean;
import com.jlboutfitters.object.StateObject;
import com.jlboutfitters.dao.StateDAO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author JamesHarte
 */
public class State {
    public StateBean readState(int id)
            throws Exception
    {
        StateBean stateBean = null;

        StateDAO stateDAO = new StateDAO();
        StateObject stateObject = stateDAO.readState(id);
        if (stateObject != null)
        {
            stateBean = new StateBean(stateObject);
        }
        return stateBean;
    }

    public ArrayList<StateBean> readStates()
            throws Exception
    {
        StateDAO stateDAO = new StateDAO();
        ArrayList<StateObject> stateObjects = stateDAO.readStates();
        ArrayList<StateBean> stateBeans = new ArrayList<StateBean>();
        Iterator<StateObject> it = stateObjects.iterator();
        while (it.hasNext())
        {
            StateObject stateObject = it.next();
            stateBeans.add(new StateBean(stateObject));
        }
        return stateBeans;
    }
}
