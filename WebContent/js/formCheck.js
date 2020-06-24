/**
 * 入力フォームのチェック
 */

//userID, pass
function checkIndex() {
	var flag = 0;    // 初期値 0 の時は true が入る
	if(document.form.userID.value == ""){
    	flag = 1;
    }
    else if(document.form.pass.value == ""){
    	flag = 1;
    }

	if(flag){
    	window.alert('必須項目に未入力があります');     // 入力漏れがあれば警告ダイアログを表示
    	return false; // 送信を中止
    }
    else{
    	 return true; // 送信を実行
    }

} //checkIndex()


//chat
function checkFriendChat() {
	var flag = 0;    // 初期値 0 の時は true が入る
	if(document.form.chat.value == ""){
        flag = 1;
    }
	 if(flag){
    	window.alert('必須項目に未入力があります');     // 入力漏れがあれば警告ダイアログを表示
    	return false; // 送信を中止
    }
    else{
    	 return true; // 送信を実行
    }
} //checkFriendChat()


//friendID, friendBotName
function checkFriendSearch() {
	var flag = 0;    // 初期値 0 の時は true が入る
	if(document.form.friendID.value == ""){
    	flag = 1;
    }
    else if(document.form.friendBotName.value == ""){
    	flag = 1;
    }
	 //判定し結果を返す
    if(flag){
    	window.alert('必須項目に未入力があります');     // 入力漏れがあれば警告ダイアログを表示
    	return false; // 送信を中止
    }
    else{
    	 return true; // 送信を実行
    }
} //checkFriendSearch()


//command
function checkMain() {
	var flag = 0;    // 初期値 0 の時は true が入る
	if(document.form.command.value == ""){
        flag = 1;
    }
	//判定し結果を返す
    if(flag){
    	window.alert('必須項目に未入力があります');     // 入力漏れがあれば警告ダイアログを表示
    	return false; // 送信を中止
    }
    else{
    	 return true; // 送信を実行
    }
} //checkMain()


//userID, pass, name, mail, botName
function checkRegister() {
	var flag = 0;    // 初期値 0 の時は true が入る
	/*
	var flagMail = 0; // 初期値 0 の時は true が入る
	var flagUserID_6 = 0; // 初期値 0 の時は true が入る
	var flagUserID = 0; // 初期値 0 の時は true が入る
	*/

	/*
	//ユーザIDチェック(6文字かどうかの判定)
    var text = document.form.userID.value;
    var n = text.length;
	if(!(n == 6)){
		flagUserID_6 = 1;
	}
	*/

	/*
	//ユーザIDチェック(半角英数字かどうかの判定)
	if(document.form.userID.value.match(/^[0-9A-Za-z]+$/)){
		flagUserID = 1;
	}
	*/

	/*
	//メールチェック
	if(!document.form.mail.value.match(/.+@.+\..+/)){
		flagMail = 1;
    }
    */

	if(document.form.userID.value == ""){
    	flag = 1;
    }
    else if(document.form.pass.value == ""){
    	flag = 1;
    }
    else if(document.form.name.value == ""){
        flag = 1;
    }
    else if(document.form.mail.value == ""){
        flag = 1;
    }
    else if(document.form.botName.value == ""){
        flag = 1;
    }

	//判定し結果を返す
	if(flag){
    	window.alert('必須項目に未入力があります');     // 入力漏れがあれば警告ダイアログを表示
    	return false; // 送信を中止
    }
    else{
    	 return true; // 送信を実行
    }

	/*
	//ユーザID判定(6文字かどうかの判定)
	if(flagUserID_6){
		window.alert('userIDは必ず6文字です');
		return false; // 送信を中止
    }

	//ユーザID判定(半角英数字かどうかの判定)
	if(flagUserID){
		window.alert('userIDは必ず半角英数です');
	    return false; // 送信を中止
	}

	//メール判定
	if(flagMail){
		window.alert('メールアドレスが正しくありません');
		// メールアドレス以外が入力された場合は警告ダイアログを表示
		return false; // 送信を中止
    }
    */

} //checkRegister()



function checkReminder() {
	var flag = 0;    // 初期値 0 の時は true が入る

	if(document.form.remind.value == "") {
    	flag = 1;
    }
    else if(document.form.category.value == "") {
    	flag = 1;
    }

	if(flag){
    	window.alert('必須項目に未入力があります');     // 入力漏れがあれば警告ダイアログを表示
    	return false; // 送信を中止
    }
    else{
    	 return true; // 送信を実行
    }
} //checkReminder()


//category
function checkReminderSort() {
	var flag = 0;    // 初期値 0 の時は true が入る

    if(document.form.category.value == "") {
    	flag = 1;
    }

	if(flag){
    	window.alert('必須項目に未入力があります');     // 入力漏れがあれば警告ダイアログを表示
    	return false; // 送信を中止
    }
    else{
    	 return true; // 送信を実行
    }
} //checkReminderSort()


    /*
    //年齢項目に0~9以外の文字が入っているかのチェック
    var flagNum = 0;

    if(document.form.age.value.match(/[^0-9]+/)) {
     flagNum = 1;
    }

    if(flagNum){
     window.alert('数字以外が入力されています'); // 数字以外が入力された場合は警告ダイアログを表示
     return false; // 送信を中止
    }
    else{
     return true; // 送信を実行
    }
    */

/**
 *
 */