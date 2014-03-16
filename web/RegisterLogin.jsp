<%
require_once "include/Session.jsp";
require_once "include/DBConnect.jsp";

// Application credentials
$app_user = "";
$app_pwd = "";

unset($_SESSION['registration_failed']);

if (isset($_POST['userid']) and
    isset($_POST['pwd']) and
    isset($_POST['emailAddress']) and
    isset($_POST['firstName']) and
    isset($_POST['lastName'])) {

    $app_user = $_POST['userid'];
    $app_pwd  = $_POST['pwd'];
    $emailAddress = $_POST['emailAddress'];
    $firstName = $_POST['firstName'];
    $lastName = $_POST['lastName'];

    // NOTE: need to set up to use address information to set up address entry
    $address1 = $_POST['address1'];
    $address2 = $_POST['address2'];
    $city = $_POST['city'];
    $state = $_POST['state'];
    $zipCode = $_POST['zipCode'];
    $country = $_POST['country'];
    $province = $_POST['province'];
    $postalCode = $_POST['postalCode'];
    $phoneNumber = $_POST['phoneNumber'];

    // Check if user already exists
    $sql_validate = "SELECT * FROM USER WHERE LOGIN_ID='".$app_user."' LIMIT 1";
//echo $sql_validate;
    $result = mysql_query($sql_validate, $link);
    $num_rows = mysql_num_rows($result);
    if ($num_rows > 0) {
        $_SESSION['preexisting']='true';
        header("location: registration.jsp?preexist=true".$sql_validate);
    } else {
        //header("location: login.jsp?login_failed=true");
        unset($_SESSION['preexisting']);

        $sql_register = "INSERT INTO USER (LOGIN_ID,LOGIN_PW,LOGIN_PW_QUESTION,LOGIN_PW_ANSWER,EMAIL_ADDRESS,BIRTH_DATE,FIRST_NAME,LAST_NAME,ADDRESS_ID,GENDER_ID,HIRE_DATE,MANAGER_ID) VALUES ('".$app_user."',MD5('".$app_pwd."'),0,NULL,'".$emailAddress."','1950-01-01','".$firstName."','".$lastName."',0,0,'2010-01-01',NULL)";

        $result = mysql_query($sql_register);
        if ($result) {
            $_SESSION['registered']=$app_user;
            header("location: login.jsp");
            //$_SESSION['loggedin']='true';
            //unset($_SESSION['login_failed']);
        } else {
            $_SESSION['registration_failed']=$app_user;
            header("location: registration.jsp");
            //$_SESSION['login_failed']='true';
            //unset($_SESSION['registration_failed']);
        }
    }
} else {
    echo "Registration Data Unavailable";
}
%>