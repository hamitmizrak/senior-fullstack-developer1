package com.hamitmizrak.seniorfullstack1.audit;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Getter
@Setter

abstract public class AuditingAwareBaseDto implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID=1L;

    // AUDITING
    // Kim Ekledi
    //@JsonIgnore // Backtendten createdUser Objesini frontendte göndermesin
    protected String createdUser;

    // Kim Ne Zaman Ekledi
    //@JsonIgnore // Backtendten createdUser Objesini frontendte göndermesin
    protected Date createdDate;

    // Kim Güncelledi
    //@JsonIgnore // Backtendten createdUser Objesini frontendte göndermesin
    protected String lastUser;


    // Kim Ne Zaman Güncelledi
    //@JsonIgnore // Backtendten createdUser Objesini frontendte göndermesin
    protected Date lastDate;
}
