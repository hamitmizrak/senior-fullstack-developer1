package com.hamitmizrak.seniorfullstack1.utils.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

// spring.profiles.active=frontend
// spring.profiles.active=backend
// spring.profiles.active=fullstack


@Component// Spring nesnesi olmasını sağlamak için
@Profile("fullstack") //application.properties
public class FullStackProfile implements IChooiseProfile{
    @Override
    public String message(String name) {
        return FullStackProfile.class+" Profile: "+name;
    }
}
