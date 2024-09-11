package com.user.household.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationEntityDTO {

    private Integer id;
    private String brand;
    private String model;
    private String status;
}
