import java.util.ArrayList;
import java.util.Scanner;
public class Supplier extends Person {

    ArrayList<String> dftrKode = new ArrayList<String>();
    ArrayList<String> dftrNama = new ArrayList<String>();
    ArrayList<String> dftrNo_hp = new ArrayList<String>();
    ArrayList<String> dftrAlamat = new ArrayList<String>();

    protected String kode, Alamat;

    public Supplier() {
        dftrKode.add("PM-1");
        dftrNama.add("Rizal");
        dftrNo_hp.add("085237689012");
        dftrAlamat.add("Jalan Karimata No.15");

        dftrKode.add("PM-2");
        dftrNama.add("Choirul Huda");
        dftrNo_hp.add("085238867779");
        dftrAlamat.add("Jln. Jawa mania");
    }

    public void addSupplier(){
        Scanner sc = new Scanner(System.in);
        boolean dt = false;
        String res;
        System.out.println("========== Input Data Supplier ==========");
        while (!dt){
            System.out.println("Kode User: "+GetKode());
            dftrKode.add(kode);
            System.out.print("Masukkan Nama : ");
            setNama(sc.nextLine());
            dftrNama.add(getNama());
            System.out.print("Masukkan No HP : ");
            setNo_hp(sc.nextLine());
            dftrNo_hp.add(getNo_hp());
            System.out.println("Masukkan Alamat : ");
            Alamat = sc.nextLine();
            dftrAlamat.add(this.Alamat);
            System.out.print("Apakah ingin input lagi? y/n ");
            res = sc.next();
            if (res.equals("y")){
                dt = false;
            }else {
                dt = true;
                showData();
            }
        }
    }

    public void removeSupplier(){
        System.out.println("========== Hapus Data Supplier ==========");
        Scanner sc = new Scanner(System.in);
        boolean dt = false;
        String res;
        showData();
        while(!dt){
            System.out.println("Masukkan Kode Supplier yang ingin dihapus : ");
            kode = sc.next();
            boolean data = dftrKode.contains(kode);
            dftrKode.remove(kode);
            System.out.print("Apakah ingin menghapus data lagi? y/n ");
            res = sc.next();
            if (res.equals("y")){
                dt = false;
            }else {
                dt = true;
                showData();
            }
        }
    }

    public void showData(){
        System.out.println("=============== Data Supplier ===============");
        for (int i=0; i<dftrKode.size(); i++ ){
            System.out.println("Kode Supplier : "+dftrKode.get(i));
            System.out.println("Nama Supplier : "+dftrNama.get(i));
            System.out.println("No HP : "+dftrNo_hp.get(i));
            System.out.println("Alamat : "+dftrAlamat.get(i));
            System.out.println("----------------------------------------");
        }
        Main objMain = new Main();
        objMain.Menu();
    }

    @Override
    String GetKode() {
        String lstKode = dftrKode.get(dftrKode.size() - 1);
        String[] getLst = lstKode.split("-");
        int get = Integer.parseInt(getLst[1]) + 1;
        kode = "SP-"+get;
        return kode;
    }
}