package com.google.devfest.model;

import androidx.annotation.Nullable;

/**
 * Created by herisulistiyanto on 2019-11-15.
 * KjokenKoddinger
 */

public class Customer {

    private String firstName;

    @Nullable
    private String lastName;

    public Customer(String firstName, @Nullable String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Nullable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@Nullable String lastName) {
        this.lastName = lastName;
    }
}
