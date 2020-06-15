package DTO;

import java.util.Hashtable;

public class Entity {
	protected Hashtable<String, String> attribute = null;
	
	public Entity() {
		attribute = new Hashtable<String, String>();
	}
	
	public final void clear() {
		attribute.clear();
	}
}
