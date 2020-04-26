public class Invoice implements Payable
{
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity >= 0)
            this.quantity = quantity;
        else
            throw new IllegalArgumentException("Quantity must be >= 0");
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        if(pricePerItem >= 0.0)
            this.pricePerItem = pricePerItem;
        else
            throw new IllegalArgumentException("Price per item must be >= 0");
    }

    @Override
    public String toString() {
        return String.format("%s: \n%s: %s (%s) \n%s: %d \n%s: $%, .2f",
                "invoice", "part number", getPartNumber(), getPartDescription(), "quantity",
                getQuantity(), "price per item", getPricePerItem());
    }

    @Override
    public double getPaymentAmount() {
        return getPricePerItem() * getQuantity();
    }
}
