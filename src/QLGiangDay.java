import java.util.Arrays;

public class QLGiangDay {
    private GiangVien giangVien;
    private MonHoc[] dsMonHoc;
    private int[] soLopMoiMon;
    private int tongSoLop;

    public QLGiangDay(GiangVien giangVien) {
        this.giangVien = giangVien;
        this.dsMonHoc = new MonHoc[100];
        this.soLopMoiMon = new int[100];
        this.tongSoLop = 0;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public MonHoc[] getDsMonHoc() {
        return dsMonHoc;
    }

    public void setDsMonHoc(MonHoc[] dsMonHoc) {
        this.dsMonHoc = dsMonHoc;
    }

    public int[] getSoLopMoiMon() {
        return soLopMoiMon;
    }

    public void setSoLopMoiMon(int[] soLopMoiMon) {
        this.soLopMoiMon = soLopMoiMon;
    }

    public int getTongSoLop() {
        return tongSoLop;
    }

    public void setTongSoLop(int tongSoLop) {
        this.tongSoLop = tongSoLop;
    }

    public boolean dangKy(MonHoc monHoc, int soLop) {
        if (soLop <= 0 || soLop > 3) return false;
        if (getTotal() + monHoc.getTongSoTiet()*soLop > 200) return false;

        for (int i=0; i<tongSoLop; i++) {
            if (dsMonHoc[i].getMaMH() == monHoc.getMaMH()) {
                if (soLopMoiMon[i] + soLop > 3) return false;
                else {
                    soLopMoiMon[i] += soLop;
                    return true;
                }
            }
        }

        dsMonHoc[tongSoLop] = monHoc;
        soLopMoiMon[tongSoLop] = soLop;
        tongSoLop++;
        return true;
    }

    public int getTotal() {
        int total = 0;
        for (int i=0; i<tongSoLop; i++) {
            total += dsMonHoc[i].getTongSoTiet() * soLopMoiMon[i];
        }
        return total;
    }

    public double getLuong() {
        double luong = 0;
        for (int i=0; i<tongSoLop; i++) {
           luong = luong + dsMonHoc[i].getSoTietLT()*soLopMoiMon[i]*dsMonHoc[i].getKinhPhi() + dsMonHoc[i].getSoTietTH()*soLopMoiMon[i]*dsMonHoc[i].getKinhPhi()*0.7;
        }
        return luong;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Danh sách các môn học giảng viên " + this.giangVien.getHoTen() + " giảng dạy: \n");
        for (int i=0; i<tongSoLop; i++) {
            sb.append("Mã môn: ").append(dsMonHoc[i].getMaMH()).append("; Tên môn: ").append(dsMonHoc[i].getTenMon()).append("; Số lớp: ").append(soLopMoiMon[i]).append("\n");
        }
        sb.append("Tổng số tiết: ").append(getTotal()).append("\n");
        return sb.toString();
    }
}
