# InterfaceRobot
##### グループ制作  

## 制作の背景
###### 現在PCの内部には様々なシステム・機能が備わっており、その全て使いこなすことは困難です。また、PC操作に慣れていない人達では標準の機能でも使いこなすことができない可能性があります。その状態では作業の効率が悪くなってしまい、PCの機能をフルに活用することができません。その扱いにくさや動作の面倒さを解決するため、使用者が行いたい動作をコマンドとして直感的に入力し、入力したコマンドに対しての要望に応えられるシステムを構築したいと考えました。そのシステムを実現するに当たって、ロボットに話しかけるようにコマンドを入力するような、便利なインターフェースを作りたいと考えました。  

## 要件
###### 機能を使用するためには会員登録し、ログインが必要
###### ログアウトすることができる
###### ログイン時にロボットにコマンドで命令できる
###### ロボットは命令された内容に基づいて予め決められた処理を行う
###### ユーザーは他のユーザーを検索し、’フレンド’に登録することができる
###### フレンドになったユーザー同士はチャットを行うことができる
### (拡張機能要件)
###### 初期システムで登録されていない機能の実行ファイルがある場合、使用者はその実行ファイルの場所を指定し、システムに組み込むことができる。
###### また、その際のロボットの応答内容も任意に登録、変更することができる。  

## データベース
## database作成と切り替え
###### create database InterfaceRobot
###### use InterfaceRobot  

## table作成
### Account tabale
###### create table account(
###### id char(6)  primary key,
###### name varchar(20) not null,
###### pass varchar(20) not null,
###### mail varchar(50) not null,
###### BotName varchar(20) not null
###### );  
### command table
###### create table command(
###### id int primary key auto_increment,
###### name varchar(20) not null,
###### command  varchar(255) not null
###### );  
### BotAction table
###### create table BotAction(
###### id int primary key auto_increment,
###### userID char(6),
###### resID int not null,
###### action varchar(100) not null
###### );  
### create table BotResponse(
###### id int  not null,
###### userID char(6),
###### response varchar(255) not null
###### );  
### PathList table
###### create table PathList(
###### id int not null,
###### userID char(6),
###### path varchar(500) not null
###### );
### Remind table
###### create table Remind(
###### id  int primary key auto_increment,
###### userID char(6) not null,
###### remind varchar(255) not null,
###### category varchar(20) not null
###### );  
### Friend table
###### create table Friend(
###### id int primary key auto_increment,
###### userID char(6) not null,
###### friendID char(6) not null
###### );  
### Chat table
###### create table Chat(
###### id int primary key auto_increment,
###### friendID int not null,
###### userID char(6) not null,
###### chat varchar(255) not null
###### );  

## INSERT文でロボットの対応を設定
###### insert into botaction (resID,action) values(1,'おはよう');
###### insert into botaction (resID,action) values(1,'お早う');
###### insert into botaction (resID,action) values(1,'おはようございます');
###### insert into botaction (resID,action) values(1,'お早うございます');
###### insert into botaction (resID,action) values(2,'こんにちは');
###### insert into botaction (resID,action) values(3,'こんばんは');
###### insert into botaction (resID,action) values(3,'今晩は');
###### insert into botaction (resID,action) values(4,'Logout');
###### insert into botaction (resID,action) values(4,'ログアウト');
###### insert into botaction (resID,action) values(4,'さようなら');
###### insert into botaction (resID,action) values(4,'bye');
###### insert into botaction (resID,action) values(4,'good bye');
###### insert into botaction (resID,action) values(5,'ごきげんよう');
###### insert into botaction (resID,action) values(6,'memo');
###### insert into botaction (resID,action) values(6,'notepad');
###### insert into botaction (resID,action) values(6,'メモ帳');
###### insert into botaction (resID,action) values(6,'メモ帖');
###### insert into botaction (resID,action) values(6,'メモ');
###### insert into botaction (resID,action) values(7,'chrome');
###### insert into botaction (resID,action) values(7,'google chrome');
###### insert into botaction (resID,action) values(7,'クローム');
###### insert into botaction (resID,action) values(7,'検索');
###### insert into botaction (resID,action) values(7,'グーグルクローム');
###### insert into botaction (resID,action) values(8,'エクスプローラ');
###### insert into botaction (resID,action) values(8,'エクスプローラー');
###### insert into botaction (resID,action) values(9,'ワード');
###### insert into botaction (resID,action) values(9,'Word');
###### insert into botaction (resID,action) values(9,'word');
###### insert into botaction (resID,action) values(10,'エクセル');
###### insert into botaction (resID,action) values(10,'Excel');
###### insert into botaction (resID,action) values(11,'パワーポイント');
###### insert into botaction (resID,action) values(11,'PowerPoint');
###### insert into botaction (resID,action) values(12,'電卓');
###### insert into botaction (resID,action) values(12,'でんたく');
###### insert into botaction (resID,action) values(12,'計算');
###### insert into botaction (resID,action) values(12,'計算機');
###### insert into botaction (resID,action) values(12,'calc');
###### insert into botaction (resID,action) values(12,'calculator');
###### insert into botaction (resID,action) values(13,'リマインダ');
###### insert into botaction (resID,action) values(13,'リマインダー');
###### insert into botaction (resID,action) values(13,'リマインド');
###### insert into botaction (resID,action) values(13,'remind');
###### insert into botaction (resID,action) values(13,'reminder');
###### insert into botaction (resID,action) values(13,'to do');
###### insert into botaction (resID,action) values(13,'to-do');  

###### insert into botresponse(id,response) values(1,'good morning !');
###### insert into botresponse(id,response) values(2,'hello !');
###### insert into botresponse(id,response) values(3,'good evening !');
###### insert into botresponse(id,response) values(4,'ログアウトしますか？');
###### insert into botresponse(id,response) values(5,'I\'m fine thank you !');
###### insert into botresponse(id,response) values(6,'メモ帳を起動しますか？');
###### insert into botresponse(id,response) values(7,'chromeを起動しますか？');
###### insert into botresponse(id,response) values(8,'エクスプローラを起動しますか？');
###### insert into botresponse(id,response) values(9,'Wordを起動しますか？');
###### insert into botresponse(id,response) values(10,'Excelを起動しますか？');
###### insert into botresponse(id,response) values(11,'PowerPointを起動しますか？');
###### insert into botresponse(id,response) values(12,'電卓を起動しますか？');
###### insert into botresponse(id,response) values(13,'reminderを起動しますか？');  

###### insert into pathlist(id,path) values(4,'/Logout');
###### insert into pathlist(id,path) values(6,'C:\\Windows\\System32\\notepad.exe');
###### insert into pathlist(id,path) values(7,'c:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe');
###### insert into pathlist(id,path) values(8,'C:\\Windows\\explorer.exe');
###### insert into pathlist(id,path) values(9,'c:\\Program Files\\Microsoft Office\\Office16\\WINWORD.EXE');
###### insert into pathlist(id,path) values(10,'c:\\Program Files\\Microsoft Office\\Office16\\EXCEL.EXE');
###### insert into pathlist(id,path) values(11,'c:\\Program Files\\Microsoft Office\\Office16\\POWERPNT.EXE');
###### insert into pathlist(id,path) values(12,'C:\\Windows\\System32\\calc.exe');
###### insert into pathlist(id,path) values(13,'/Reminder');
