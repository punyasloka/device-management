package com.device.management.service;

import com.device.management.model.Device;

import java.util.List;

public interface DeviceService {

    Device addDevice(Device device);
    Device updateDevice(Device device, boolean availability);
    List<Device> getAllDevice();
    Device getDeviceById(long id);
    void deleteDevice(long id);
}
