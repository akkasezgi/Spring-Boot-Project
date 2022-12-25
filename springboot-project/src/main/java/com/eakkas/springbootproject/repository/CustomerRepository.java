package com.eakkas.springbootproject.repository;

import com.eakkas.springbootproject.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}


/*
* Bu class CRUD işlemleri için Jpa'dan kalıtım alıyor. Gerekli tüm metodları kalıtımla cekiyoruz.
* */