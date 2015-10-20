-- MySQL dump 10.13  Distrib 5.1.71, for redhat-linux-gnu (x86_64)
--
-- Host: localhost    Database: lab_members
-- ------------------------------------------------------
-- Server version	5.1.71

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profile` (
  `id` varchar(16) NOT NULL,
  `name` varchar(64) NOT NULL,
  `kana` varchar(64) NOT NULL,
  `type` varchar(4) NOT NULL,
  `mail` varchar(128) NOT NULL,
  `password` text NOT NULL,
  `degree` varchar(4) NOT NULL,
  `grade` int(11) NOT NULL,
  `graduation_year` int(11) NOT NULL,
  `bachelor_number` varchar(16) DEFAULT NULL,
  `master_number` varchar(16) DEFAULT NULL,
  `doctor_number` varchar(16) DEFAULT NULL,
  `bachelor_research_number` varchar(16) DEFAULT NULL,
  `master_research_number` varchar(16) DEFAULT NULL,
  `special_research_number` varchar(16) DEFAULT NULL,
  `overseas_number` varchar(16) DEFAULT NULL,
  `organization` varchar(128) NOT NULL,
  `comment` text NOT NULL,
  `research_title` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=sjis;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile`
--

LOCK TABLES `profile` WRITE;
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
INSERT INTO `profile` VALUES ('shotaro','今野翔太郎','コンノショウタロウ','gr','m133303f@st.u-gakugei.ac.jp','97c40e26f4603c120f0e6ed599a225ccb0cad468155242907dcc8bc7bcbde218','M',2,2014,NULL,'m133303',NULL,NULL,NULL,NULL,NULL,'東京学芸大学','てすとー！',NULL),('m123302g','井上翔太','イノウエショウタ','gr','letyourheartshout@gmail.com','61a603abaa28de5ac6f30719e4384e7fc3df180b0b21cfa4f1ed5d3d9a271fff','M',2,2013,NULL,'m123302',NULL,NULL,NULL,NULL,NULL,'東京学芸大学','あ',NULL),('masahito','斉藤大仁','サイトウマサヒト','gr','m133304x@st.u-gakugei.ac.jp','bb9eeba9c6f7a88aaa04660a7b2aaeb790956f66a00ebd1933f165866781f6e4','M',2,2014,NULL,'m133304',NULL,NULL,NULL,NULL,NULL,'東京学芸大学','特になし',NULL),('takafumi','田中昂文','タナカタカフミ','mn','j108011y@st.u-gakugei.ac.jp','f7241b37bdebbf372424d1c125fc88e3bd1fd3b583958336bf95e39530698480','M',2,2013,'j108011','m143303',NULL,NULL,NULL,NULL,NULL,'東京学芸大学','null',NULL),('hazeyama','櫨山淳雄','はぜやまあつお','pr','hazeyama@u-gakugei.ac.jp','668bdce5d048c7c450ce19d6294bd3a628be01bffd591a95f7eef9ebcdc3fe16','T',0,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','櫨山です',NULL),('j118006','江崎藍','エサキアイ','gr','j118006g@st.u-gakugei.ac.jp','b5eb888a3cdeca0fcf6ce8f48828f68a2611fdc220e3255a38674a0e1bd9aca7','B',4,2014,'j118006',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','頑張ります?(^o^)／',NULL),('mana','小谷麻菜美','コタニマナミ','gr','j118009w@st.u-gakugei.ac.jp','8b705f388d1d5948c38996ca8d2ee2e4e3c7e1786dd4da96375cb15dc1a623e2','B',4,2014,'j118009',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','こんにちは(´▽｀*)',NULL),('aya','中浜彩','ナカハマアヤ','gr','j118014g@st.u-gakugei.ac.jp','10016b4549c3b076b3c596446dbcb61db83880b3eb5aef67a3a13852bef9886e','B',4,2014,'j118014',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','よろしくお願いします?(^o^)／',NULL),('shu-','沓澤脩','クツザワシュウ','mn','m153304w@st.u-gakugei.ac.jp','21af5abbee061ce27f75a04a2877a59952b7323fee059c36c4235c02729d5982','M',1,1,'j118008y',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','wao','ContextAwareRecommenderSystem'),('azusa','熊谷梓','クマガイアズサ','gr','a101408x@st.u-gakugei.ac.jp','61a603abaa28de5ac6f30719e4384e7fc3df180b0b21cfa4f1ed5d3d9a271fff','B',4,2013,'a101408',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','(ﾟ∀ﾟ)',NULL),('kinopie','木下彩','キノシタアヤ','gr','a101406f@st.u-gakugei.ac.jp','61a603abaa28de5ac6f30719e4384e7fc3df180b0b21cfa4f1ed5d3d9a271fff','B',4,2013,'a101406',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','(ﾟ∀ﾟ)',NULL),('ayana','吉田綾奈','ヨシダアヤナ','gr','j108015k@st.u-gakugei.ac.jp','61a603abaa28de5ac6f30719e4384e7fc3df180b0b21cfa4f1ed5d3d9a271fff','B',4,2013,'j108015',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','(ﾟ∀ﾟ)',NULL),('yuuna','丸山憂奈','マルヤマユウナ','gr','a101418w@st.u-gakugei.ac.jp','61a603abaa28de5ac6f30719e4384e7fc3df180b0b21cfa4f1ed5d3d9a271fff','B',4,2013,'a101418w',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','(ﾟ∀ﾟ)',NULL),('kyuu','邱起仁','キュウキジン','gr','m123306m@st.u-gakugei.ac.jp','61a603abaa28de5ac6f30719e4384e7fc3df180b0b21cfa4f1ed5d3d9a271fff','M',2,2013,'m123306',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','(ﾟ∀ﾟ)',NULL),('meoudg5','水沼夕貴','ミズヌマユキ','gr','j118016y@st.u-gakugei.ac.jp','6c8808c4e719ac11381a86d428c6b6f91fc98d678e9f542bb5420535dc93cf5b','B',4,2014,'j118016',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','☆彡',NULL),('jme15432','吉井光','ヨシイヒカル','gr','m133311p@st.u-gakugei.ac.jp','3163d48fc9ed3308ce855d9dc2c2232b28ea6766924bc921afdc67844ec78f67','M',2,2014,'m133311',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','明日やろうは馬鹿野郎',NULL),('j128017p','山本駿','ヤマモトシュン','st','j128017p@st.u-gakugei.ac.jp','fd6f092bbd213edbb9e9347c21282ef7aedc0e1c590300c52f5146dd59fb8f74','B',4,1,'j128017',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','田中さん、誕生日おめでとうございます。',NULL),('shunichi','田中俊一','タナカシュンイチ','st','j128010x@st.u-gakugei.ac.jp','732a35682b67c3cef8d295302a0aebe2d1e4a55e7f06b0a8ab575146543a35dd','B',4,1,'j128010',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','お願いします。',NULL),('j128011','種瀬健太','タネセケンタ','st','j128011y@st.u-gakugei.ac.jp','7ef90cc06ea9dab853c60e407e9fd0b0c5ad19c60077830ee9b763915bdc7b2a','B',4,1,'j128011',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','よろしくお願いします',NULL),('fumiya','金井文哉','カナイフミヤ','st','j128007k@st.u-gakugei.ac.jp','0c523ac0c90a283dd9684b5fa8a703154676f5e7bf8d5317c9a75300d3207982','B',4,1,'j128007',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','お願いします！！！！！！！！！！！！',NULL),('takashi','中新井尊','ナカアライタカシ','st','j098036g@st.u-gakugei.ac.jp','61a603abaa28de5ac6f30719e4384e7fc3df180b0b21cfa4f1ed5d3d9a271fff','B',4,1,'j098036',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','名前にa',NULL),('kouji','張堂幸彦','チョウドウタカヒコ','st','j128012w@st.u-gakugei.ac.jp','61a603abaa28de5ac6f30719e4384e7fc3df180b0b21cfa4f1ed5d3d9a271fff','B',4,1,'j128012',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','_(:3 ｣∠)_',NULL),('ActAtsuo','先生代理','せんせいだいり','pr','Act@mail.com','627b1f832af6ab90783c7901a4869326e60aaa6f33b0183c2f860edca984c25f','T',0,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','だいりですばれないようにね！byこんの',NULL),('kentaro','鵜戸西謙太郎','ウドニシケンタロウ','st','a131404n@st.u-gakugei.ac.jp','7ecb903f75265577a39dd95a45c17809e49d319cd1f302ff16840a026060343b','B',3,1,'a131404',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','テスト',NULL),('mio','杉山実央','スギヤマミオ','st','a131411y@st.u-gakugei.ac.jp','2c8f7577f378676f821ec43ef6a3c0c2cef3e537ffd2b05c14e5d6bf7dfbf74a','B',3,1,'a131411',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','よろしくお願いします','null'),('yuri','鍵本悠理子','カギモトユリコ','st','a131408w@st.u-gakugei.ac.jp','1c28594f041bbd8240494713d08bbe55a3a42b0b264538ee7a6177af8fad76d6','B',3,1,'a131408',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','kk',NULL),('ayumi','益田亜由実','マスダアユミ','st','j138011x@st.u-gakugei.ac.jp','dcb1ac05c7a5427af56bce93f9f57b70ccb606e054cabf21e6626047567b962a','B',3,1,'J138011',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','がんばります！',NULL),('wakana','倉田和香菜','クラタワカナ','st','j138003y@st.u-gakugei.ac.jp','652737689967ac2afa4b7fac8c3c492bc05eca8ade75a9cdb63d720a31d0a9d4','B',3,1,'j138003',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','kjnun',NULL),('taneken','たねけん','タネケン','st','j128011y@st.u-gakugei.ac.jp','7ef90cc06ea9dab853c60e407e9fd0b0c5ad19c60077830ee9b763915bdc7b2a','B',4,0,'j128011',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','鵜戸西',NULL),('nabeC','鍋島尚子','ナベシマショウコ','st','r109003k@st.u-gakugei.ac.jp','e09e1b8c096c9a515a135469da9cd8605766d465c9318708bbbc62146616caf2','B',1,0,'r109003',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','なべしって呼んでください',NULL),('shun','山本駿','ヤマモトシュン','st','j128017p@st.u-gakugei.ac.jp','9358aa3814c96b490b86b9da601b9ce6e1d39f7428b905e0b3cc058eed3d63f3','B',4,0,'j128017',NULL,NULL,NULL,NULL,NULL,NULL,'東京学芸大学','データ受かった勝ち組',NULL);
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `research_profile`
--

DROP TABLE IF EXISTS `research_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `research_profile` (
  `id` varchar(16) NOT NULL,
  `research_area` text,
  `keyword` text,
  `skill` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=sjis;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `research_profile`
--

LOCK TABLES `research_profile` WRITE;
/*!40000 ALTER TABLE `research_profile` DISABLE KEYS */;
/*!40000 ALTER TABLE `research_profile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-20 16:03:51
