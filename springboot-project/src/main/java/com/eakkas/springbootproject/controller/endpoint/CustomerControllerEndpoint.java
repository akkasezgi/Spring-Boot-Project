package com.eakkas.springbootproject.controller.endpoint;

public class CustomerControllerEndpoint {

    //postman sorguları için bu class içinde endpointler yazıldı.

    public static final String PATH = "customer";
    public static final String ADD_CUSTOMER = PATH + "/add";
    public static final String GET_CUSTOMER = PATH + "/get/{id}";
    public static final String UPDATE_CUSTOMER = PATH + "/update/{id}";
    public static final String DELETE_CUSTOMER = PATH + "/delete/{id}";
    public static final String GET_ALL_CUSTOMERS = PATH + "/get/customers";
}
