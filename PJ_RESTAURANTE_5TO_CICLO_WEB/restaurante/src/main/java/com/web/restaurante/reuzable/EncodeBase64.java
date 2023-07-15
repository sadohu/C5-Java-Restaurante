package com.web.restaurante.reuzable;

import java.util.Base64;

public class EncodeBase64 {
	
	public String base64ToString(byte[] fileByte) {
		return Base64.getMimeEncoder().encodeToString(fileByte);
	}

}
