package com.eakkas.springbootproject.service;

import com.eakkas.springbootproject.model.dto.request.CustomerAddRequest;
import com.eakkas.springbootproject.model.dto.request.CustomerUpdateRequest;
import com.eakkas.springbootproject.model.dto.response.CustomerResponse;
import com.eakkas.springbootproject.model.entity.Customer;

import java.util.List;

public interface CustomerService {

    /*
    * Interface class'ı. Tanımlayacagımız tüm metodları önce burada belirledik.
    * */

    CustomerResponse addCustomer(CustomerAddRequest request);
    CustomerResponse getCustomer(Long id);

    CustomerResponse updateCustomer(Long id, CustomerUpdateRequest request);

    String deleteCustomer(Long id);
    List<Customer> getCustomers();


}
