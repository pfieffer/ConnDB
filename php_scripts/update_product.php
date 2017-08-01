<?php
 
/*
 * Following code will update a product information
 * A product is identified by product id (pid)
 */
 
// array for JSON response
$response = array();
 
// check for required fields
if ($_SERVER['REQUEST_METHOD']=='POST') {
    $pid = $_POST['pid'];
    $name = $_POST['name'];
    $price = $_POST['price'];
    $description = $_POST['description'];
 
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
 
    // connecting to db
    $conn = new DB_CONNECT();
    $cone = $conn -> con;
 
    // mysql update row with matched pid
    $sql = "UPDATE products SET name = '$name', price = '$price', description = '$description' WHERE pid = $pid";
 
    // check if row inserted or not
    if (mysqli_query($cone, $sql)) {
        echo "Product updated successfully";
    } else {
        echo "Product update unsuccessfull";
    }
}
else {
    echo "Some field missing";
}

?>
