package ie.atu.vehiclemanagement;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    private final VehicleRep vehicleRep;
    public VehicleService(VehicleRep vehicleRep){
        this.vehicleRep = vehicleRep;
    }
    public List<Vehicle> getAllVehicles(){
        return vehicleRep.findAll();
    }
    public boolean findVehicleByReg(String registrationNumber){
        Optional<Vehicle> existingVehicle = vehicleRep.findById(registrationNumber);
        if(existingVehicle.isPresent()){
            return true;
            //return vehicleRep.findById(registrationNumber);
        }
        return false;
    }
    public void addVehicle(Vehicle vehicle){
        vehicleRep.save(vehicle);
    }
    public boolean editVehicle(String registrationNumber, Vehicle updatedVehicle){
        Optional<Vehicle> existingVehicle = vehicleRep.findById(registrationNumber);
        if(existingVehicle.isPresent()){
            Vehicle oldVehicle = existingVehicle.get();
            oldVehicle.setVehicleName(updatedVehicle.getVehicleName());
            oldVehicle.setVehiclePrice(updatedVehicle.getVehiclePrice());
            oldVehicle.setVehicleType(updatedVehicle.getVehicleType());
            oldVehicle.setMileage(updatedVehicle.getMileage());
            oldVehicle.setYearOfManufacture(updatedVehicle.getYearOfManufacture());
            vehicleRep.save(oldVehicle);
            return true;
        }
        return false;
    }
    public void deleteVehicle(String registrationNumber){
        vehicleRep.deleteById(registrationNumber);
    }
}
