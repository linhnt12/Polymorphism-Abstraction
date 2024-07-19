import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static MonHoc[] dsMonHoc = new MonHoc[100];
    private static int cntMonHoc = 0;
    private static GiangVien[] dsGiangVien = new GiangVien[100];
    private static int cntGiangVien = 0;
    private static QLGiangDay[] qlGiangDays = new QLGiangDay[100];
    private static int cntQLGiangDay = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Nhập danh sách môn học.");
            System.out.println("2. Nhập danh sách giảng viên.");
            System.out.println("3. Lập bảng kê khai giảng dạy cho mỗi giảng viên.");
            System.out.println("4. Sắp xếp danh sách kê khai giảng dạy theo họ tên giảng viên.");
            System.out.println("5. Sắp xếp danh sách kê khai giảng dạy theo số tiết giảng dạy mỗi môn (giảm dần).");
            System.out.println("6. Tính toán và lập bảng tính tiền công cho mỗi giảng viên.");
            System.out.println("0. Thoát.");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    nhapMonHoc();
                    inDsMonHoc();
                    break;
                case 2:
                    nhapGiangVien();
                    inDsGiangVien();
                    break;
                case 3:
                    lapBangKeKhai();
                    inBangKeKhai();
                    break;
                case 4:
                    sapXepTheoTen();
                    break;
                case 5:
                    sapXepTheoSoTiet();
                    break;
                case 6:
                    bangTinhCong();
                    break;
                case 0:
                    System.out.println("Kết thúc!");
                    return;
            }
        }
    }

    public static void nhapMonHoc() {
        System.out.print("Nhập số lượng môn học: ");
        int slMonHoc = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < slMonHoc; i++) {
            System.out.println("Nhập thông tin môn học thứ " + (i+1));
            System.out.print("Tên môn học: ");
            String tenMonHoc = sc.nextLine();
            System.out.print("Tổng số tiết: ");
            int tongSoTiet = Integer.parseInt(sc.nextLine());
            System.out.print("Số tiết lý thuyết: ");
            int soTietLT = Integer.parseInt(sc.nextLine());
            System.out.print("Mức kinh phí: ");
            int kinhPhi = Integer.parseInt(sc.nextLine());
            dsMonHoc[cntMonHoc++] = new MonHoc(tenMonHoc, tongSoTiet, soTietLT, kinhPhi);
        }
    }

    public static void inDsMonHoc() {
        System.out.println("Danh sách môn học:");
        for (int i=0; i<cntMonHoc; i++) {
            System.out.println(dsMonHoc[i]);
        }
    }

    public static void nhapGiangVien() {
        System.out.print("Nhập số lượng giảng viên: ");
        int slGV = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < slGV; i++) {
            System.out.println("Nhập thông tin giảng viên thứ " + (i+1));
            System.out.print("Họ tên giảng viên: ");
            String tenGV = sc.nextLine();
            System.out.print("Địa chỉ: ");
            String dchi = sc.nextLine();
            System.out.print("Số điện thoại: ");
            String sdt = sc.nextLine();
            System.out.print("Chọn trình độ: \n" +
                    "1. GS-TS\n" +
                    "2. PGS-TS\n" +
                    "3. Giảng viên chính\n" +
                    "4. Thạc sỹ\n");
            int td = Integer.parseInt(sc.nextLine());
            String trinhDo = "";
            switch (td) {
                case 1:
                    trinhDo = "GS-TS";
                    break;
                case 2:
                    trinhDo = "PGS-TS";
                    break;
                case 3:
                    trinhDo = "Giảng viên chính";
                    break;
                case 4:
                    trinhDo = "Thạc sỹ";
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    return;
            }
            dsGiangVien[cntGiangVien++] = new GiangVien(tenGV, dchi, sdt, trinhDo);
        }
    }

    public static void inDsGiangVien() {
        System.out.println("Danh sách giảng viên:");
        for (int i=0; i<cntGiangVien; i++) {
            System.out.println(dsGiangVien[i]);
        }
    }

    public static void lapBangKeKhai() {
        System.out.print("Nhập mã giảng viên: ");
        int maGV = Integer.parseInt(sc.nextLine());
        GiangVien giangVien = null;
        for (int i=0; i<cntGiangVien; i++) {
            if (dsGiangVien[i].getMaGV() == maGV) {
                giangVien = dsGiangVien[i];
                break;
            }
        }
        if (giangVien == null) {
            System.out.println("Không tìm thấy giảng viên!");
            return;
        };

        QLGiangDay qlGiangDay = null;
        for (int i=0; i<cntQLGiangDay; i++) {
            if (qlGiangDays[i].getGiangVien().getMaGV() == giangVien.getMaGV()) {
                qlGiangDay = qlGiangDays[i];
                break;
            }
        }
        if (qlGiangDay == null) {
            qlGiangDay = new QLGiangDay(giangVien);
            qlGiangDays[cntQLGiangDay++] = qlGiangDay;
        }

        System.out.print("Nhập số môn muốn kê khai: ");
        int soMon = Integer.parseInt(sc.nextLine());
        for (int i=0; i<soMon; i++) {
            System.out.print("Nhập mã môn thứ " + (i+1) + ": ");
            int maMon = Integer.parseInt(sc.nextLine());
            MonHoc monDangKy = null;
            for (int j = 0; j<cntMonHoc; j++) {
                if (dsMonHoc[j].getMaMH() == maMon) {
                    monDangKy = dsMonHoc[j];
                }
            }
            if (monDangKy == null) {
                System.out.println("Không tìm thấy môn học!");
                continue;
            }
            System.out.print("Nhập số lớp muốn đăng ký: ");
            int soLop = Integer.parseInt(sc.nextLine());
            if (!qlGiangDay.dangKy(monDangKy, soLop)) System.out.println("Đăng ký không thành công!");
            else System.out.println("Đăng ký thành công!");
        }
    }

    public static void inBangKeKhai() {
        System.out.println("Danh sách kê khai giảng dạy: ");
        for (int i=0; i<cntQLGiangDay; i++) System.out.println(qlGiangDays[i]);
    }

    public static void sapXepTheoTen() {
        for (int i=0; i<cntQLGiangDay-1; i++) {
            for (int j=i+1; j<cntQLGiangDay; j++) {
                if (qlGiangDays[i].getGiangVien().getHoTen().compareToIgnoreCase(qlGiangDays[j].getGiangVien().getHoTen()) < 0) {
                    QLGiangDay temp = qlGiangDays[i];
                    qlGiangDays[i] = qlGiangDays[j];
                    qlGiangDays[j] = temp;
                }
            }
        }
        System.out.println("Danh sách kê khai sắp xếp theo họ tên giảng viên:");
        inBangKeKhai();
    }

    public static void sapXepTheoSoTiet() {
        for (int i=0; i<cntQLGiangDay-1; i++) {
            for (int j=i+1; j<cntQLGiangDay; j++) {
                if (qlGiangDays[i].getTotal() < qlGiangDays[j].getTotal()) {
                    QLGiangDay temp = qlGiangDays[i];
                    qlGiangDays[i] = qlGiangDays[j];
                    qlGiangDays[j] = temp;
                }
            }
        }
        System.out.println("Danh sách kê khai sắp xếp theo số tiết giảng dạy mỗi môn (giảm dần):");
        inBangKeKhai();
    }

    public static void bangTinhCong() {
        System.out.println("Bảng tính công giảng viên: ");

        for (int i = 0; i < cntQLGiangDay; i++) {
            System.out.println(qlGiangDays[i].getGiangVien().getMaGV() + " " + qlGiangDays[i].getGiangVien().getHoTen() + " " + qlGiangDays[i].getLuong());
        }
    }
}