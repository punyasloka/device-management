package com.device.management.service;

import com.device.management.exception.ResourceNotFoundException;
import com.device.management.model.Device;
import com.device.management.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {


    @Autowired
    DeviceRepository deviceRepository;

    @Override
    public Device addDevice(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public Device updateDevice(Device device, boolean availability) {
        Optional<Device> availableDevice = deviceRepository.findById(device.getId());
        if (availableDevice.isPresent()) {
            Device deviceUpdate = availableDevice.get();
            deviceUpdate.setAvailability(availability);
            deviceRepository.save(device);
            return deviceUpdate;
        }
        throw new ResourceNotFoundException("Record not found with id :" + device.getId());
    }

    @Override
    public List<Device> getAllDevice() {
        List<Device> allDeviceList = new ArrayList<>();
        deviceRepository.findAll().iterator().forEachRemaining(allDeviceList :: add);
        return allDeviceList;
    }

    @Override
    public Device getDeviceById(long id) {
        Optional<Device> product = deviceRepository.findById(id);

        if (product.isPresent()) {
            return product.get();
        }
        throw new ResourceNotFoundException("Can't find the product :" + id);
    }

    @Override
    public void deleteDevice(long id) {
        Optional<Device> product = deviceRepository.findById(id);

        if (product.isPresent()) {
            deviceRepository.delete(product.get());
        }
        throw new ResourceNotFoundException("Unable to delete the product with id :" +id);
    }
}
