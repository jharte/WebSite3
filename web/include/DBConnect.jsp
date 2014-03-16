<?jsp

// Set up variables to connect to the database
$db_host = "fsuwinter14.profrusso.com";
$db_user = "jharte";
$db_pass = "tciX9WKb";
$db_instance = "fsuw2014jharte";

// Connecting to database host - host, user, pw
$link = mysql_connect($db_host, $db_user, $db_pass)
    or die('Could not connect: ' . mysql_error());

// Connecting, selecting database
$select_db = mysql_select_db($db_instance, $link)
    or die('Could not select database');

//echo 'Connected successfully';
?>