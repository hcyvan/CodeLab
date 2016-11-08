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

    > create user *USER* identified by *PASSWORD*;

    新创建的账户将被添加到 mysql.user 中。

    更改密码

    > set password *PASSWORD*;

    切换用户

    > alter user '*USER*'@'*HOST*' identified by *PASSWORD*;
    
    权限赋予

    > grant all on *DATABASE.TABLE* to *USER* identified by *PASSWORD*;

