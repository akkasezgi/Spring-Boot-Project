package com.eakkas.springbootproject.converter;

import com.eakkas.springbootproject.model.dto.request.CustomerAddRequest;
import com.eakkas.springbootproject.model.dto.response.CustomerResponse;
import com.eakkas.springbootproject.model.entity.Customer;
import com.eakkas.springbootproject.model.enums.Gender;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerConverter {


    //Request'ten istek alıp custemer a ceviriyor.
    public static Customer convertToCustomer(CustomerAddRequest request){

        if(request == null)
            return null;


        return Customer.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .address(request.getAddress())
                .gender(convertToGender(request.getGender()))
                .build();
    }


    //customer entity den aldıgı customeri response cevirecek
    public static CustomerResponse convertToResponse(Customer customer){

        if(customer == null)
            return null;

        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .address(customer.getAddress())
                .gender(customer.getGender().toString())
                .build();
    }

    // liste dönüyoruz. indexleri convertere yönlendirip convert edip listeye atıacak.
    public static List<CustomerResponse> convertToResponse(List<Customer> customers) {
        if (customers.isEmpty())
            return Collections.emptyList();

        return customers.stream()
                .map(CustomerConverter::convertToResponse)
                .collect(Collectors.toList());
    }

    //Gender enum class'ı string cevirdik. isteklerde string dönmesi için.
    private static Gender convertToGender(String gender) {
        if (gender == null)
            return null;

        switch (gender) {
            case "MALE":
                return Gender.MALE;
            case "FEMALE":
                return Gender.FEMALE;
            default:
                return null;
        }
    }
}


