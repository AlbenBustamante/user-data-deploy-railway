package com.alnicode.user_data.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.alnicode.user_data.constants.DateTimeUtil;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "register_at")
    @DateTimeFormat(iso = ISO.DATE_TIME, pattern = DateTimeUtil.DATE_TIME_FORMAT)
    private LocalDateTime registerAt;

    @Column(nullable = false)
    private String password;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "address_id")
    public Address address;

    @PrePersist
    public void setRegisterDate() {
        if (registerAt == null) {
            registerAt = LocalDateTime.now();
        }
    }

}
