import java.util.ArrayList;
import java.util.Scanner;
public class Petugas extends Person {

    ArrayList<String> dftrKode = new ArrayList<String>();
    ArrayList<String> dftrUsername = new ArrayList<String>();
    ArrayList<String> dftrPassword = new ArrayList<String>();
    ArrayList<String> dftrNama = new ArrayList<String>();
    ArrayList<String> dftrNo_hp = new ArrayList<String>();

    protected String kode, user, password;

    public Petugas() {
        dftrKode.add("US-1");
        dftrNama.add("Mad Ikhsan");
        dftrUsername.add("admin");
        dftrPassword.add("12345");
        dftrNo_hp.add("08983368286");
    }

    public void addUser() {
        Scanner sc = new Scanner(System.in);
        boolean dt = false;
        String res;
        System.out.println("========== Input Data Kasir ==========");
        while (!dt) {
            System.out.println("Kode User: " + GetKode());
            dftrKode.add(kode);
            System.out.println("Masukkan nama : ");
            setNama(sc.nextLine()); // memberi nilai pada atribut di super class
            dftrNama.add(getNama()); // menambah data ke arraylist dengan mengambil nilai dari attribut pada super class
            System.out.print("Masukkan no_hp : ");
            setNo_hp(sc.nextLine()); // memberi nilai pada atribut di super class
            dftrNo_hp.add(getNo_hp());
            System.out.print("Masukkan username : ");
            user = sc.nextLine();
            dftrUsername.add(this.user);
            System.out.print("Masukkan password : ");
            password = sc.nextLine();
            dftrPassword.add(this.password);
            System.out.print("Apakah ingin input lagi? y/n ");
            res = sc.next();
            if (res.equals("y")) {
                dt = false;
            } else {
                dt = true;
                showData();
            }
        }
    }

    public void removeUser() {
        Scanner sc = new Scanner(System.in);
        boolean dt = false;
        String res;
        showData();
        while (!dt) {
            System.out.println("Masukkan Kode Dvd yang ingin dihapus : ");
            kode = sc.next();
            boolean data = dftrKode.contains(kode);
            dftrKode.remove(kode);
            System.out.print("Apakah ingin menghapus data lagi? y/n ");
            res = sc.next();
            if (res.equals("y")) {
                dt = false;
            } else {
                dt = true;
                showData();
            }
        }
    }

    public void showData() {
        System.out.println("=============== Data User ===============");
        for (int i = 0; i < dftrKode.size(); i++) {
            System.out.println("Kode user : " + dftrKode.get(i));
            System.out.println("Nama user : " + dftrNama.get(i));
            System.out.println("No HP : " + dftrNo_hp.get(i));
            System.out.println("Username : " + dftrUsername.get(i));
            System.out.println("----------------------------------------");
        }
        Main objMain = new Main();
        objMain.Menu();
    }


    public void updateUser() {
        Scanner sc = new Scanner(System.in);
        boolean dt = false;
        String res;
        showData();
        while (!dt) {
            System.out.println("Masukkan Kode User yang Ingin diubah : ");
            kode = sc.next();
            if (dftrKode.contains(kode)) {
                int a = dftrKode.indexOf(kode);

                System.out.println("Masukkan Nama User Baru : ");
                setNama(sc.next()); // memberi nilai pada atribut di super class
                dftrNama.set(a, getNama());

                System.out.println("Masukkan No. HP User Baru : ");
                setNo_hp(sc.nextLine());
                dftrNo_hp.set(a, getNo_hp());

                System.out.println("Masukkan Username Baru : ");
                user = sc.next();
                dftrUsername.set(a, user);

                System.out.println("Masukkan Password Baru : ");
                password = sc.next();
                dftrPassword.set(a, password);
            }
            System.out.print("Apakah ingin mengubah data lagi? y/n ");
            res = sc.next();
            if (res.equals("y")) {
                dt = false;
            } else {
                dt = true;
                showData();
            }
        }
    }

    @Override
    String GetKode() {
        String lstKode = dftrKode.get(dftrKode.size() - 1);
        String[] getLst = lstKode.split("-");
        int get = Integer.parseInt(getLst[1]) + 1;
        kode = "US-" + get;
        return kode;
    }
}