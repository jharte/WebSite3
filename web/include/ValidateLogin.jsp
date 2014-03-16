<?jsp
// Application credentials
$app_user = "";
$app_pwd = "";

if (isset($_POST['userid']) and isset($_POST['pwd'])) {
    $app_user = $_POST['userid'];
    $app_pwd  = $_POST['pwd'];

    $sql_validate = "SELECT * FROM USER WHERE LOGIN_ID='".$app_user."' AND LOGIN_PW='".md5($app_pwd)."' LIMIT 1";

    $result = mysql_query($sql_validate, $link);
    $num_rows = mysql_num_rows($result);
    if ($num_rows > 0) {
        //header("location: login.jsp?loggedin=true");
        $_SESSION['loggedin']='true';
        $_SESSION['active_app_user']=$app_user;
        unset($_SESSION['login_failed']);
    } else {
        //header("location: login.jsp?login_failed=true");
        $_SESSION['login_failed']='true';
        unset($_SESSION['loggedin']);
    }
} else {
    //echo 'No userid available yet';
}
?>