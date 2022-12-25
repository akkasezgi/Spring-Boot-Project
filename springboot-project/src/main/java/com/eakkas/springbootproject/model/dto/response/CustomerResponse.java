package com.eakkas.springbootproject.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {

    //  Tüm fieldler şart degil. Entity dışarı açmamak için response yazdım. ihtiyac olanları açmak
    //  gizli olanları saklamak için(dış dünyaya açtıgımız class)

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String gender;

}
