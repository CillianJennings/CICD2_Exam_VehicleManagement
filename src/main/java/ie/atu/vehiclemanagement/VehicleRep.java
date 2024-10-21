package ie.atu.vehiclemanagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRep extends JpaRepository<Vehicle, String> {

}
