package com.ankit.cachedesign.cache;

import com.ankit.cachedesign.cache.exceptions.NotFoundException;
import com.ankit.cachedesign.cache.exceptions.StorageFullException;
import com.ankit.cachedesign.cache.policies.EvictionPolicy;
import com.ankit.cachedesign.cache.storage.Storage;


public class Cache<Key, Value> {
    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;


  public Cache(EvictionPolicy<Key> evictionPolicy,
      Storage<Key, Value> storage) {
    this.evictionPolicy = evictionPolicy;
    this.storage = storage;
  }

  public void put(Key key, Value value) throws NotFoundException {
    try {
       this.storage.add(key,value);
       this.evictionPolicy.keyAccessed(key);
    } catch (StorageFullException exception) {
      System.out.println(" Storage full. Will try to evict!!");
      Key keyToRemove = evictionPolicy.evictKey();
      this.storage.remove(keyToRemove);
      put(key, value);
    }
  }

  public Value get(Key key) {
    try {
      Value value = this.storage.get(key);
      this.evictionPolicy.keyAccessed(key);
      return value;
    } catch (NotFoundException exception) {
      System.out.println("Key not found!!");
      return null;
    }
  }
}
