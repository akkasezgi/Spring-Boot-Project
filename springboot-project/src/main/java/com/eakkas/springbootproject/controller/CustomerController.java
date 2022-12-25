package com.eakkas.springbootproject.controller;

import com.eakkas.springbootproject.converter.CustomerConverter;
import com.eakkas.springbootproject.model.dto.request.CustomerAddRequest;
import com.eakkas.springbootproject.model.dto.request.CustomerUpdateRequest;
import com.eakkas.springbootproject.model.dto.response.CustomerResponse;
import com.eakkas.springbootproject.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.eakkas.springbootproject.controller.endpoint.CustomerControllerEndpoint.*;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class CustomerController {

    /*
    postman üzerinden çekilen istekler bu classa düşer.
    Gerekli endpointler package içinde tanımlandı
    Controller class'ı service ile iletişim sağlar.
    Gerekli tüm metodlar tanımlandı
     */


    private final CustomerService customerService;

    @PostMapping(ADD_CUSTOMER)
    public CustomerResponse addCustomer(@RequestBody @Valid CustomerAddRequest request){
        return customerService.addCustomer(request);
    }

    @GetMapping(GET_CUSTOMER)
    public CustomerResponse getCustomer(@PathVariable Long id){
        return customerService.getCustomer(id);
    }

    @PutMapping(UPDATE_CUSTOMER)
    public CustomerResponse updateCustomer(@PathVariable Long id,
                                           @RequestBody CustomerUpdateRequest request) {
        return customerService.updateCustomer(id, request);
    }

    @DeleteMapping(DELETE_CUSTOMER)
    public CustomerResponse deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return new CustomerResponse();
    }


    @GetMapping(GET_ALL_CUSTOMERS)
    public List<CustomerResponse> customerResponseList (){
       return CustomerConverter.convertToResponse(customerService.getCustomers());
    }

}
