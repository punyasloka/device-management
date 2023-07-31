package com.device.management.controller;

import com.device.management.service.DeviceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DeviceControllerTest {

    @Mock
    private DeviceServiceImpl deviceService;

    @InjectMocks
    private DeviceController deviceController;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllDevice() {
    }

    @Test
    void getAllEmployee() {
    }

    @Test
    void bookDevice() {
    }

    @Test
    void returnDevice() {
    }

    @Test
    void getAllBooking() {
    }
}