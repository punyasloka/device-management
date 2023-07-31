DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS device;
DROP TABLE IF EXISTS booking;

CREATE TABLE employee (
  id BIGINT NOT NULL,
   first_name VARCHAR(255),
   last_name VARCHAR(255),
   email_id VARCHAR(255),
   CONSTRAINT pk_employee PRIMARY KEY (id)
);
CREATE TABLE device (
  id BIGINT NOT NULL,
   name VARCHAR(255),
   description VARCHAR(255),
   available BOOLEAN NOT NULL,
   CONSTRAINT pk_device PRIMARY KEY (id)
);
CREATE TABLE booking (
  id BIGINT AUTO_INCREMENT NOT NULL,
   device_id BIGINT,
   employee_id BIGINT,
   booking_date VARCHAR(255),
   return_date VARCHAR(255),
   CONSTRAINT pk_booking PRIMARY KEY (id)
);

ALTER TABLE booking ADD CONSTRAINT FK_BOOKING_ON_DEVICE FOREIGN KEY (device_id) REFERENCES device (id);

ALTER TABLE booking ADD CONSTRAINT FK_BOOKING_ON_EMPLOYEE FOREIGN KEY (employee_id) REFERENCES employee (id);