package com.ese.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.email.demo.model.emailll;

import jakarta.mail.internet.MimeMessage;

@Service
public class emailservice {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendMail(emailll em) {
		try {
			MimeMessage message=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message);
			helper.setFrom("hanikareddy05@gmail.com");
			helper.setTo(em.getTO());
			helper.setSubject("REGISTRATION-ESE"); 
            helper.setText("You have successfully registered.Thank you for joining us.We will get back to you soon"); 
			javaMailSender.send(message);
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
	}

}
