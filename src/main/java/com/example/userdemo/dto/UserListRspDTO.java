package com.example.userdemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserListRspDTO {
    private Long id;
    private String name;
    private String username;
    private String email;
    @JsonProperty("address")
    private AddressDTO addressDTO;
    private String phone;
    private String website;
    @JsonProperty("company")
    private CompanyDTO companyDTO;
}
