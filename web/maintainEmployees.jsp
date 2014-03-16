<%@ include file="/include/session.jsp" %>
<%@ page import="com.jlboutfitters.beans.EmployeeBean" %>
<%@ page import="com.jlboutfitters.businessObjects.Employee" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Enumeration" %>

<%
    // Page Specific Variables
    pageDescription = "Maintain Employees";
    titleName = "Maintain Employees";
    accessGroup = ACCESS_GROUP_EMPLOYEE; // Don't set for external since default is true

    Employee employee = new Employee();
    ArrayList<EmployeeBean> myEmployees = employee.readEmployees();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns = "http://www.w3.org/1999/xhtml">
    <%@ include file="/include/head.jsp" %>

    <body>
        <header class="header">
            <img src="images/logo.jpg" alt="<%=clientName%>" style="border-style:none;vertical-align:middle;"/>
        </header>

        <%@ include file="/include/menu_manager.jsp" %>

        <div class="pageBody">
            <center><legend><b>Maintain Employees</b></legend><br/></center>
            <table border="1">
                <tr>
                    <th>
                        <a href="<%=FILENAME_ADD_EMPLOYEE%>"><button type="button">Create New Employee</button></a>
                    </th>
                    <th>
                        Employee&nbsp;Id
                    </th>
                    <th>
                        Manager?
                    </th>
                    <th>
                        First&nbsp;Name
                    </th>
                    <th>
                        Last&nbsp;Name
                    </th>
                    <th>
                        Email&nbsp;Address
                    </th>
                    <th>
                        Phone&nbsp;Number
                    </th>
                </tr>
<%
Iterator<EmployeeBean> it = myEmployees.iterator();
while (it.hasNext())
{
    EmployeeBean myEmployee = it.next();
%>
                <tr>
                    <td>
                        <a href="<%=FILENAME_UPDATE_EMPLOYEE%>?<%=Employee.URLFIELD_EMPLOYEE_ID%>=<%=myEmployee.getEmployeeId()%>"><button type="button">Update</button></a>
                        <a href="<%=FILENAME_DELETE_EMPLOYEE%>?<%=Employee.URLFIELD_EMPLOYEE_ID%>=<%=myEmployee.getEmployeeId()%>"><button type="button">Delete</button></a>
                    </td>
                    <td>
                        <%=myEmployee.getLoginId()%>
                    </td>
                    <td>
                        <%=myEmployee.getManagerInd()%>
                    </td>
                    <td>
                        <%=myEmployee.getFirstName()%>
                    </td>
                    <td>
                        <%=myEmployee.getLastName()%>
                    </td>
                    <td>
                        <%=myEmployee.getEmailAddress()%>
                    </td>
                    <td>
                        <%=myEmployee.getPhoneNumber()%>
                    </td>
                </tr>
<%
}
%>
            </table>
<%
    // This is where the main body of the page resides
    //out.println(pageName);
%>
        </div>

        <footer>
            <%@ include file="/include/footer_employee.jsp" %>
        </footer>

        <%@ include file="/include/ShowEnvironment.jsp" %>
    </body>
</html>
