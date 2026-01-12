package logic;

public class Item {

    String name;
    int pricePerPiece;

    public Item(String name,int pricePerPiece)
    {
        this.name = name;

        if (pricePerPiece < 1 )
        {
            this.pricePerPiece = 1;
        }
        else{
            this.pricePerPiece = pricePerPiece;
        }
    }

    public int getPricePerPiece() {
        return pricePerPiece;
    }

    public void setPricePerPiece(int pricePerPiece) {
        if (pricePerPiece < 1 )
        {
            this.pricePerPiece = 1;
        }
        else{
            this.pricePerPiece = pricePerPiece;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
