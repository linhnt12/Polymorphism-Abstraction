public class MonHoc {
    private static int cnt = 100;
    private int maMH;
    private String tenMon;
    private int tongSoTiet, soTietLT, soTietTH, kinhPhi;

    public MonHoc() {
    }

    public MonHoc(String tenMon, int tongSoTiet, int soTietLT, int kinhPhi) {
        this.maMH = cnt++;
        this.tenMon = tenMon;
        this.tongSoTiet = tongSoTiet;
        this.soTietLT = soTietLT;
        this.soTietTH = tongSoTiet - soTietLT;
        this.kinhPhi = kinhPhi;
    }

    public int getMaMH() {
        return maMH;
    }

    public void setMaMH(int maMH) {
        this.maMH = maMH;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getTongSoTiet() {
        return tongSoTiet;
    }

    public void setTongSoTiet(int tongSoTiet) {
        this.tongSoTiet = tongSoTiet;
    }

    public int getSoTietLT() {
        return soTietLT;
    }

    public void setSoTietLT(int soTietLT) {
        this.soTietLT = soTietLT;
    }

    public int getSoTietTH() {
        return soTietTH;
    }

    public void setSoTietTH(int soTietTH) {
        this.soTietTH = soTietTH;
    }

    public int getKinhPhi() {
        return kinhPhi;
    }

    public void setKinhPhi(int kinhPhi) {
        this.kinhPhi = kinhPhi;
    }

    @Override
    public String toString() {
        return maMH + " " + tenMon + " " + tongSoTiet + " " + soTietLT + " " + kinhPhi;
    }
}
