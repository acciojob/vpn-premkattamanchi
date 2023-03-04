package com.driver.services.impl;

import com.driver.model.Country;
import com.driver.model.ServiceProvider;
import com.driver.model.User;
import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.repository.UserRepository;
import com.driver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository3;
    @Autowired
    ServiceProviderRepository serviceProviderRepository3;
    @Autowired
    CountryRepository countryRepository3;

    @Override
    public User register(String username, String password, String countryName) throws Exception{
        List<String> list= Arrays.asList(new String[]{"AUS","aus","IND","ind","USA","usa","CHI","chi","jpn","JPN"});
        if(!list.contains(countryName))
            throw new Exception("Conutry not found");
        Country country=countryRepository3.findByCountryName(countryName);
       User user=new User();
       user.setUsername(username);
       user.setPassword(password);
       user.setConnected(false);
       user.setMaskedIP(null);
       user.setCountry(country);
       user.getServiceProviderList().add(country.getServiceProvider());
       user=userRepository3.save(user);
       String originalIp=country.getCode()+"."+user.getId();
       user.setOriginalIP(originalIp);
       user=userRepository3.save(user);
       return user;

    }

    @Override
    public User subscribe(Integer userId, Integer serviceProviderId) {
        User user=userRepository3.findById(userId).get();
        ServiceProvider serviceProvider=serviceProviderRepository3.findById(serviceProviderId).get();
        user.getServiceProviderList().add(serviceProvider);
        serviceProvider.getUsers().add(user);
        serviceProviderRepository3.save(serviceProvider);
        return user;
    }
}
