package com.bookStore.store;

import org.json.JSONObject;

public class PaymentAPI {
	public static void main(String ar[]) {
		makePayment();
	}
	public static void makePayment() {
		JSONObject paytmParams = new JSONObject();
		JSONObject body = new JSONObject();
		body.put("requestType", "Payment");
		body.put("mid", "Anubhav");
		body.put("websiteName", "MyBookStore");
		body.put("orderId", "ORDER_12345");
		body.put("callbackUrl", "https://mybookstore.com/payment");
		
		JSONObject txtAmount = new JSONObject();
		txtAmount.put("value", "1.00");
		txtAmount.put("currency", "INR");
		
		JSONObject userInfo = new JSONObject();
		userInfo.put("custId", "CUST_ID");
		body.put("txnAmount", txtAmount);
		body.put("userInfo", userInfo);
		
	}
}
