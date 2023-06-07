package com.factoriaf5.pruebatecnica.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.factoriaf5.pruebatecnica.models.Role;
import com.factoriaf5.pruebatecnica.services.RoleService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = RoleController.class)
public class RoleControllerTest {
    
    @Autowired
    MockMvc mockMvc;

    @MockBean
    RoleService service;

    @Autowired
    ObjectMapper mapper;

    @Test
    @WithMockUser("roleTest")
    public void testRetrieveAllRoles() throws Exception {

        List<Role> roles = new ArrayList<Role>();
        Role role1 = new Role();
        Role role2 = new Role();

        roles.add(role1);
        roles.add(role2);

        when(service.getAll()).thenReturn(roles);
        MockHttpServletResponse response = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/roles"))
        .andExpect(status().isOk())
        .andReturn()
        .getResponse();

        System.out.println(response.getContentAsString());

        assertEquals(response.getStatus(), 200);

        assertEquals(response.getContentAsString(), mapper.writeValueAsString(roles));

}
}