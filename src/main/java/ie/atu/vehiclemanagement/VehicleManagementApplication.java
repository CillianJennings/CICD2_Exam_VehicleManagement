package ie.atu.vehiclemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class VehicleManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicleManagementApplication.class, args);
    }

}
