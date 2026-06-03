public class Order {
    private String items;
    private String address;
    private double totalCost;

    public Order(String items, String address, double totalCost) {
        this.items = items;
        this.address = address;
        this.totalCost = totalCost;
    }

    public Order() {
        this("Не указано", "Не указан", 0.0);
    }

    public String getItems() {
        return items;
    }

    public String getAddress() {
        return address;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Товары: " + items + ", адрес: " + address + ", стоимость: " + totalCost + " руб.";
    }
}
