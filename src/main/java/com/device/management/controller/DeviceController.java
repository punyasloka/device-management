package com.device.management.controller;

import com.device.management.dto.DeviceBooking;
import com.device.management.model.Booking;
import com.device.management.model.Device;
import com.device.management.model.Employee;
import com.device.management.service.BookingServiceImpl;
import com.device.management.service.DeviceServiceImpl;
import com.device.management.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.List;

@RestController
public class DeviceController {

    @Autowired
    private DeviceServiceImpl deviceService;

    @Autowired
    private BookingServiceImpl bookingService;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/devices")
    public ResponseEntity<List<Device>> getAllDevice() {
        return ResponseEntity.ok().body(deviceService.getAllDevice());
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.ok().body(employeeService.getAllEmployee());
    }

    @PostMapping("/book")
    public ResponseEntity<Booking> bookDevice(@RequestBody DeviceBooking deviceBooking) {
        return ResponseEntity.ok().body(bookingService.bookDevice(deviceBooking.getDeviceId(), deviceBooking.getUserId()));
    }

    @PostMapping("/return")
    public ResponseEntity<Booking> returnDevice(@RequestBody DeviceBooking deviceBooking) {
        return ResponseEntity.ok().body(bookingService.returnDevice(deviceBooking.getDeviceId(), deviceBooking.getUserId()));
    }

    @GetMapping("/booking")
    public ResponseEntity<List<Booking>> getAllBooking() {
        return ResponseEntity.ok().body(bookingService.getAllBooking());
    }

}
