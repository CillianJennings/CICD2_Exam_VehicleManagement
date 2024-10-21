package ie.atu.vehiclemanagement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @NotBlank
    @Pattern(regexp = "\\d\\d\\D\\D\\D\\D", message = "Reg number must be 2 letters then 4 numbers")
    private String registrationNumber;
    @NotBlank(message = "Vehicle name cannot be blank")
    private String vehicleName;
    @NotBlank(message = "Vehicle type cannot be blank")
    private String vehicleType;
    @Positive(message = "Price must be greater than 0")
    private Long vehiclePrice;
    @Size(min = 1886, max = 2024, message = "Year must be between 1886 and current year")
    private int yearOfManufacture;
    @PositiveOrZero(message = "Mileage cannot be below 0")
    private int mileage;
}
