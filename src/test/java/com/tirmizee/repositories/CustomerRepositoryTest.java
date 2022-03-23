package com.tirmizee.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import com.tirmizee.entities.Customer;
import com.tirmizee.utils.AESUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired CustomerRepository customerRepository;

    @Test
    public void shouldDecryptedWhenRetrieving() {

        Customer customer = customerRepository.findById(2L).get();

        System.out.println("cid : " + customer.getCid());
        System.out.println("accountNo : " + customer.getAccountNo());

        assertThat(customer).isNotNull();
        assertThat(customer.getCid()).isEqualTo("1900000000000");
        assertThat(customer.getAccountNo()).isEqualTo("008222222");

    }

}
