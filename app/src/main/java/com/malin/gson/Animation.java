package com.malin.gson;

public class Animation {


    /**
     [
     
         {
                 "id": 100,
                 "body": "It is my post1",
                 "number": 0.13,
                 "created_at": "2014-05-20 19:12:38"
         },
         {
                 "id": 101,
                 "body": "It is my post2",
                 "number": 0.14,
                 "created_at": "2014-05-22 19:12:38"
         }
     ]
     */

    public int id;
    public String body;
    public double number;
    public String created_at;

    @Override
    public String toString() {
        return "Animation{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", number=" + number +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
