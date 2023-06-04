package de.uk.java.entity;

import de.uk.java.entity.item.Item;

import java.util.HashMap;

public class Inventory {
	private HashMap<Item, Integer> items;
	
	public Inventory() {
		items = new HashMap<Item, Integer>();
	}
	
	public void addItem(Item item, int amount) {
			items.merge(item, amount, Integer::sum);
	}
	@Override
	public String toString() {
		return items.toString();
	}
}
