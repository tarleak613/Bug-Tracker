package com.ayush.thunderclient.bug_tracker.DTO;

public class LoginRequest {
    private String email;
    private String password; // plain password for login request

    // getters and setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}