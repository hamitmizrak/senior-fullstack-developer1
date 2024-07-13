package com.hamitmizrak.seniorfullstack1.audit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Getter
@Setter

// Entity Super Class
@MappedSuperclass
// Auditing
@EntityListeners(AuditingEntityListener.class)
// json burada verdiklerimi takip etme
// Backtendten createdUser Objesini frontendte göndermesin
@JsonIgnoreProperties(value={"created_date","last_date"},allowGetters = true)
abstract public class AuditingAwareBaseEntity  implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID=1L;

    // AUDITING
    // Kim Ekledi
    //@JsonIgnore // Backtendten createdUser Objesini frontendte göndermesin
    @CreatedBy
    @Column(name="created_user")
    protected String createdUser;

    // Kim Ne Zaman Ekledi
    //@JsonIgnore // Backtendten createdUser Objesini frontendte göndermesin
    @CreatedDate
    @Column(name="created_date")
    protected Date createdDate;

    // Kim Güncelledi
    //@JsonIgnore // Backtendten createdUser Objesini frontendte göndermesin
    @LastModifiedBy
    @Column(name="last_user")
    protected String lastUser;


    // Kim Ne Zaman Güncelledi
    //@JsonIgnore // Backtendten createdUser Objesini frontendte göndermesin
    @LastModifiedDate
    @Column(name="last_date")
    protected Date lastDate;
}
