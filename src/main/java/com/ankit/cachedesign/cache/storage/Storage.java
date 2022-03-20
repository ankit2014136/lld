package com.ankit.cachedesign.cache.storage;

import com.ankit.cachedesign.cache.exceptions.NotFoundException;
import com.ankit.cachedesign.cache.exceptions.StorageFullException;


public interface Storage<Key, Value> {

  public void add(Key key, Value value) throws StorageFullException;

  void remove(Key key) throws NotFoundException;

  Value get(Key key) throws NotFoundException;

}
