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


```

## Release Note

### ver2.0 *Comming Soon*
H2DBの組み込み
warファイルで配布可能にする．

### ver1.4 2015/12/10
更新すると同じツイートされる問題の解決
更新ボタンはつくらず`F5`とかでいいかなって感じ

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
