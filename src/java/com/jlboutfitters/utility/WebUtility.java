/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.utility;

/**
 *
 * @author JamesHarte
 */
public class WebUtility {
    public WebUtility() {
    }

    public static String spaceToNbsp(String value)
    {
        return (value==null)?null:value.replace(" ", "&nbsp;");
    }
}
