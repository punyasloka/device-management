package com.device.management.repository;

import com.device.management.model.Booking;
import com.device.management.model.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {

    Booking findBookingByDevice(Device device);
}
