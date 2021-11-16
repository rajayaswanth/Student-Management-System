package com.sms.services;

import com.sms.dto.requests.Email;

public interface EmailService {
	
	public void sendEmail(Email mailModel, String fileName);

}
