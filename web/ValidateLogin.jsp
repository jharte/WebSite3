<?jsp
// Application credentials
$app_user = "";
$app_pwd = "";

if (isset($_POST['userid']) and isset($_POST['pwd'])) {
    $app_user = $_POST['userid'];
    $app_pwd  = $_POST['pwd'];

    $sql_validate = "SELECT * FROM USER WHERE LOGIN_ID='".$app_user."' AND LOGIN_PW='".md5($app_pwd)."' LIMIT 1";

    // Connecting, selecting database - host, user, pw
    $result = mysql_select_db($db_instance) or die('Could not select database');
    $num_rows = mysql_num_rows($result);
    if ($num_rows > 0) {
        $_SESSION['loggedin']='true';
    } else {
    }
} else {
    // echo 'No userid available yet';
}
?>