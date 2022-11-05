public class Transaction {
    private int id;
    private Dvd dvd;
    private Customer customer;

    public Transaction(int id, Dvd dvd, Customer customer) {
        this.id = id;
        this.dvd = dvd;
        this.customer = customer;
    }

    public void reportTransaction() {
        System.out.println("== Report Transaction ==");
        System.out.println("Transaction ID : " + this.id);
        
        // show detail report
        this.showDvdReport(this.dvd);
        this.showCustomerReport(customer);
    }
    
    public void downloadReceipt(){
        System.out.println("Proses download Dvd : " + this.dvd.getTitle());
        System.out.println("Proses download customer : " + this.customer.getName());
    }
    
    private void showDvdReport(Dvd dvd) {
        System.out.println("\nDvd : ");
        System.out.println("Title : " + dvd.getTitle());
        System.out.println("Genre : " + dvd.getGenre());
        System.out.println("Price day : Rp. " + dvd.getPriceDay());
        System.out.println("Year : Rp. " + dvd.getYear());
    }
    
    private void showCustomerReport(Customer customer) {
        System.out.println("\nCustomer : ");
        System.out.println("Name : " + customer.getName());
        System.out.println("Phone Number : " + customer.getPhone());
    }
    
}
