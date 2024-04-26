package com.example.spring_11200.services;

import com.example.spring_11200.dto.ServiceDto;
import com.example.spring_11200.dto.ServiceForm;
import com.example.spring_11200.models.Service;
import com.example.spring_11200.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.spring_11200.dto.ServiceDto.from;


@Component
public class ServiceServiceImpl implements ServiceService{
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public ServiceDto addService(ServiceForm serviceForm) {
        Service service = Service.builder()
                .name(serviceForm.getName())
                .cost(serviceForm.getCost())
                .date(serviceForm.getDate())
                .build();
        serviceRepository.save(service);
        return ServiceDto.of(service);
    }

    @Override
    public Page<ServiceDto> getAllServices(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return serviceRepository.findAll(pageRequest).map(ServiceDto::of);
    }

    @Override
    public Page<ServiceDto> search(Integer page, Integer size, String query, String sortParameter, String directionParameter) {
        Sort.Direction direction = Sort.Direction.ASC;
        Sort sort = Sort.by(direction, "id");

        if (directionParameter != null) {
            direction = Sort.Direction.fromString(directionParameter);
        }

        if (sortParameter != null) {
            sort = Sort.by(direction, sortParameter);
        }

        if (query == null) {
            query = "empty";
        }

        if (size == null) {
            size = 3;
        }

        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Service> papersPage = serviceRepository.search(query, pageRequest);
        Page<ServiceDto> serviceDtoPage = papersPage.map(ServiceDto::of);
        return serviceDtoPage;
    }
}
