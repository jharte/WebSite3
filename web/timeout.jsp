<?jsp
session_start();
session_destroy();
header("Location: login.jsp?timeout=true");
?>