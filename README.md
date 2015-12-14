AwareTweet
===============

AwareTweet is Knowledge Management System.

This System can collect "Aware" as Tweet !

## Install
Coming Soon!!

### Property File
#### Download
First, download `awaretweet.conf` from [release page](https://github.com/shu920921/AwareTweet/releases), and put to tomcat's home directory. (e.g. 'home/tomcat')

#### Edit
You edit `awaretweet.conf`.

```
appRootPath=Full Path to AwareTweet (e.g. /usr/local/tomcat/webapps/AwareTweet/)
hostPath=http host of your server and alpha (e.g. http://exsample.com/AwareTweet/)
driverURL=jdbc:h2:file:~/.awaretweet/data
driverName=org.h2.Driver
dbUserName=sa
dbUserPassword=
```

Please check value of `appRootPath` and `hostPath`.

You need not change `driverURL` ~ `dbUserPassword`. But, `dbUserName` and `dbUserPassword` might be better to change, because this system have no manager.

#### Put on TOMCAT HOME
You put `awaretweet.conf` to TOMCAT HOME(e.g. `/home/tomcat`)

### AwareTweet.war
#### Deploy
You put `AwareTweet.war` to path you have edited (appRootPath).

Then, you need to restart tomcat.

#### Access
Type on your browser `http://your.server.com/AwareTweet/jsp/common/login.jsp` !

*URL is not cool.....

Please set of httpd setting , if necessary.


## Usage

Default id and password as bellow.

|id|pass|
|:---:|:---:|
|root|root|

Then, you can start Knowledge management using this system.

## Release Note
### ver1.0 *Comming Soon*

## Contributor
#####*Shu Kutsuzawa*
#####*Kenta Tanese*
