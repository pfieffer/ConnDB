<?php

include_once './db_connect.php';
 
function getProducts(){
    $db = new DB_CONNECT();
    // array for json response
    $response = array();
    $response["products"] = array();


    $cone=$db->con;
     
    // Mysql select query
    $result = mysqli_query($cone, "SELECT * FROM products");
     
    if(!empty($result)){
        while($row = mysqli_fetch_array($result)){
        // temporary array to create single category
        $tmp = array();
        $tmp["id"] = $row["pid"];
        $tmp["name"] = $row["name"];
        $tmp["price"] = $row["price"];
        $tmp["description"] = $row["description"];

        $response["success"] = 1;

        // push category to final json array
        array_push($response["products"], $tmp);
        }
         
        // keeping response header to json
        header('Content-Type: application/json');
         
        // echoing json result
        echo json_encode($response);
    }
    else{
      // no product found

    $response["success"] = 0;

    $response["message"] = "No product found";

    // echo no users JSON
    echo json_encode($response);
    }
}
 
getProducts();



?>

