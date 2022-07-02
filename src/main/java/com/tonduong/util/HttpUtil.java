package com.tonduong.util;

import java.io.BufferedReader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {

	private String value;

	public HttpUtil(String value) {
		this.value = value;
	}

	public <T> T toModel(Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String toJson() {
		try {
			return new ObjectMapper().writeValueAsString(value);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static HttpUtil of(BufferedReader reader) {
		String data = "";
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				data += line;
			}
		} catch (Exception e) {
		}
		return new HttpUtil(data);
	}

	public String getValue() {
		return value;
	}
}
