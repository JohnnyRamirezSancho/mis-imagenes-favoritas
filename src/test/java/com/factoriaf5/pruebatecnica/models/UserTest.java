package com.factoriaf5.pruebatecnica.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserTest {

    User userEmpty = new User();
    User userFull = new User(null, "Prueba", "Primera", null);

    @Test
    void test_set_name_empty_user() {
        userEmpty.setUsername("Paco");
        assertEquals("Paco", userEmpty.getUsername());

    }

    @Test
    void test_modify_name_full_user() {
        userFull.setUsername("Paco");
        assertEquals("Paco", userFull.getUsername());
    }
}

