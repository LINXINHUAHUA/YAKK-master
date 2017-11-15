package com.example.bs535.yakk.content;

/**
 * Created by BS535 on 2017/11/15.
 */

public class Mall {
    private String name;
    private  int imageId;

    public Mall(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }

}
