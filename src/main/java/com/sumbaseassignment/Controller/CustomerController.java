package com.sumbaseassignment.Controller;

import com.sumbaseassignment.DTO.ResponseDTO.GeneralMessageDTO;
import com.sumbaseassignment.Exception.CustomerAlreadyExistException;
import com.sumbaseassignment.Exception.CustomerDoesNotExistException;
import com.sumbaseassignment.Model.Customer;
import com.sumbaseassignment.Services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/home")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerServices customerServices;

    // Endpoint for creating a new customer
    @PostMapping("/api/create")
    public ResponseEntity < Customer > createCustomer(@RequestBody Customer customer) throws Exception {
        try {
            Customer customerDetails = customerServices.addCustomer(customer);
            // return ResponseEntity.ok(customerDetails);
            return new ResponseEntity < > (customerDetails, HttpStatus.CREATED);
        }
        // catch (Exception e) {
        //     return ResponseEntity.status(500).build();
        // }
        catch (CustomerAlreadyExistException customerAlreadyExistException) {
            return new ResponseEntity(new GeneralMessageDTO(customerAlreadyExistException.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // Endpoint for retrieving customer details by ID
    @GetMapping("/api/CustomerById/{customerId}")
    public ResponseEntity findById(@PathVariable int customerId) throws Exception {
        try {
            // return ResponseEntity.ok(customerServices.getCustomerById(customerId));
            return new ResponseEntity < > (customerServices.getCustomerById(customerId), HttpStatus.OK);
        }
        // catch (Exception e) {
        //     return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        // }
        catch (CustomerDoesNotExistException customerDoesNotExistException) {
            return new ResponseEntity(new GeneralMessageDTO(customerDoesNotExistException.getMessage()), HttpStatus.NOT_FOUND);
        }
    }


    // Endpoint for retrieving a paginated list of customers
    @GetMapping("/api/getlist")
    public ResponseEntity < Page < Customer >> getList(@RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) throws Exception {
        try {
            Page < Customer > customerPage = customerServices.getAllCustomers(PageRequest.of(page, size));
            // return ResponseEntity.ok(customerPage);/
            return new ResponseEntity < > (customerPage, HttpStatus.OK);
        } catch (Exception e) {
            // throw new Exception("Internal Server Issue");
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    // Endpoint for deleting a customer by ID
    @DeleteMapping("/api/deleteById/{customerId}")
    public ResponseEntity deleteById(@PathVariable int customerId) throws Exception {
        try {
            customerServices.deleteCustomerById(customerId);
            // return ResponseEntity.ok("Customer deleted from DB");
            return new ResponseEntity(new GeneralMessageDTO("Customer deleted successfully from the database"), HttpStatus.OK);
        } catch (CustomerDoesNotExistException customerDoesNotExistException) {
            return new ResponseEntity(new GeneralMessageDTO(customerDoesNotExistException.getMessage()), HttpStatus.NOT_FOUND);
        }
    }


    // Endpoint for updating customer details by ID
    @PutMapping("/api/updateDetails/{id}")
    public ResponseEntity < Customer > updateCustomerDetails(@PathVariable int id, @RequestBody Customer updateCustomer) throws Exception {
        try {
            Customer updatedCustomer = customerServices.updateCustomerDetails(id, updateCustomer);
            return new ResponseEntity < > (updatedCustomer, HttpStatus.OK);
        } catch (CustomerDoesNotExistException customerDoesNotExistException) {
            return new ResponseEntity(new GeneralMessageDTO(customerDoesNotExistException.getMessage()), HttpStatus.NOT_FOUND);
        }
    }


    // Endpoint for searching customers by a searchTerm
    @GetMapping("/api/customers/search")
    public List < Customer > searchCustomers(@RequestParam String searchTerm) {
        return customerServices.searchCustomers(searchTerm);
    }


    @GetMapping("/api/customers/search/sunbase")
    public List < Customer > searchCustomers() {
        return customerServices.addDataCustomer();
    }









//    -----------------------------------------------

//    @PostMapping("/sync")
//    public ResponseEntity<String> syncCustomerList() {
//        customerServices.syncCustomerList();
//        return ResponseEntity.ok("Sync process initiated");
//    }


//    -----------------------------------------------

    // Endpoint for triggering customer data synchronization
//    @GetMapping("/sync")
//    public ResponseEntity<String>  syncCustomerList() {
//        try {
//            customerServices.syncCustomerList();
//            return ResponseEntity.ok("Sync process initiated");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error during synchronization: " + e.getMessage());
//        }
//
//    }







}
