package de.uk.java.entity.item;

import de.uk.java.entity.Entity;

public abstract class Item {
	
	private String name;
	
	public abstract void draw();

	public abstract void useItem(Entity entity);
}
