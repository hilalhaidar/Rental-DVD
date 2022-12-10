public class Customer extends User {
    private String address;
    private String phone;

    public Customer(String address, String phone) {
        this.address = address;
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
}
