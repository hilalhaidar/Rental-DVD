public class Transaksi {
    protected String tanggal, petugas, kode_dvd;

    public Transaksi(String tanggal, String petugas, String kode_dvd){
        this.tanggal = tanggal;
        this.petugas = petugas;
    }

    public String getKode_dvd() {
        return kode_dvd;
    }

    public void setKode_dvd(String kode_dvd) {
        this.kode_dvd = kode_dvd;
    }

    public String getPetugas() {
        return petugas;
    }

    public void setPetugas(String petugas) {
        this.petugas = petugas;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}