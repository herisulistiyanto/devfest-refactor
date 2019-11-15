package com.google.devfest.repo;

import android.text.TextUtils;

import com.google.devfest.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by herisulistiyanto on 2019-11-15.
 * KjokenKoddinger
 */

public class CustomerRepo {

    private static CustomerRepo INSTANCE = null;
    private List<Customer> customers = null;

    public static CustomerRepo getInstance() {
        if (INSTANCE == null) {
            synchronized (CustomerRepo.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CustomerRepo();
                }
            }
        }
        return INSTANCE;
    }

    private CustomerRepo() {
        customers = new ArrayList<>();
        customers.add(new Customer("Heri", "Sulis"));
        customers.add(new Customer("Fikri", null));
        customers.add(new Customer("Didik", ""));
    }

    public String getFormattedName() {
        Random random = new Random();
        Customer customer = customers.get(random.nextInt(customers.size()));
        final String firstName = customer.getFirstName();
        final String lastName = (TextUtils.isEmpty(customer.getLastName())) ? "Unknown" : customer.getLastName();
        return firstName + " " + lastName;
    }
}
