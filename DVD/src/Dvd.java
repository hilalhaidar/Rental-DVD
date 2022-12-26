import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Dvd implements InterfaceDvd {
    ArrayList<String> dftrKode = new ArrayList<String>();
    ArrayList<String> dftrJenis = new ArrayList<String>();
    ArrayList<String> dftrSupplier = new ArrayList<String>();
    ArrayList<String> dftrHBeli = new ArrayList<String>();
    ArrayList<String> dftrHJual = new ArrayList<String>();
    ArrayList<String> dftrStok = new ArrayList<String>();
    ArrayList<String> dftrDateRelease = new ArrayList<String>();
    ArrayList<String> dftrStatus = new ArrayList<String>();


    Locale locale = new Locale("idn", "IDN");
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
    String date = dateFormat.format(new Date());

    protected String kode, jenis, supplier;
    protected int harga_jual, harga_beli, stok;

    public Dvd(){
        dftrKode.add("DG-1");
        dftrJenis.add("Titanic");
        dftrSupplier.add("SP-1");
        dftrHBeli.add("50000");
        dftrHJual.add("55000");
        dftrStok.add("10");
        dftrDateRelease.add("1998-01-05");
        dftrStatus.add("Old");

        dftrKode.add("DG-2");
        dftrJenis.add("Spiderman No Way Home");
        dftrSupplier.add("SP-2");
        dftrHBeli.add("100000");
        dftrHJual.add("110000");
        dftrStok.add("10");
        dftrDateRelease.add("2021-12-15");
        dftrStatus.add("New");
    }

    public void insertData(){
        Scanner in = new Scanner(System.in);
        boolean dt = false;
        String res;
        System.out.println("Ini tanggal "+date);
        System.out.println("Ini locale "+locale);
        System.out.println("========== Input Data Dvd ==========");
        while (!dt){
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            String tgl = format.format(date);
            String[] splitDate = tgl.split("/");
            int dd = Integer.parseInt(splitDate[0])+2;
            int MM = Integer.parseInt(splitDate[1])-1;
            int YY = Integer.parseInt(splitDate[2]);
            dftrDateRelease.add(get_tgl(YY,MM,dd)); // menambah data pada arraylist dengan memanggil fungsi get tanggal expired
            dftrStatus.add("New Release!"); // menambah data pada arraylist
            String lstKode = dftrKode.get(dftrKode.size() - 1);
            String[] getLst = lstKode.split("-");
            int get = Integer.parseInt(getLst[1]) + 1;
            kode = "MV-"+get; // generate kode auto increments
            System.out.println("Kode dvd "+kode);
            dftrKode.add(kode); // menambah data pada arraylist
            System.out.print("Masukkan jenis film ");
            jenis = in.next();
            dftrJenis.add(jenis); // menambah data pada arraylist
            System.out.print("Masukkan supplier dvd : ");
            supplier = in.next();
            dftrSupplier.add(supplier); // menambah data pada arraylist
            System.out.print("Masukkan harga beli dvd : ");
            harga_beli = in.nextInt();
            dftrHBeli.add(String.valueOf(harga_beli)); // menambah data pada arraylist
            System.out.print("Masukkan harga jual dvd : ");
            harga_jual = in.nextInt();
            dftrHJual.add(String.valueOf(harga_jual)); // menambah data pada arraylist
            System.out.print("Masukkan stok dvd : ");
            stok = in.nextInt();
            dftrStok.add(String.valueOf(stok)); // menambah data pada arraylist
            System.out.print("Apakah ingin input lagi? y/n ");
            res = in.next();
            if (res.equals("y")){
                dt = false;
            }else {
                dt = true;
                showDvd();
            }
        }
    }

    public void showDvd(){
        System.out.println("========== Data Dvd ==========");
        for (int i=0; i<dftrKode.size();i++){
            System.out.println("Kode dvd "+dftrKode.get(i));
            System.out.println("Jenis film "+dftrJenis.get(i));
            System.out.println("Supplier dvd "+dftrSupplier.get(i));
            System.out.println("Harga Beli "+dftrHBeli.get(i));
            System.out.println("Harga Jual "+dftrHJual.get(i));
            System.out.println("Stok dvd "+dftrStok.get(i)+"pcs");
            System.out.println("Tanggal Release "+dftrDateRelease.get(i));
            filmLama();
            System.out.println("Status "+dftrStatus.get(i));
            System.out.println("------------------------------");
        }
        Main objMain = new Main();
        objMain.Menu();
    }

    public void removeDvd(){
        Scanner sc = new Scanner(System.in);
        boolean dt = false;
        String res;
        showDvd();
        while(!dt){
            System.out.println("Masukkan Kode Dvd yang ingin dihapus : ");
            kode = sc.next();
            boolean data = dftrKode.contains(kode);
            dftrKode.remove(kode);
            System.out.print("Apakah ingin menghapus data lagi? y/n ");
            res = sc.next();
            if (res.equals("y")){
                dt = false;
            }else {
                dt = true;
                showDvd();
            }
        }
    }

    public void updateDvd(){
        Scanner sc = new Scanner(System.in);
        boolean dt = false;
        String res;
        showDvd();
        while(!dt){
            System.out.println("Masukkan Kode Dvd yang Ingin diubah : ");
            kode = sc.next();
            if (dftrKode.contains(kode)){
                int a = dftrKode.indexOf(kode);

                System.out.println("Masukkan Nama Jenis Film Baru : ");
                jenis = sc.next();
                dftrJenis.set(a,jenis);

                System.out.println("Masukkan supplier dvd Baru : ");
                supplier = sc.next();
                dftrSupplier.set(a,supplier);

                System.out.println("Masukkan harga beli Dvd Baru : ");
                harga_beli = sc.nextInt();
                dftrHBeli.set(a,String.valueOf(harga_beli));

                System.out.println("Masukkan harga jual Dvd Baru : ");
                harga_jual = sc.nextInt();
                dftrHBeli.set(a,String.valueOf(harga_jual));

                System.out.println("Masukkan stok Dvd Baru : ");
                stok = sc.nextInt();
                dftrHBeli.set(a,String.valueOf(stok));
            }
            System.out.print("Apakah ingin mengubah data lagi? y/n ");
            res = sc.next();
            if (res.equals("y")){
                dt = false;
            }else {
                dt = true;
                showDvd();
            }
        }
        Main objMain = new Main();
        objMain.Menu();
    }

    public void cariData(String kode){
        if (dftrKode.contains(kode)){
            System.out.println("Pencarian berdasarkan kode ditemukan!");
            int a = dftrKode.indexOf(kode);
            System.out.println(dftrJenis.get(a));
            System.out.println(dftrSupplier.get(a));
            System.out.println(dftrHBeli.get(a));
            System.out.println(dftrHJual.get(a));
            System.out.println(dftrStok.get(a));
        }else {
            System.out.println("Pencarian berdasarkan kode tidak ditemukan!");
        }
    }

    public void cariData(String kode, String nama){
        if (dftrKode.contains(kode) && dftrJenis.contains(nama)){
            System.out.println("Pencarian berdasarkan kode dan jenis ditemukan!");
            int a = dftrKode.indexOf(kode);
            System.out.println(dftrJenis.get(a));
            System.out.println(dftrSupplier.get(a));
            System.out.println(dftrHBeli.get(a));
            System.out.println(dftrHJual.get(a));
            System.out.println(dftrStok.get(a));
        }else {
            System.out.println("Pencarian berdasarkan kode dan jenis tidak ditemukan!");
        }
        Main objMain = new Main();
        objMain.Menu();
    }

    public String get_tgl(int th, int bl, int tgl){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = new GregorianCalendar(th,bl,tgl,13,24,56);
        String hasil = sdf.format(calendar.getTime());
        return hasil;
    }

    @Override
    public void filmLama() { // memanggil method dari interface
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String tgl = format.format(date);
        boolean exp = dftrDateRelease.contains(tgl); // mencari data dengan tanggal sekarang
        if (exp){
            int gt = dftrDateRelease.indexOf(tgl); // mendapatkan index dari data yang telah ada
            dftrStatus.set(gt, "Out of Date"); // mereplace data format(index, value_baru_yang_dirubah)
        }
    }
}