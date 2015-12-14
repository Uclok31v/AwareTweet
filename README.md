AwareTweet
===============

AwareTweet is Knowledge Management System.

This System can collect "Aware" in meeting as Tweet !

## Install
Coming Soon!!

First, download `awaretweet.conf` from [release page](https://github.com/shu920921/AwareTweet/releases), and put to tomcat's home directory. (e.g. 'home/tomcat')

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

war file you have downloaded put to tomcat server. (e.g. `/usr/local/tomcat/webapps/AwareTweet/`)

Then, you need to restart tomcat.

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

