package com.device.management.service;

import com.device.management.exception.ResourceNotFoundException;
import com.device.management.model.Booking;
import com.device.management.model.Device;
import com.device.management.model.Employee;
import com.device.management.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    private DeviceServiceImpl deviceService;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private BookingRepository bookingRepository;


    private final String DATE_NA = "NA";

    @Override
    public Booking bookDevice(long deviceId, long userId) {
        Device device = deviceService.getDeviceById(deviceId);
        Employee employee = employeeService.getEmployeeById(userId);
        if (device.isAvailability()) {
            Booking booking = new Booking();
            booking.setDevice(device);
            booking.setEmployee(employee);
            booking.setReturnDate(DATE_NA);
            booking.setBookingDate(LocalDate.now().toString());
            bookingRepository.save(booking);
            deviceService.updateDevice(device, false);
            return booking;
        } else {
            throw new ResourceNotFoundException("Device Already booked");
        }
    }

    @Override
    public Booking returnDevice(long deviceId, long userId) {
        Device device = deviceService.getDeviceById(deviceId);
        Employee employee = employeeService.getEmployeeById(userId);
        if (!device.isAvailability()) {
            Booking booking = new Booking();
            booking.setDevice(device);
            booking.setEmployee(employee);
            booking.setReturnDate(LocalDate.now().toString());
            booking.setBookingDate(DATE_NA);
            bookingRepository.save(booking);
            deviceService.updateDevice(device, true);
            return booking;
        } else {
            throw new ResourceNotFoundException("Device not booked");
        }
    }

    @Override
    public List<Booking> getAllBooking() {
        List<Booking> bookingList = new ArrayList<>();
        bookingRepository.findAll().iterator().forEachRemaining(bookingList :: add);
        return bookingList;
    }


}
