package com.driver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String originalIP;
    private String maskedIP;
    private boolean connected;
    public User() {
    }

    @ManyToMany
    @JoinColumn
    private List<ServiceProvider> serviceProviderList=new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Connection> connectionList=new ArrayList<>();

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Country originalCountry;

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

    public String getOriginalIP() {
        return originalIP;
    }

    public void setOriginalIP(String originalIP) {
        this.originalIP = originalIP;
    }

    public String getMaskedIP() {
        return maskedIP;
    }

    public void setMaskedIP(String maskedIP) {
        this.maskedIP = maskedIP;
    }

    public boolean getConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public List<ServiceProvider> getServiceProviders() {
        return serviceProviderList;
    }

    public void setServiceProviders(List<ServiceProvider> serviceProviderList) {
        this.serviceProviderList = serviceProviderList;
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<Connection> connectionList) {
        this.connectionList = connectionList;
    }

    public Country getOriginalCountry() {
        return originalCountry;
    }

    public void setOriginalCountry(Country country) {
        this.originalCountry = originalCountry;
    }
}
