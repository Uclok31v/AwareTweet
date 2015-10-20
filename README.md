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
`WEB-INF/src/utility/HostPathComponent.java`のパスを適宜変更

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

## Release Note

### ver1.1 2016/10/20
UI調整

### ver1.0 2016/10/13
初回リリース

## Contributor
Shu Kutsuzawa
Kentaro Udonishi
Kenta Tanese

## Next Action
Macのzip解凍への対応
フィルタリングの実装
