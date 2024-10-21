package ie.atu.vehiclemanagement;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    private final VehicleService vehicleService;
    @Autowired
    public VehicleController(VehicleService vehicleService){
        this.vehicleService=vehicleService;
    }
    @GetMapping("/getVehicle")
    public List<Vehicle> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }
    @PostMapping("/addVehicle")
    public ResponseEntity<String> addVehicle(@Valid @RequestBody Vehicle newVehicle){
        vehicleService.addVehicle(newVehicle);
        return new ResponseEntity<>("Vehicle successfully added", HttpStatus.CREATED);
    }
    @PutMapping("/updateVehicle/{registrationNumber}")
    public ResponseEntity<String> updateVehicle(@PathVariable String registrationNumber, @RequestBody Vehicle updatedVehicle){
        boolean status = vehicleService.editVehicle(registrationNumber, updatedVehicle);
        if(status){
            return new ResponseEntity<>("Vehicle successfully updated", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Vehicle update failed", HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/deleteVehicle/{registrationNumber}")
    public ResponseEntity<String> deleteVehicle(@PathVariable String registrationNumber){
        vehicleService.deleteVehicle(registrationNumber);
        return new ResponseEntity<>("Vehicle successfully deleted", HttpStatus.CREATED);
    }
}
