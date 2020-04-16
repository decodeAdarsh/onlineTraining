package com.spring.service;


import java.util.List;


import com.spring.json.Advertise;


public interface AdvertiseService {

	Object save(Advertise advertise, String authToken);

	Object update(Advertise advertise, String authToken,String id);

	List<Advertise> getAdvertiseBySessionId(String authToken);

	List<Advertise> getAdvertiseByPostId(String authToken, String postId);

	boolean deleteAdvertiseByPostId(String authToken, String postId);

	List<Advertise> getAdvertiseBySearchText(String searchText);

	List<Advertise> getAdvertiseByCategory(String category);

	List<Advertise> getAdvertiseByName(String name);

	 Advertise getAdvertiseByPostId(String postId);

	List<String> getAllCategory();

	List<Advertise> getAllAdvertise();




	 

}


