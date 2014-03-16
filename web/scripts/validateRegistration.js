function validateRegistration(form)
{
    form.address1.value = trim(form.address1.value);
    form.address2.value= trim(form.address2.value);
    form.city.value = trim(form.city.value);
    //form.country.value = trim(form.country.value);
    form.emailAddress.value = trim(form.emailAddress.value);
    form.firstName.value = trim(form.firstName.value);
    form.lastName.value = trim(form.lastName.value);
    form.phoneNumber.value = trim(form.phoneNumber.value);
    form.postalCode.value = trim(form.postalCode.value);
    form.province.value = trim(form.province.value);
    form.pwd.value = trim(form.pwd.value);
    form.pwdConfirm.value = trim(form.pwdConfirm.value);
    //form.state.value = trim(form.state.value);
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
            alerts += "Password must be different from userid.\n";
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
        if(workingField.value != form.pwdConfirm.value)
        {
            alerts += "Confirmation password does not match password entered.\n";
            if (focusField == initialFocusField)
            {
                focusField = workingField;
            }
        }
    }

    var nameReg = /^[A-z '-]+$/;
    var addressReg = /^[A-z0-9 '-]*$/;
    var emailAddressReg = /^[A-z0-9+-]+\@+[A-z0-9-.]+\.+[A-z]{3}$/;
    var phoneReg = /^[0-9]{10}$/;
    var stateReg = /^[A-Z]{2}$/;
    var provinceReg = /^[A-z -']*$/;
    var cityReg = /^[A-z -']+$/;
    var zipCodeReg = /^[0-9]{5}$/;
    var postalCodeReg = /^[A-Z -']+$/;
    var phoneNumberReg = /^(\(?([1-9]\d{2})\)?-?([1-9]\d{2})\s?-?\s?(\d{4}))$/;

    workingField = form.firstName;
    if(workingField.value == "")
    {
        alerts += "First name cannot be blank.\n";
        if (focusField == initialFocusField)
        {
            focusField = workingField;
        }
    }
    else
    {
        if(!nameReg.test(workingField.value))
        {
            alerts += "First name can only contain letters, spaces, apostrophes and dashes.\n";
            if (focusField == initialFocusField)
            {
                focusField = workingField;
            }
        }
    }

    workingField = form.lastName;
    if(workingField.value == "")
    {
        alerts += "Last name cannot be blank.\n";
        if (focusField == initialFocusField)
        {
            focusField = workingField;
        }
    }
    else
    {
        if(!nameReg.test(workingField.value))
        {
            alerts += "Last name can only contain letters, spaces, apostrophes and dashes.\n";
            if (focusField == initialFocusField)
            {
                focusField = workingField;
            }
        }
    }

    workingField = form.address1;
    if(workingField.value == "")
    {
        alerts += "First address line cannot be blank.\n";
        if (focusField == initialFocusField)
        {
            focusField = workingField;
        }
    }
    else
    {
        if(!addressReg.test(workingField.value))
        {
            alerts += "First address line can only contain letters, spaces, apostrophes and dashes.\n";
            if (focusField == initialFocusField)
            {
                focusField = workingField;
            }
        }
    }

    workingField = form.address2;
    if(!addressReg.test(workingField.value))
    {
        alerts += "Second address line can only contain letters, spaces, apostrophes and dashes.\n";
        if (focusField == initialFocusField)
        {
            focusField = workingField;
        }
    }

    workingField = form.city;
    if(workingField.value == "")
    {
        alerts += "City cannot be blank.\n";
        if (focusField == initialFocusField)
        {
            focusField = workingField;
        }
    }
    else
    {
        if(!cityReg.test(workingField.value))
        {
            alerts += "City can only contain letters, spaces, apostrophes and dashes.\n";
            if (focusField == initialFocusField)
            {
                focusField = workingField;
            }
        }
    }

    workingField = form.state;
    if(form.country.value == "USA" && workingField.value == "")
    {
        alerts += "State cannot be blank for USA.\n";
        if (focusField == initialFocusField)
        {
            focusField = workingField;
        }
    }
    else
    {
        if(!stateReg.test(workingField.value))
        {
            alerts += "State can only contain letters, spaces, apostrophes and dashes.\n";
            if (focusField == initialFocusField)
            {
                focusField = workingField;
            }
        }
    }

    workingField = form.province;
    if(!provinceReg.test(workingField.value))
    {
        alerts += "Province can only contain letters, spaces, apostrophes and dashes.\n";
        if (focusField == initialFocusField)
        {
            focusField = workingField;
        }
    }

    workingField = form.postalCode;
    if(form.country.value == "USA" && workingField.value == "")
    {
        // Proper situation, not needed for USA address
    }
    else
    {
        if(form.country.value == "USA" && workingField.value != "")
        {
            alerts += "Postal code must not be provided for USA.\n";
            if (focusField == initialFocusField)
            {
                focusField = workingField;
            }
        }
        else
        {
            if(form.country.value != "USA" && workingField.value == "")
            {
                alerts += "Postal code cannot be blank for non-USA country.\n";
                if (focusField == initialFocusField)
                {
                    focusField = workingField;
                }
            }
            else
            {
                if(!postalCodeReg.test(workingField.value))
                {
                    alerts += "Postal code can only contain letters, spaces, apostrophes and dashes.\n";
                    if (focusField == initialFocusField)
                    {
                        focusField = workingField;
                    }
                }
            }
        }
    }

    workingField = form.emailAddress;
    if(workingField.value == "")
    {
        alerts += "Email address cannot be blank.\n";
        if (focusField == initialFocusField)
        {
            focusField = workingField;
        }
    }
    else
    {
        if(!emailAddressReg.test(workingField.value))
        {
            alerts += "Email address improperly formatted.\n";
            if (focusField == initialFocusField)
            {
                focusField = workingField;
            }
        }
    }

    workingField = form.phoneNumber;
    if (workingField.value == "")
    {
        //Nothing to do, valid if it is not entered
    }
    else
    {
        if(!phoneNumberReg.test(workingField.value))
        {
            alerts += "Phone number can only contain numbers and dashes.\n";
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