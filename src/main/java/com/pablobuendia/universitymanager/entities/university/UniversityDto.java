package com.pablobuendia.universitymanager.entities.university;

import com.pablobuendia.universitymanager.entities.address.AddressDto;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UniversityDto {

    private String id;

    @NotNull
    private String name;

    private List<AddressDto> addressList;
}
