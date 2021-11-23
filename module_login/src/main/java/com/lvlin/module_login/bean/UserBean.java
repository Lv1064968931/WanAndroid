package com.lvlin.module_login.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class UserBean implements Parcelable {

    /**
     *  "admin": false,
     *  "chapterTops": [],
     *  "coinCount": 21,
     *  "collectIds": [],
     *  "email": "",
     *  "icon": "",
     *  "id": 117813,
     *  "nickname": "zhaojingwu",
     *  "password": "",
     *  "publicName": "zhaojingwu",
     *  "token": "",
     *  "type": 0,
     *  "username": "zhaojingwu"
     * **/

    private String email;
    private String icon;
    private String id;
    private String password;
    private String token;
    private String type;
    private String username;
    private List<?> chapterTops;
    private List<Integer> collectIds;

    private String coinCount;

    public UserBean() {

    }

    public UserBean(Parcel in) {
        email = in.readString();
        icon = in.readString();
        id = in.readString();
        password = in.readString();
        token = in.readString();
        type = in.readString();
        username = in.readString();
        coinCount = in.readString();
    }

    public static final Creator<UserBean>CREATOR = new Creator<UserBean>() {
        @Override
        public UserBean createFromParcel(Parcel source) {
            return new UserBean(source);
        }

        @Override
        public UserBean[] newArray(int size) {
            return new UserBean[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<?> getChapterTops() {
        return chapterTops;
    }

    public void setChapterTops(List<?> chapterTops) {
        this.chapterTops = chapterTops;
    }

    public List<Integer> getCollectIds() {
        return collectIds;
    }

    public void setCollectIds(List<Integer> collectIds) {
        this.collectIds = collectIds;
    }

    public String getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(String coinCount) {
        this.coinCount = coinCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(icon);
        dest.writeString(id);
        dest.writeString(password);
        dest.writeString(token);
        dest.writeString(type);
        dest.writeString(username);
        dest.writeString(coinCount);
    }
}
