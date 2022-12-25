package com.eakkas.springbootproject.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerUpdateRequest {

    /*
    * Bu class içinde update ettiğimiz istekler için tanımlı fieldlar güncellenecek.
    * */


    private String phone;
    private String address;

}
