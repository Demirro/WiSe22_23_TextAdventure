package de.uk.java.entity.item;

import de.uk.java.entity.Entity;
import de.uk.java.entity.item.IThrowable;
import de.uk.java.entity.item.Item;

public abstract class Potion extends Item implements IThrowable {

	public abstract void useItem(Entity entity);
	
	public abstract void draw();
	
}
