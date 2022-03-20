package com.ankit.cachedesign.cache.storage;

import com.ankit.cachedesign.cache.exceptions.NotFoundException;
import com.ankit.cachedesign.cache.exceptions.StorageFullException;
import java.util.HashMap;
import java.util.Map;


public class HashmapBasedStorage<Key, Value> implements Storage<Key, Value> {

  Map<Key, Value> map = new HashMap<>();

  @Override
  public void add(Key key, Value value) throws StorageFullException {
      map.put(key,value);
  }

  @Override
  public void remove(Key key) throws NotFoundException {
      map.remove(key);
  }

  @Override
  public Value get(Key key) throws NotFoundException {
    return map.get(key);
  }
}
