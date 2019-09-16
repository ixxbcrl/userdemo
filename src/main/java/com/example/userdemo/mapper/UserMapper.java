package com.example.userdemo.mapper;

import com.example.userdemo.dto.AddressDTO;
import com.example.userdemo.dto.CompanyDTO;
import com.example.userdemo.dto.UserListRspDTO;
import com.example.userdemo.model.Address;
import com.example.userdemo.model.Company;
import com.example.userdemo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userDTOToEntity(UserListRspDTO dto);

    @Mappings({
            @Mapping(target = "latitude", source = "dto.geoDTO.lat"),
            @Mapping(target = "longitude", source = "dto.geoDTO.lng")
    })
    Address addressDTOToEntity(AddressDTO dto);

    Company companyDTOToEntoty(CompanyDTO dto);
}
