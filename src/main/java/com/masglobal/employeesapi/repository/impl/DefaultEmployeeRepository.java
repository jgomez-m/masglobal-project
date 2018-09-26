package com.masglobal.employeesapi.repository.impl;

import com.masglobal.employeesapi.model.EmployeeDTO;
import com.masglobal.employeesapi.model.EmployeeResponse;
import com.masglobal.employeesapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public class DefaultEmployeeRepository implements EmployeeRepository {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<EmployeeResponse> findAll() {
        MappingJackson2HttpMessageConverter mapper = new MappingJackson2HttpMessageConverter();
        mapper.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
        restTemplate.setMessageConverters(Arrays.asList(mapper));
        EmployeeResponse[] response = restTemplate.getForObject(
        "http://masglobaltestapi.azurewebsites.net/api/employees", EmployeeResponse[].class);
        return Arrays.asList(response);
    }
}
