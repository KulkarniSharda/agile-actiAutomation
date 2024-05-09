package com.actiautomation;

public class Verna {
    public static void main(String arg) {
        Honda honda=new Honda() {
            //anonymous class area
            public void engine(String cubicpower){
                System.out.println(cubicpower + "cc engine");
            }
            public void fuel(String type){
                System.out.println(type + "type engine");
            }

        };
        honda.fuel("Diesel");
        honda.engine("1200");


    }
}

