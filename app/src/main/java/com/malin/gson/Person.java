package com.malin.gson;

public class Person {

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
    public String created_at;

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", body='" + body + '\'' +
                ", number=" + number +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
