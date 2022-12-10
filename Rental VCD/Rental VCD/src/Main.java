import java.util.Scanner;

public class Main {

    private Customer customer;

    public static void main(String[] args) {

        Horror dvd1 = new Horror("The Conjuring");
        horror1.display();

        Action dvd2 = new Action("Insidious")
        action2.display();
        
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        int menu;

        do {
            System.out.println("MENU");
            System.out.println("1. Registrasi Pengguna");
            System.out.println("2. List DVD");
            System.out.println("3. Transaksi Rental");
            System.out.println("4. Keluar");

            System.out.print("Masukan menu : ");
            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    showListDvd();
                    break;
                case 3:
                    System.out.println("ini bagian transaksi rental");
                    break;
                case 4:
                    System.out.println("Selamat tinggal");
                    break;
                default:
                    System.out.println("Salah input");
                    break;
            }
        } while (menu != 4);      
    }

    private static void registerUser() {

        Scanner sc2 = new Scanner(System.in);
        String name, username, password, address, phone;

        System.out.println("-- CUSTOMER --");
        System.out.print("Nama : ");
        name = sc2.nextLine();
        System.out.print("Alamat : ");
        address = sc2.nextLine();
        System.out.print("Telepon : ");
        phone = sc2.nextLine();
        System.out.print("Username : ");
        username = sc2.nextLine();
        System.out.print("Password : ");
        password = sc2.nextLine();

        Customer customer = new Customer(address, phone);
        customer.setName(name);
        customer.setUsername(username);
        customer.setPassword(password);

        System.out.println("Halooo [ " + customer.getName() + " ]");
    }

    private static void showListDvd() {
        System.out.println("-- DVD --");
        for (int i = 0; i < addListDvd().length; i++) {
            System.out.println("DVD : " + addListDvd()[i].getTitle());
            System.out.println("Genre : " + addListDvd()[i].getGenre());
            System.out.println("Price day : Rp. " + addListDvd()[i].getPriceDay());
            System.out.println("Year : Rp. " + addListDvd()[i].getYear());
            System.out.println("");
        }
    }

    private static Dvd[] addListDvd() {
        Dvd dvd1 = new Dvd();
        dvd1.setTitle("Avenger");
        dvd1.setGenre("Super Hero");
        dvd1.setPriceDay(5000);
        dvd1.setYear(2012);

        Dvd dvd2 = new Dvd();
        dvd2.setTitle("The Conjuring");
        dvd2.setGenre("Horror");
        dvd2.setPriceDay(100000);
        dvd2.setYear(2018);

        Dvd list[] = new Dvd[2];
        list[0] = dvd1;
        list[1] = dvd2;

        return list;
    }

}