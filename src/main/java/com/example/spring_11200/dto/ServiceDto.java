package com.example.spring_11200.dto;

import com.example.spring_11200.models.Service;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDto {
    private Long id;
    private String name;
    private String cost;
    private String date;

    public static ServiceDto of(Service service) {
        return ServiceDto.builder()
                .id(service.getId())
                .name(service.getName())
                .cost(service.getCost())
                .date(service.getDate())
                .build();
    }

    public static List<ServiceDto> from(List<Service> services) {
        return services.stream()
                .map(ServiceDto::of)
                .collect(Collectors.toList());
    }
}
