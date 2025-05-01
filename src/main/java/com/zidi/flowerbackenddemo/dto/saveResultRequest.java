package com.zidi.flowerbackenddemo.dto;


public class saveResultRequest {
    public String imageName;
    public String color;
    public String petals;
    public String smell;
    public String location;
    public String email;

    public ResultData result;
    public static class ResultData {
        public String name;
        public int confidence;
    }


}
