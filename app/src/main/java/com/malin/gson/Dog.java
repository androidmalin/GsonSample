package com.malin.gson;

public class Dog {

    /**
     {
             "id": 100,
             "body": "It is my post",
             "number": 0.13,
             "created_at": "2014-05-22 19:12:38",
             "foo2": {
                         "id": 200,
                         "name": "haha"
             }
     }
     **/


    public String id;
    public String body;
    public double number;
    public String created_at;
    public FOO2 foo2;

    public class FOO2{
        public String id;
        public String name;

        @Override
        public String toString() {
            return "FOO2{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id='" + id + '\'' +
                ", body='" + body + '\'' +
                ", number=" + number +
                ", created_at='" + created_at + '\'' +
                ", foo2=" + foo2 +
                '}';
    }
}
