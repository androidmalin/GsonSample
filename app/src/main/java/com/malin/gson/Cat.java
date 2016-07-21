package com.malin.gson;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Cat {

    /**
    {
            "id": 100,
            "body": "It is my post",
            "number": 0.13,
            "created_at": "2014-05-22 19:12:38"
    }
     **/


    public String id;
    public String body;
    public double number;
    @SerializedName("created_at")
    public Date createdAt;

    @Override
    public String toString() {
        return "Cat{" +
                "id='" + id + '\'' +
                ", body='" + body + '\'' +
                ", number=" + number +
                ", createdAt=" + createdAt +
                '}';
    }
}
