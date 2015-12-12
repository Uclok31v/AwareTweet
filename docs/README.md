# AwareTweetの保有機能

## Login
ファイル名にLoginがつくところで実装．
同時にアカウントロックも実装している．
id，passwordをもとにしたログイン機能
id, passwordは研究室の名簿管理システムに問い合わせを行っている．

## アカウントロック
同一ipアドレスで10回認証を失敗したら，そのipアドレスではアクセス不可能になる．
Loginの間にかませている．
アクセスipについては`ip_history`テーブルで管理しており，システムからのアクセスは`dao/IpHistoryDao.java`にて行っている.

## Logout
一般的なログアウト
セッションを破棄する．

## Tweetの登録/閲覧
ほぼ全てのページでtweetが絡んでくるが，tweetの登録や取得は`dao/TweetDao.java`で行っている．
Tweet登録の際，投稿者のアバターのパスをDBに保持している．
アバターの変更のところの話になるが，アバターは全て`avator.png`という名前で保存されるため，
アバターの変更に伴って，過去のtweetのiconも変化する．

## スライドの登録
PowerPointやKeyNoteをJPEG形式で書き出してもらい，書き出されたディレクトリをzip形式にしてユーザに登録してもらう．
圧縮方法はWindowsやMacなどOSによって異なるがすでに対応している．
スライドの登録については，`WEB-INF/src/servlet/RegistSlideServlet.java`で実装．
その際，自作の`WEB-INF/src/utility/UnzipComponent.java`を利用している．
このファイルはzipの解凍について部品化したものであり，OSの違いにも対応したものであるため，
今後zip解凍の機能を持つラボシステム等には流用が可能になっている．

## スライドの閲覧
bxsliderが提供しているcss，jsを利用しての実装
`bxslider/`配下にあるcss，jsを編集することで調整ができる．
変更がある場合はgoogle先生で検索してみるといい

## アバターの変更
ログインした人から順に`avator/`配下にディレクトリが作成されていくわけだが，
最初にアバターが表示されないのはすこし寂しいと感じたので，
`avator/default/avator.png`を作成されたディレクトリ配下にコピーしている．
`WEB-INF/src/servlet/UploadServlet.java`にて実装
ファイルアップロードに関して少し参考になるんじゃないかと思う．
