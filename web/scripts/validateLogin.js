function validateLogin(form)
{
    form.pwd.value = trim(form.pwd.value);
    form.userid.value = trim(form.userid.value);

    var alerts = "";
    var focusField = "";
    var initialFocusField = focusField;
    var workingField = "";

    var useridReg = /^[A-Za-z0-9]{6,8}$/;
    var passwordReg = /^[A-Za-z0-9]{6,8}$/;
    var passwordRegUC = /[A-Z]/;
    var passwordRegLC = /[a-z]/;
    var passwordRegNum = /[0-9]/;

    workingField = form.userid;
    if(workingField.value == "")
    {
        alerts += "Userid cannot be blank.\n";
        if (focusField == initialFocusField)
        {
            focusField = workingField;
        }
    }
    else
    {
        if(!useridReg.test(workingField.value))
        {
            //alert(workingField.value + "\n" + useridReg + useridReg.test(workingField.value))
            alerts += "Userid must contain only letters and numbers.\n";
            if (focusField == initialFocusField)
            {
                focusField = workingField;
            }
        }
    }

    workingField = form.pwd;
    if(workingField.value == "")
    {
        alerts += "Please check that you've entered your password.\n";
        if (focusField == initialFocusField)
        {
            focusField = workingField;
        }
    }
    else
    {
        if(workingField.value.length<6)
        {
            alerts += "Password must contain at least six characters.\n";
            if (focusField == initialFocusField)
            {
                focusField = workingField;
            }
        }
        if(workingField.value==form.userid.value)
        {
            alerts += "Password must be different from Username.\n";
            if (focusField == initialFocusField)
            {
                focusField = workingField;
            }
        }
        if(!passwordRegNum.test(workingField.value))
        {
            alerts += "Password must contain at least one number (0-9).\n";
            if (focusField == initialFocusField)
            {
                focusField = workingField;
            }
        }
        if(!passwordRegLC.test(workingField.value))
        {
            alerts += "Password must contain at least one lowercase letter (a-z).\n";
            if (focusField == initialFocusField)
            {
                focusField = workingField;
            }
        }
        if(!passwordRegUC.test(workingField.value))
        {
            alerts += "Password must contain at least one uppercase letter (A-Z).\n";
            if (focusField == initialFocusField)
            {
                focusField = workingField;
            }
        }
    }

    if (alerts=="")
    {
        return true;
    }
    else
    {
        focusField.focus();
        alert(alerts);
        return false;
    }
}