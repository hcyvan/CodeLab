# mysql的安装配置

## 在ubuntu中的安装

    1. sudo apt update
    2. sudo apt upgrade
    3. sudo apt install mysql-server mysql-client

    如果想将mysql用于产品
    4. sudo mysql\_secure\_installation
    
## mysql-client操做

### 登录

    > mysql -h HOST -u USER -p PASSWORD;

### 用户管理
    
    创建账户

	> create user USER identified by PASSWORD;

    新创建的账户将被添加到 mysql.user 中。

    更改密码

	> set password=PASSWORD;
    or
	> alter user USER indentified by PASSWORD;

    切换用户

	> alter user 'USER'@'HOST' identified by PASSWORD;
    
    权限赋予

	- 赋予USER在DATABASE.TABLE中的所有权限
	    > grant all on DATABASE.TABLE to USER identified by PASSWORD;

	- 赋予USER在所有数据库和表格中的CREATE权限 
	    > grant CREATE on *.* to USER

    忘记root密码

	1. 在/etc/my.cfg文件中添加 sikp-grant-tables	
	2. 重启 mysql server: sudo /etc/init.d mysql restart
	3. 登录 mysql, 此时，不需要密码
	    > update mysqll.user set authentication_string=password(PASSWORD) where user='root';
	    > quit
	4. 将/etc/my.cfg中的 skip-grant-tables 删除
	5. 重启 mysql server: sudo /etc/init.d mysql restart
    
