package com.pablobuendia.universitymanager.university;

import com.pablobuendia.universitymanager.address.AddressDto;
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
