package com.device.management.service;

import com.device.management.model.Booking;

import java.util.List;

public interface BookingService {
    Booking bookDevice(long deviceId, long userId);
    Booking returnDevice(long id, long userId);
    List<Booking> getAllBooking();
}
