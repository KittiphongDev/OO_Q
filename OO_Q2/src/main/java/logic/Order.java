package logic;

import java.util.ArrayList;

public class Order {
	private ArrayList<OrderItem> orderItemList;
	private static int totalOrderCount = 0;
	private int orderNumber;
	
	public Order() {
		// TODO
		orderItemList = new ArrayList<OrderItem>();
		this.orderNumber = totalOrderCount;
		totalOrderCount++;
	}

	public OrderItem addItem(Item item, int amount) {
		// TODO
		// Loop the orderItemList to find if item of any orderItem equals to the given item
		// if there is orderItem with given item, increase that orderItem itemAmount with amount
		// and return that orderItem

		// else create new orderItem with given item and amount, then return the new orderItem

		for (OrderItem orderItem : orderItemList) {
			if (orderItem.getItem().equals(item)) {
				// If found, just increase the amount
				orderItem.increaseItemAmount(amount);
				return orderItem;
			}
		}

		// 2. If the loop finishes and item wasn't found, create a new OrderItem
		OrderItem newOrderItem = new OrderItem(item, amount);

		// 3. Add it to the list
		orderItemList.add(newOrderItem);

		// 4. Return the new item
		return newOrderItem;
	}

	public int calculateOrderTotalPrice() {
		// TODO
		int totalPrice = 0;
		// Calculate total price of the order by summing total price of each orderItem in orderItemList
		for (OrderItem or:orderItemList)
		{
			totalPrice += or.calculateTotalPrice();
		}
		return totalPrice;
	}

	public static int getTotalOrderCount() {
		return totalOrderCount;
	}
	
	public static void resetTotalOrderCount() {
		totalOrderCount = 0;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public ArrayList<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	
	
}
