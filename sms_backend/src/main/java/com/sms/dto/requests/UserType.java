package com.sms.dto.requests;

public enum UserType {
	
	STUDENT("Student"),
    TEACHER("Teacher"),
    PARENT("Parent");

    public final String userType;

    private UserType(String userType) {
        this.userType = userType;
    }
    
}
