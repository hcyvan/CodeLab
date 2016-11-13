<?php
$a=array();
$a['a']['ab']=1;

if(isset($a['a'])){
	echo 'This is set';
	var_dump(current(current($a)));
}

abstract class test
{
	public static $config=array();
	public static function add_config($key, $value)
	{
		self::$config[$key]=$value;
	}
}

var_dump(test::$config);
test::add_config('navy', 'cheng yi hang');
var_dump(test::$config);

// echo __FILE__;
echo dirname(__FILE__);
echo get_include_path();
echo time();
echo "--------------\n";
function increase(& $value){
	$value++;
}

$a=0;
// increase($a);
call_user_func('increase', $a);
echo $a;