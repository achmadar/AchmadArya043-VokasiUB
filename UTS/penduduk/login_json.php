<?php

include("config.php");

$sql = "SELECT * FROM user";
$result = array();
$query = mysqli_query($db, $sql);
 
while($row = mysqli_fetch_array($query)){
    array_push($result, array(
    'username' => $row['username'],
    'password' => $row['password']
));
}
echo json_encode(array("result" => $result));
?>



