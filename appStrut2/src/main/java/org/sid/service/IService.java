package org.sid.service;

import java.util.List;

public interface IService<T> {
	public void add(T t);

	public List<T> findAll();
	public T getOne(String id);
	public void delete(String id);
	public void update(T t);
}
