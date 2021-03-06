package com.chan.spring.controller;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chan.spring.service.AndroidPushNotificationsService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

@RestController
public class WebController {

	private final String TOPIC = "test";

			
	@Autowired
	AndroidPushNotificationsService androidPushNotificationsService;

	@GetMapping(value = "/send", produces = "application/json")
	public ResponseEntity<String> send() throws JSONException {

		JSONObject body = new JSONObject();
		
		ArrayList<String> TokenList = new ArrayList<String>();
		TokenList.add("dKCOt2RVC-M:APA91bFHmaK8C1idy_Wp8ERW2PWdS4Ouu7Q5sg7DjsbCnHZ1XWst-jE6VFM6CbVl9kmi-bTEotWcX0lQElO4wsWjs5R5lvhFKYGRTvXbPpwMk3mZ0IovrzKuzhuYgc2aAUFMJwi-v6JO");
		TokenList.add("cKz1riJ1a0o:APA91bF0MP3QofwoBpvP-6F3blJnVINm6gF6gPP9mAqinJ_SRBKMAt1uPqBcJpq3lj6IyGVyUdXEkZ0zZj6RwlHE_b4fmjXCN0cc1OOS94szzMAb3KvmtgL96ef1RD-j_L9uA7Pa5wD9");
		
		JSONArray regId = new JSONArray();
		for(int i = 0; i < TokenList.size(); i++ ) {
			regId.put(TokenList.get(i));
		}
		
		
		//TokenID = TokenID == null ? TOPIC.trim() : TokenID.trim();
		
		body.put("registration_ids", regId);
		body.put("priority", "high");
		JSONObject notification = new JSONObject();
		notification.put("title", "HELLO Nhway");
		notification.put("body", "I Love You!");
		
		JSONObject data = new JSONObject();
		data.put("Key-1", "JSA Data 1");
		data.put("Key-2", "JSA Data 2");

		body.put("notification", notification);
		body.put("data", data);

		HttpEntity<String> request = new HttpEntity<>(body.toString());

		CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
		CompletableFuture.allOf(pushNotification).join();

		try {
			String firebaseResponse = pushNotification.get();
			
			return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
	}
}
