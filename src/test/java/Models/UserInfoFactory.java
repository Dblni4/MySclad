package Models;

import com.github.javafaker.Faker;

public class UserInfoFactory {

    static Faker faker = new Faker();


    public static UserInfo get() {
        return UserInfo.builder()
                .name(faker.name().firstName())
                .secondName(faker.music().instrument())
                .surName(faker.artist().name())
                .phone(faker.phoneNumber().phoneNumber())
                .post(faker.pokemon().name())
                .build();
    }
}
