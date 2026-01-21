package logic;

public class UnitItem extends Item{
    private int amount;
    public UnitItem(String name, double unitPrice, int amount)
    {
        this.name = name;
        this.unitPrice = unitPrice;
        this.amount = amount;
    }

    @Override
    public double cost() {
        return unitPrice*amount;
    }

    @Override
    public String toString() {
        return "WeightItem : "+ name + amount + unitPrice + cost() + '\"';

    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
