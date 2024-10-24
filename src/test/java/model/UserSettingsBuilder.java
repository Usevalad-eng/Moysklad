package model;

import com.github.javafaker.Faker;

public class UserSettingsBuilder {

    static Faker faker = new Faker();
    public static UserSettingsWithLombok get(){
        return UserSettingsWithLombok
                .builder()
                .name(faker.name().firstName())
                .patronymic(faker.name().firstName() + "ich")
                .lastname(faker.name().lastName())
                .phone("+37529" + faker.phoneNumber().cellPhone())
                .position("Position test")
                //.customer("Розничный покупатель")  //must work
                //.customer(0)
                .build();
    }
}
