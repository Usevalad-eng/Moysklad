package model;

import com.github.javafaker.Faker;

public class AddGoodBuilder {
    static Faker faker = new Faker();
    public static AddGood get(){
        return AddGood
                .builder()
                //.description("Description")
                .article("Article")
                .code(faker.code().asin())
                .build();
    }
}