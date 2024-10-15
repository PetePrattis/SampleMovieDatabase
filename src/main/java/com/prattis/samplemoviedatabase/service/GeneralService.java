package com.prattis.samplemoviedatabase.service;

import java.util.List;

public interface GeneralService<T, K> {
	
	T create(T object);
	
	List<T> read();
	
	T read(K id);
	
	T update(K id, T updatedObject);
	
	T delete(K id);
}
