package logic;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.random;

public class WeightItem extends Item {
    private double weight;

    public WeightItem(String name, double unitPrice)
    {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    @Override
    public double cost() {
        return weight*unitPrice;
    }

    public double scale()
    {
        return ThreadLocalRandom.current().nextDouble(0.01, 4.00);
    }

    @Override
    public String toString() {
        return "WeightItem : "+ name + weight + unitPrice + cost() + '\"';
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
