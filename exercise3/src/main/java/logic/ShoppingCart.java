package logic;

import java.util.ArrayList;
import java.util.Random;

public class ShoppingCart {
	private int requiredUnitItems;
	private int requiredWeightItems;
	private int discount; // in percentage 1 - 100;
	
	private ArrayList<Item> items;
	
	public ShoppingCart() {
		// TODO Auto-generated constructor stub
		Random random = new Random();
		requiredUnitItems = 1 + random.nextInt(3);
		requiredWeightItems = 1 + random.nextInt(3);
		discount = 20;
		items = new ArrayList<Item>();
	}
	
	public void addItem(Item item)
	{
		//fill code
		if (item instanceof UnitItem)
		{
			if (item.unitPrice <= 0 || ((UnitItem) item).getAmount() <= 0)
			{
				return;
			}
			else{
				items.add(item);
			}
		}
		if (item instanceof WeightItem)
		{
			if (item.unitPrice <= 0)
			{
				return;
			}
			else{
				items.add(item);
			}
		}
	}
	
	public double checkOut(){
		//fill code
		double totalCost =0;
		for (Item i:items)
		{
			totalCost += i.cost();
		}

		if (items.size() == 0)
		{
			return 0;
		}
		return totalCost;
	}
	
	public boolean isDiscounted(){
		//fill code

		int unitItemCount =0;
		int weightItemCount =0;

		for (Item i:items)
		{
			if ( i instanceof UnitItem)
			{
				unitItemCount ++;
			}
			if (i instanceof WeightItem)
			{
				weightItemCount ++;
			}
		}

		if (unitItemCount >= requiredUnitItems && weightItemCount >= requiredWeightItems)
		{
			return true;
		}

		return false;
	}

	//Create Getter&Setter method for all private fields

	public int getRequiredUnitItems() {
		return requiredUnitItems;
	}

	public void setRequiredUnitItems(int requiredUnitItems) {
		this.requiredUnitItems = requiredUnitItems;
	}

	public int getRequiredWeightItems() {
		return requiredWeightItems;
	}

	public void setRequiredWeightItems(int requiredWeightItems) {
		this.requiredWeightItems = requiredWeightItems;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
}
