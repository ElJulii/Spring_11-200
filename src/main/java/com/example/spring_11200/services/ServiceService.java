package com.example.spring_11200.services;

import com.example.spring_11200.dto.ServiceDto;
import com.example.spring_11200.dto.ServiceForm;
import org.springframework.data.domain.Page;

public interface ServiceService {
    ServiceDto addService(ServiceForm serviceForm);
    Page<ServiceDto> getAllServices(int service, int page);
    Page<ServiceDto> search (Integer page, Integer size, String query, String sortParameter, String direction);
}
