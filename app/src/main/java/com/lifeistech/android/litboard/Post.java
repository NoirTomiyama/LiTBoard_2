package com.lifeistech.android.litboard;

public class Post {

    String userName;
    String message;


    //firebaseのための空のコンストラクタ
    public Post(){

    }

    //コンストラクタ
    public Post(String userName,String message){
        this.userName = userName;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
