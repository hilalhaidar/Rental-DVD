
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Pembelian extends Transaksi {

    ArrayList<String> listKodeBeli = new ArrayList<String>();
    ArrayList<String> listTanggal = new ArrayList<String>();
    ArrayList<String> listKodeDvd = new ArrayList<String>();
    ArrayList<String> listKodePetugas = new ArrayList<String>();
    ArrayList<Integer> listJumlahBeli = new ArrayList<Integer>();
    ArrayList<Integer> listTtlHarga = new ArrayList<Integer>();

    private String kode;
    private int jumlah, harga;

    public Pembelian(String tanggal, String petugas, String kode_dvd) {
        super(tanggal, petugas, kode_dvd);
    }

    public void inputTransaksi() {
        Scanner sc = new Scanner(System.in);
        boolean st = false;
        String res;
        while (!st) {
            if (listKodeBeli.size() == 0) {
                kode = "TB-1";
            } else {
                String lstKode = listKodeBeli.get(listKodeBeli.size() - 1);
                String[] getLast = lstKode.split("-");
                int get = Integer.parseInt(getLast[1]) + 1;
                kode = "TB-" + get;
            }

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String tgl = format.format(date);

            System.out.println("Kode Pembelian : " + kode);
            setTanggal(tgl);
            System.out.println("Tanggal pembelian : " + getTanggal());
            System.out.print("Masukkan kode dvd : ");
            setKode_dvd(sc.next());
            System.out.print("Masukkan kode petugas : ");
            setPetugas(sc.next());
            System.out.print("Masukkan jumlah pembelian : ");
            jumlah = sc.nextInt();
            System.out.println("Total harga : " + getHarga(jumlah, getKode_dvd()));
            System.out.print("Apakah ingin input lagi? y/n ");
            res = sc.next();
            if (res.equals("y")) {
                st = false;
                addData(kode, tgl, getKode_dvd(), getPetugas(), jumlah, getHarga(jumlah, getKode_dvd()));
                updateStok(jumlah, getKode_dvd());
            } else {
                st = true;
                addData(kode, tgl, getKode_dvd(), getPetugas(), jumlah, getHarga(jumlah, getKode_dvd()));
                updateStok(jumlah, getKode_dvd());
                show_data();
            }

        }
    }

    public void addData(String kode, String tgl, String dvd, String petugas, int jumlah, int ttlHrga) {
        listKodeBeli.add(kode);
        listTanggal.add(tgl);
        listKodeDvd.add(dvd);
        listKodePetugas.add(petugas);
        listJumlahBeli.add(jumlah);
        listTtlHarga.add(ttlHrga);
    }

    public int getHarga(int jumlah, String kode_dvd) {
        Dvd dvd = new Dvd();
        dvd.dftrKode.contains(kode_dvd);
        int id = dvd.dftrKode.indexOf(kode_dvd);
        int harga = Integer.parseInt(dvd.dftrHBeli.get(id));
        int hasil = harga * jumlah;
        return hasil;
    }

    public void updateStok(int jumlah, String kode_dvd) {
        Dvd dvd = new Dvd();
        dvd.dftrKode.contains(kode_dvd);
        int id = dvd.dftrKode.indexOf(kode_dvd);
        int stok = Integer.parseInt(dvd.dftrStok.get(id));
        int hasil = stok + jumlah;
        dvd.dftrStok.set(id, String.valueOf(hasil));

    }

    public void show_data() {
        System.out.println("=============== List Pembelian ===============");
        for (int i = 0; i < listKodeBeli.size(); i++) {
            Dvd dvd = new Dvd();
            dvd.dftrKode.contains(listKodeDvd.get(i));
            int id = dvd.dftrKode.indexOf(listKodeDvd.get(i));
            int stok = Integer.parseInt(dvd.dftrStok.get(id));
            int hasil = stok + jumlah;
            dvd.dftrStok.set(id, String.valueOf(hasil));

            System.out.println("Kode Transaksi : " + listKodeBeli.get(i));
            System.out.println("Tanggal Transaksi : " + listTanggal.get(i));
            System.out.println("Kode dvd : " + listKodeDvd.get(i));
            System.out.println("Kode petugas : " + listKodePetugas.get(i));
            System.out.println("Jumlah : " + listJumlahBeli.get(i));
            System.out.println("Total harga : " + listTtlHarga.get(i));
            System.out.println("Stok saat ini : " + dvd.dftrStok.set(id, String.valueOf(hasil)));
            System.out.println("------------------------------");
        }
        Main objMain = new Main();
        objMain.Menu();
    }
}