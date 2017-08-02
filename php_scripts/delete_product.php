<?php
 
/*
 * Following code will delete a product from table
 * A product is identified by product id (pid)
 */
 
if ($_SERVER['REQUEST_METHOD']=='POST') {
    $pid = $_POST['pid'];
 
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
 
    // connecting to db
    $conn = new DB_CONNECT();
    $cone = $conn -> con;
 
    // mysql update row with matched pid
    $sql = "DELETE FROM products WHERE pid = $pid";
 
    // check if row inserted or not
    if (mysqli_query($cone, $sql)) {
        echo "Product deleted successfully";
    } else {
        echo "Product deletion unsuccessfull";
    }
}
else {
    echo "Product id missing";
}

?>

