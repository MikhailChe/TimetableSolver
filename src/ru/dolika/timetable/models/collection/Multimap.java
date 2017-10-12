package ru.dolika.timetable.models.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Multimap<K, V> {

	Map<K, List<V>> keyToValues;
	Map<V, List<K>> valuesToKeys;

	public Multimap() {
		this.keyToValues = new ConcurrentHashMap<>();
		this.valuesToKeys = new ConcurrentHashMap<>();
	}

	public Multimap<K, V> add(final K k, final V v) {
		this.keyToValues.computeIfAbsent(k, key -> new ArrayList<>(4)).add(v);
		this.valuesToKeys.computeIfAbsent(v, value -> new ArrayList<>(4)).add(k);
		return this;
	}

	public Multimap<K, V> removeKey(final K k) {
		this.keyToValues.forEach((key, value) -> {
			value.forEach(contValue -> {
				this.valuesToKeys.compute(contValue, (outval, outkey) -> {
					outkey.remove(k);
					if (outkey.isEmpty())
						return null;
					return outkey;
				});
			});
		});
	this.keyToValues.remove(k);

		return this;
	}

	public Multimap<K, V> removeValue(final V v) {
		this.valuesToKeys.forEach((key, value) -> {
			value.forEach(contValue -> {
				this.keyToValues.compute(contValue, (outval, outkey) -> {
					outkey.remove(v);
					if (outkey.isEmpty())
						return null;
					return outkey;
				});
			});
		});
		this.valuesToKeys.remove(v);

		return this;
	}

	public List<V> getValuesByKey(final K key) {
		return this.keyToValues.get(key);
	}

	public List<K> getKeysByValue(final V value) {
		return this.valuesToKeys.get(value);
	}

}
