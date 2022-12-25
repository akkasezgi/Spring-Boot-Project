package com.eakkas.springbootproject.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerAddRequest {

    /*
    * Bu class içindePostman istekleri için add dedigimizde tüm
    * tanımlı fieldlar body içerisinde tanımlanacak.
    * */


    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    private String phone;
    private String address;
    private String gender;

}
