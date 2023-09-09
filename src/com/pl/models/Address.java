package com.pl.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Address {
    private Long lat;
    private Long lon;
    private String address;
    private String city;
}
