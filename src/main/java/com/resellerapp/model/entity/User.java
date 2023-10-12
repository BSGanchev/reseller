package com.resellerapp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
    @Column(unique = true, nullable = false)
    @Size(min = 3, max = 20)
    private String username;
    @NotNull
    private String password;
    @Column(unique = true, nullable = false)
    @Email
    private String email;
    @OneToMany(mappedBy = "createdBy")
    private Set<Offer> offers;
    @OneToMany(mappedBy = "boughtBy")
    private Set<Offer> bought;

    public User() {
        this.offers = new HashSet<>();
        this.bought = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    public Set<Offer> getBought() {
        return bought;
    }

    public void setBought(Set<Offer> bought) {
        this.bought = bought;
    }
}
