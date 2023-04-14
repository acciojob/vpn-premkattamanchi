package com.driver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;

    public Admin() {
    }
    @OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ServiceProvider> serviceProviderList=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<ServiceProvider> getServiceProviders() {
        return serviceProviderList;
    }

    public void setServiceProviders(List<ServiceProvider> serviceProvidersList) {
        this.serviceProviderList = serviceProvidersList;
    }
}
