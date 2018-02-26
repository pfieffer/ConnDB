<?php
 
/*
 * Following code will create a new product row
 * All product details are read from HTTP Post Request
 */

 
// check for post
if ($_SERVER['REQUEST_METHOD']=='POST') {
 
    $name = $_POST['name'];
    $price = $_POST['price'];
    $description = $_POST['description'];
 
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
 
    // connecting to db
    $conn = new db_CONNECT();

    $cone=$conn->con;
    
    //escpae the strings to be inserted to DB
    $escapedname = mysqli_real_escape_string($cone, $name);
    $escapedprice = mysqli_real_escape_string($cone, $price);
    $escapeddesc = mysqli_real_escape_string($cone, $description);

    // mysql inserting a new row
    $sql = "INSERT INTO products(name, price, description) VALUES('$escapedname', '$escapedprice', '$escapeddesc')";
    // $result= $cone -> query($sql);
    // $affected = $cone -> affected_rows;

    if (mysqli_query($cone,$sql)) {
        echo "Product created successfully.";
    } else {
        echo "Product creation unsuccessfull";
    }
 
 //    // check if row inserted or not
 //    if ($affected==1) {
 //       echo "Product successfully added.";
 //    } else {
 //        // failed to insert row
    // echo "Some error occured.";
 //    }
} else {
    echo "Some field missing.";
}
?>
