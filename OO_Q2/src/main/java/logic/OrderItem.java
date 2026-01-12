package logic;

public class OrderItem {
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        if (itemAmount <0)
        {
            this.itemAmount =0;
        }
        else{
            this.itemAmount = itemAmount;
        }
    }

    Item item;
    int itemAmount;

    public OrderItem(Item item,int itemAmount)
    {
        this.item = item;
        if (itemAmount < 0) {
            this.itemAmount = 0;
        } else {
            this.itemAmount = itemAmount;
        }
    }

    public void increaseItemAmount(int amount)
    {

        if (amount<0)
        {
        }
        else{
            itemAmount += amount;
        }
    }

    public  int calculateTotalPrice()
    {
        return itemAmount*item.getPricePerPiece();
    }
}
