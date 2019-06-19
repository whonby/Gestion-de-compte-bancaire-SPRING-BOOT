package com.whonby.banque.security;

import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Deprecated
public class Md5PasswordEncoder extends MessageDigestPasswordEncoder {

	public Md5PasswordEncoder(String algorithm) {
		super(algorithm);
		// TODO Auto-generated constructor stub
	}


}
