package com.hamitmizrak.seniorfullstack1.utils.profiles;

import org.springframework.stereotype.Component;

// Spring nesnesi olmasını sağlamak için
@Component
public interface IChooiseProfile {

    public String message(String name);
}
