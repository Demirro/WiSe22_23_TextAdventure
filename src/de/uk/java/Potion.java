package de.uk.java;

public abstract class Potion extends Item implements IThrowable {

	public abstract void powerUp(Entity entity);
	
	public abstract void draw();
	
}
