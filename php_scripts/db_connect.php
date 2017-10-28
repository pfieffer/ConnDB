<?php
/**

 * A class file to connect to database

 */

class DB_CONNECT {

    

    // constructor

    function __construct() {

        // connecting to database

        $this->connect();

    }

 

    // destructor

    function __destruct() {

        // closing db connection

        $this->close();

    }



    var $con = NULL;

 

    /**

     * Function to connect with database

     */

    function connect() {

        // import database connection variables

        require_once __DIR__ . '/db_config.php';

 

        // Connecting to mysql database

        $this->con = new mysqli(DB_SERVER, DB_USER, DB_PASSWORD, DB_DATABASE) or die(mysql_error());

 


    }

 

    /**

     * Function to close db connection

     */

    function close() {

        // closing db connection

            $this->con->close();



    }

 

}

 

?>
