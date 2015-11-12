AwareTweet
===============

ゼミの気づきの漏れを少なくするためのTwitter風なシステム．

Wikiにて多少情報もまとめている．

ただ，Contributorにとっては`docs/README.md`を見た方が参考になるかもしれない．

|場所|説明してるもの|
|:---:|:---|
|Wiki|構造，開発者への情報，保守者への情報|
|docs|システムの保有機能と実装箇所，設計思想や命名規則|

## Usage
### WEB-INF/src/utility/HostPathComponent.java
`hostPath`を適宜変更

```
package utility;

import java.io.File;

public class HostPathComponent{

	public String createHostPath() {
		// TODO Auto-generated method stub
		String hostPath = "/usr/local/tomcat/webapps/labSystem/";

		return hostPath;
	}

	public String imgHostPath() {
		String hostPath = "http://onyx.u-gakugei.ac.jp/";

		return hostPath;
	}


}
```

### WEB-INF/src/utility/DriverAccessor_Hazelab.java
`USER_NAME`，`PASSWORD`を適宜変更

```
package utility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverAccessor_Hazelab {

	private final static String DRIVER_URL="jdbc:mysql://localhost:3306/lab_members?useUnicode=true&characterEncoding=Windows-31J";


	private final static String DRIVER_NAME="com.mysql.jdbc.Driver";


	private final static String USER_NAME="hazelab";


	private final static String PASSWORD="mallow";


	public Connection createConnection(){
	try{
		Class.forName(DRIVER_NAME);
		Connection con=DriverManager.getConnection(DRIVER_URL,USER_NAME,PASSWORD);
		return con;
		}catch(ClassNotFoundException e){
			System.out.println("Can't Find JDBC Driver.\n");
			}catch(SQLException e){
				 System.out.println("Connection Error.\n");
				}
				return null;
		}

	public void closeConnection(Connection con){
		try{
			con.close();
		}catch(Exception ex){}
	}
}
```

### Mysql(一応)
#### Mysqlでの操作

```
mysql> create database awaretweet;
mysql> create database lab_members;
mysql> create user 'tweet'@'localhost' identified by 'tweet';
mysql> create user 'hazelab'@'localhost' identified by 'mallow';
mysql> grant all on awaretweet.* to 'tweet'@'localhost';
mysql> grant all on lab_members.* to 'hazelab'@'localhost';
```

#### コマンドラインでの操作
`AwareTweet/`配下で

```
$ mysql -u root -p awaretweet < awaretweet.sql
$ mysql -u root -p lab_members < lab_members.sql
```


## Release Note

### ver1.3 2015/11/12
他人のスライドが見れるようになった．
`メンバーから他人をクリック，上のバーのスライドおす．`

### ver1.2 2015/10/21
UI調整
MacのPowerPointからのzipの解凍へ対応

### ver1.1 2015/10/20
UI調整

### ver1.0 2015/10/13
初回リリース

## Contributor
Shu Kutsuzawa
Kentaro Udonishi
Kenta Tanese
Wakana Kurata

## Next Action
フィルタリングの実装
