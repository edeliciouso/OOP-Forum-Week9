public class SalesPerson {
    private String id;
    private Sales[] salesHistory;
    private int count = 0;

    public SalesPerson(String id){
        this.id = id;
        this.salesHistory = new Sales[100]; // Default size = 100
        this.count = 0;
    }

    public SalesPerson(String id, Sales[] s, int c){
        this.id = id;
        this.salesHistory = s;
        this.count = c;
    }

    public int getCount() {
        return count;
    }
    public String getId() {
        return id;
    }
    public void setSalesHistory(Sales s){
        salesHistory[count] = s;
        count++;
    }
    public Sales getSalesHistory(int i) {
        return salesHistory[i];
    }
    public double calcTotalSales(){
        double total = 0;
        for (Sales sale : salesHistory) {
            if (sale != null) {
                total += sale.getValue() * sale.getQuantity();
            }
        }
        return total;
    }
    public Sales largestSale(){
        double total = 0;
        int index = 0;
        for (int i = 0; i < count; i++) {
            if (salesHistory[i].getValue() * salesHistory[i].getQuantity() > total) {
                total = salesHistory[i].getValue() * salesHistory[i].getQuantity();
                index = i - 1;
            }
        }
        return salesHistory[index];
    }

}
