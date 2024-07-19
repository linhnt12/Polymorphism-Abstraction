public class GiangVien {
    private static int cnt = 100;
    private int maGV;
    private String hoTen, dchi, sdt, trinhDo;

    public GiangVien() {
    }

    public GiangVien(String hoTen, String dchi, String sdt, String trinhDo) {
        this.maGV = cnt++;
        this.hoTen = hoTen;
        this.dchi = dchi;
        this.sdt = sdt;
        this.trinhDo = trinhDo;
    }

    public int getMaGV() {
        return maGV;
    }

    public void setMaGV(int maGV) {
        this.maGV = maGV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDchi() {
        return dchi;
    }

    public void setDchi(String dchi) {
        this.dchi = dchi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    @Override
    public String toString() {
        return maGV + " " + hoTen + " " + dchi + " " + sdt + " " + trinhDo;
    }
}
