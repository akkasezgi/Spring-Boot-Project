package com.eakkas.springbootproject.service.impl;

import com.eakkas.springbootproject.converter.CustomerConverter;
import com.eakkas.springbootproject.exception.GlobalException;
import com.eakkas.springbootproject.model.dto.request.CustomerAddRequest;
import com.eakkas.springbootproject.model.dto.request.CustomerUpdateRequest;
import com.eakkas.springbootproject.model.dto.response.CustomerResponse;
import com.eakkas.springbootproject.model.entity.Customer;
import com.eakkas.springbootproject.repository.CustomerRepository;
import com.eakkas.springbootproject.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

    /*    Interface service class ı içinde belirtilen tüm metodlar burada override edildi.
          methodlar bu class içerisinde tanımlandı. Controller ile iletişim kuracak sınıf.
    * */


    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    //contructor cagırmamamak için anotation eklendi.
    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponse addCustomer(CustomerAddRequest request) {
        Customer customer = CustomerConverter.convertToCustomer(request);
         CustomerResponse response = CustomerConverter.convertToResponse(customerRepository.save(customer));
        return response ;
    }

    @Override
    public CustomerResponse getCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isEmpty()) {
            logger.error("customerId {} , kullanıcı bulunamadı." , id);
            throw new GlobalException("Kullanici bulunamadi", HttpStatus.NOT_FOUND);
        }

        logger.info("id {}, kullanıcısi listelendi.", id);
        return CustomerConverter.convertToResponse(customer.get());
    }

    @Override
    public CustomerResponse updateCustomer(Long id, CustomerUpdateRequest request) {
        Customer customer = getCustomerById(id);
        checkUpdate(request, customer);
        logger.info("id {} kullanicii güncellendi, Status {} ", id ,HttpStatus.OK);
        return CustomerConverter.convertToResponse(customerRepository.save(customer));
    }

    @Override
    public String deleteCustomer(Long id) {
        boolean isExist = customerRepository.existsById(id);
        if(isExist){
            customerRepository.deleteById(id);
        }else {
            throw new RuntimeException("Böyle bir kullanici yok.");
        }
        logger.info("id {} Silme islemi basarili", id);
        return "Silme islemi basarili";
    }

    @Override
    public List<Customer> getCustomers() {

        return customerRepository.findAll();
    }

    private void checkUpdate(CustomerUpdateRequest request, Customer customer) {
        if (request.getPhone() != null)
            customer.setPhone(request.getPhone());

        if(request.getAddress() != null)
            customer.setAddress(request.getAddress());

    }

    private Customer getCustomerById(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isEmpty()){
            logger.error("customerId {} , güncelleme başarısız." , id);
            throw new RuntimeException("Güncelleme başarisiz");
        }
        return customer.get();
    }
}
