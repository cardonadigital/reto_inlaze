package co.com.inlaze.utils;

import co.com.inlaze.models.UserModel;
import com.github.javafaker.Faker;

public class CreateUser {

    private static UserModel userModel;


    public static UserModel generateUser(){
        Faker faker = new Faker();
        userModel = new UserModel();
        userModel.setName(faker.name().fullName());
        userModel.setEmail(userModel.getName() + "@gmail.com");
        userModel.setPassword(faker.internet().password());
        return userModel;
    }


}
