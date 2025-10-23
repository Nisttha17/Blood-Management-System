package com.example.bloodbank.Response;

public class ResponseBean {
    
    private String statusCode;
    private String message;
    private Object data;

    // Constructors
    public ResponseBean() {
    }

    public ResponseBean(String statusCode, String message, Object data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    // Getters and Setters
    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
