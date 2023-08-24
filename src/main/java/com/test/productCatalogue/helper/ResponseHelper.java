package com.test.productCatalogue.helper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHelper {

    public static <T> ResponseEntity<ApiResponse<T>> success(T data){
        ApiResponse<T> apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "Success", data);
        return ResponseEntity.ok(apiResponse);
    }

    public static ResponseEntity<ApiResponse<Void>> success(){
        ApiResponse<Void> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setMessage("Success");
        return ResponseEntity.ok(apiResponse);
    }
public static ResponseEntity<ApiResponse<Void>> error(HttpStatus status, String message){
        ApiResponse<Void> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(status.value());
        apiResponse.setMessage(message);
        return ResponseEntity.status(status).body(apiResponse);
}

}
