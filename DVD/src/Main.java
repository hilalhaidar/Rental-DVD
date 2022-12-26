//import java.io.Console;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Login();
    }

    public static void Login(){
        Petugas objPetugas = new Petugas();

        String u="admin", p="admin", user="", pass="";
//        Console cnsl = null;
        int ps;
        boolean bool = true;
        while (bool){
            Scanner scan = new Scanner(System.in);

            System.out.println("==========LOGIN==========");
            System.out.print("Masukkan username : ");
            user = scan.next();
            objPetugas.dftrUsername.contains(user);
            System.out.print("Masukkan password : ");
            pass = scan.next();
            ps = objPetugas.dftrUsername.indexOf(user);
            System.out.println(objPetugas.dftrPassword.get(ps));
            if (objPetugas.dftrPassword.get(ps).equals(pass) && objPetugas.dftrUsername.contains(user) == true){
                bool = true;
                System.out.println("Login berhasil");
                Menu();
            }else {
                bool = true;
                System.out.println("Login gagal");
            }

        }

    }

    public static void Menu(){
        Scanner in = new Scanner(System.in);
        int menu;
        System.out.println("Pilih menu : ");
        System.out.println("1. Data Dvd");
        System.out.println("2. Data Supplier");
        System.out.println("3. Transaksi pembelian");
        System.out.println("4. Transaksi penjualan");
        System.out.println("5. Data User");
        System.out.println("6. Keluar");
        System.out.print("Masukkan nomor menu : ");
        menu = in.nextInt();

        switch (menu){
            case 1:
                dataDvd();
                break;
            case 2:
                // Tambah supplier
                dataSupplier();
                break;
            case 3:
                Pembelian pembelian = new Pembelian("","","");
                pembelian.inputTransaksi();
                break;
            case 4:
                //transaksi jual
                // pengurangan stok
                Penjualan penjualan = new Penjualan("", "", "");
                penjualan.inputTransaksi();
                break;
            case 5:
                dataUser();
                break;
            case 6:
                //exit
                break;
            default:
                System.out.println("Menu tidak ditemukan");
                break;
        }
    }

    public static void dataUser(){
        Scanner sc = new Scanner(System.in);
        int menu ;
        System.out.println("=============== Data User ==============");
        System.out.println("1. Tampil Data User");
        System.out.println("2. Tambah Data User");
        System.out.println("3. Edit Data User");
        System.out.println("4. Hapus Data User");
        System.out.println("5. Menu Utama");
        System.out.print("Pilih nomor menu: ");
        menu = sc.nextInt();
        Petugas petugas = new Petugas();
        switch (menu){
            case 1:
                //show data
                petugas.showData();
                break;
            case 2:
                //Tambah Data User
                petugas.addUser();
                break;
            case 3:
                //Edit Data User
                petugas.updateUser();
                break;
            case 4:
                //Hapus Data User
                petugas.removeUser();
                break;
            case 5:
                //Kembali ke menu utama
                Menu();
                break;
            default:
                System.out.println("Input tidak valid");
                break;


        }
    }

    public static void dataSupplier(){
        Scanner sc = new Scanner(System.in);
        int menu ;
        System.out.println("=============== Data Supplier ==============");
        System.out.println("1. Tampil Data Supplier");
        System.out.println("2. Tambah Data Supplier");
        System.out.println("3. Hapus Data Supplier");
        System.out.println("4. Menu Utama");
        System.out.print("Pilih nomor menu: ");
        menu = sc.nextInt();
        Supplier supplier = new Supplier();
        switch (menu){
            case 1:
                //show data
                supplier.showData();
                break;
            case 2:
                //Tambah Data Supplier
                supplier.addSupplier();
                break;
            case 3:
                //Hapus Data Supplier
                supplier.removeSupplier();
                break;
            case 5:
                //Kembali ke menu utama
                Menu();
                break;
            default:
                System.out.println("Input tidak valid");
                break;


        }
    }

    public static void dataDvd(){
        Scanner sc = new Scanner(System.in);
        int menu ;
        System.out.println("=============== Data Dvd ==============");
        System.out.println("1. Tampil Data Dvd");
        System.out.println("2. Tambah Data Dvd");
        System.out.println("3. Edit Data Dvd");
        System.out.println("4. Hapus Data Dvd");
        System.out.println("5. Cari Data Dvd");
        System.out.println("6. Menu Utama");
        System.out.print("Pilih nomor menu: ");
        menu = sc.nextInt();
        Dvd dvd = new Dvd();
        switch (menu){
            case 1:
                //show data
                dvd.showDvd();
                break;
            case 2:
                //Tambah Data dvd
                dvd.insertData();
                break;
            case 3:
                //Edit Data Dvd
                dvd.updateDvd();
                break;
            case 4:
                //Hapus Data Dvd
                dvd.removeDvd();
                break;
            case 5:
                //Cari Data Dvd
                String key, key1, Nama;
                System.out.print("Masukkan Keyword(kode/kode dan nama) : ");
                Nama = sc.next();
                String str = Nama;
                String[] value = str.split(",");
                int val = value.length;
                if (val>1){
                    key = value[0];
                    key1 = value[1];
                }else {
                    key = value[0];
                    key1 = "";
                }

                if (key1.equals("")){
                    dvd.cariData(key);
                }else {
                    dvd.cariData(key, key1);
                }
                break;
            case 6:
                //Kembali ke menu utama
                Menu();
                break;
            default:
                System.out.println("Input tidak valid");
                break;
        }
    }
}