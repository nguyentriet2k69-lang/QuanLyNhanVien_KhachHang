import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

interface IQuanLy {
    void Them();
    void Sua();
    void Xoa();
    void TimKiem( String TuKhoa);
    void XemDanhSach();
    void DocFile();
    void GhiFile();
}

class QuanLyNhanVien implements IQuanLy {
    private ArrayList<NhanVien> DSNhanVien= new ArrayList<>();
    private Scanner sc= new Scanner(System.in);

    public QuanLyNhanVien(){}

    @Override
    public void Them(){
        System.out.println("Ma NV: ");
        String MaNV= sc.nextLine();
        System.out.print("Ho Ten: ");
        String HoTen= sc.nextLine();
        System.out.print("SDT: ");
        String SDT= sc.nextLine();
        System.out.print("Dia Chi: ");
        String DiaChi= sc.nextLine();
        System.out.print("Chuc vu: ");
        String ChucVu= sc.nextLine();
        System.out.print("Luong: ");
        double Luong= Double.parseDouble(sc.nextLine());
        DSNhanVien.add(new NhanVien(MaNV, HoTen, SDT, DiaChi, ChucVu, Luong));
    }

    @Override
    public void Sua(){
        System.out.print(" Nhap Ma NV can sua: ");
        String Ma= sc.nextLine();
        boolean ketqua= false;
        for (NhanVien nv: DSNhanVien){
            if (nv.getMaNV().equalsIgnoreCase(Ma)){
                ketqua= true;
                int Choice;
                do {
                    System.out.println(" Chon muc can sua: ");
                    System.out.println(" 1. Ho Ten");
                    System.out.println(" 2. SDT");
                    System.out.println(" 3. Dia Chi");
                    System.out.println(" 4. Chuc Vu");
                    System.out.println(" 5. Luong");
                    System.out.print(" 6. Thoat ");
                    Choice= sc.nextInt();
                    sc.nextLine();
                    switch (Choice){
                        case 1:
                            System.out.print(" Nhap lai Ho Ten: ");
                            nv.setHoTen(sc.nextLine());
                            break;
                        case 2:
                            System.out.print(" Nhap lai SDT: ");
                            nv.setSDT(sc.nextLine());
                            break;
                        case 3:
                            System.out.print(" Nhap lai Dia Chi: ");
                            nv.setDiaChi(sc.nextLine());
                            break;
                        case 4:
                            System.out.println(" Nhap lai Chuc Vu: ");
                            nv.setChucVu(sc.nextLine());
                            break;
                        case 5:
                            System.out.print(" Nhap lai Luong: ");
                            nv.setLuong(Double.parseDouble(sc.nextLine()));
                            break;
                        case 6:
                            System.out.print(" Thoat chinh sua");
                            break;
                        default:
                            System.out.print(" Khong hop le");
                    }
                } while (Choice!=6);
            }
        }
        if (!ketqua){ System.out.print(" Khong tim thay ma");}
    }

    @Override
    public void Xoa(){
        System.out.print(" Nhap Ma NV can xoa: ");
        String Ma= sc.nextLine();
        DSNhanVien.removeIf(nv -> nv.getMaNV().equalsIgnoreCase(Ma));
        System.out.print(" Da Xoa");
    }

    @Override
    public void TimKiem(String TuKhoa){
    boolean found= false;
    for (NhanVien nv: DSNhanVien){
        if (nv.getMaNV().equalsIgnoreCase(TuKhoa)
        || nv.getSDT().equalsIgnoreCase(TuKhoa)
        || nv.getHoTen().toLowerCase().contains(TuKhoa.toLowerCase())
        || nv.getDiaChi().toLowerCase().contains(TuKhoa.toLowerCase())
        || nv.getChucVu().toLowerCase().contains(TuKhoa.toLowerCase())){
            nv.HienThiThongTin();
            found= true;
        }
    }
    if (!found){
        System.out.println("Khong tim thay nhan vien phu hop!");
    }
}

    @Override
    public void XemDanhSach(){
        for (NhanVien nv: DSNhanVien){
            nv.HienThiThongTin();
        }
    }

    @Override
    public void GhiFile(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("NhanVien.txt"))){
            for (NhanVien nv: DSNhanVien){
                bw.write(String.format("%s, %s, %s, %s, %s, %.2f", nv.getMaNV(), nv.getHoTen(), nv.getSDT(), nv.getDiaChi(), nv.getChucVu(), nv.getLuong()));
                bw.newLine();
            }
        } catch (IOException e) {}
    }

    @Override
    public void DocFile(){
        try (BufferedReader br = new BufferedReader(new FileReader("NhanVien.txt"))){
            String Line;
            while ((Line= br.readLine())!= null){
                String[] data= Line.split(",");
                if (data.length==6){
                    String MaNV= data[0];
                    String HoTen = data[1];
                    String SDT = data[2];
                    String DiaChi = data[3];
                    String ChucVu = data[4];
                    double Luong = Double.parseDouble(data[5]);
                    DSNhanVien.add(new NhanVien(MaNV, HoTen, SDT, DiaChi, ChucVu, Luong));
                }
            }
        } catch (IOException e) {}
    }
}

class QuanLyKhachHang implements IQuanLy {
    private ArrayList<KhachHang> DSKhachHang= new ArrayList<>();
    private Scanner sc= new Scanner(System.in);

    public QuanLyKhachHang(){}

    @Override
    public void Them(){
        System.out.println("Ma KH: ");
        String MaKH= sc.nextLine();
        System.out.print("Ho Ten: ");
        String HoTen= sc.nextLine();
        System.out.print("SDT: ");
        String SDT= sc.nextLine();
        System.out.print("Dia Chi: ");
        String DiaChi= sc.nextLine();
        System.out.print("Loai KH: ");
        String LoaiKH= sc.nextLine();
        System.out.print("Diem Tich Luy: ");
        double DiemTichLuy= Double.parseDouble(sc.nextLine());
        DSKhachHang.add(new KhachHang(MaKH, LoaiKH, DiemTichLuy, HoTen, SDT, DiaChi));
    }

    @Override
    public void Sua(){
        System.out.print(" Nhap Ma KH can sua: ");
        String Ma= sc.nextLine();
        boolean ketqua= false;
        for (KhachHang kh: DSKhachHang){
            if (kh.getMaKH().equalsIgnoreCase(Ma)){
                ketqua= true;
                int Choice;
                do {
                    System.out.println(" Chon muc can sua: ");
                    System.out.println(" 1. Ho Ten");
                    System.out.println(" 2. SDT");
                    System.out.println(" 3. Dia Chi");
                    System.out.println(" 4. Loai KH");
                    System.out.println(" 5. Diem Tich Luy");
                    System.out.print(" 6. Thoat ");
                    Choice= sc.nextInt();
                    sc.nextLine();
                    switch (Choice){
                        case 1:
                            System.out.print(" Nhap lai Ho Ten: ");
                            kh.setHoTen(sc.nextLine());
                            break;
                        case 2:
                            System.out.print(" Nhap lai SDT: ");
                            kh.setSDT(sc.nextLine());
                            break;
                        case 3:
                            System.out.print(" Nhap lai Dia Chi: ");
                            kh.setDiaChi(sc.nextLine());
                            break;
                        case 4:
                            System.out.print(" Nhap lai Loai KH: ");
                            kh.setLoaiKH(sc.nextLine());
                            break;
                        case 5:
                            System.out.print(" Nhap lai Diem Tich Luy: ");
                            kh.setDiemTichLuy(Double.parseDouble(sc.nextLine()));
                            break;
                        case 6:
                            System.out.print(" Thoat chinh sua");
                            break;
                        default:
                            System.out.print(" Khong hop le");
                    }
                } while (Choice!=6);       
            }
        }
        if (!ketqua){ System.out.print(" Khong tim thay ma");}
    }

    @Override
    public void Xoa(){
        System.out.print(" Nhap Ma KH can xoa: ");
        String Ma= sc.nextLine();
        DSKhachHang.removeIf(kh -> kh.getMaKH().equalsIgnoreCase(Ma));
        System.out.print(" Da Xoa");
    }

    @Override
    public void TimKiem(String TuKhoa){
    boolean found= false;
    for (KhachHang kh: DSKhachHang){
        if (kh.getMaKH().equalsIgnoreCase(TuKhoa)
        || kh.getSDT().equalsIgnoreCase(TuKhoa)
        || kh.getHoTen().toLowerCase().contains(TuKhoa.toLowerCase())
        || kh.getDiaChi().toLowerCase().contains(TuKhoa.toLowerCase())
        || kh.getLoaiKH().toLowerCase().contains(TuKhoa.toLowerCase())
        || String.valueOf(kh.getDiemTichLuy()).equals(TuKhoa)){
            kh.HienThiThongTin();
            found= true;
        }
    }
    if (!found){
        System.out.println("Khong tim thay khach hang phu hop!");
    }
    }

    @Override
    public void XemDanhSach(){
        for (KhachHang kh: DSKhachHang){
            kh.HienThiThongTin();
        }
    }

    @Override
    public void GhiFile(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("KhachHang.txt"))){
            for (KhachHang kh: DSKhachHang){
                bw.write(String.format("%s, %s, %s, %s, %s, %.2f", kh.getMaKH(), kh.getHoTen(), kh.getSDT(), kh.getDiaChi(), kh.getLoaiKH(), kh.getDiemTichLuy()));
                bw.newLine();
            }
        } catch (IOException e) {}
    }

    @Override
    public void DocFile(){
        try (BufferedReader br = new BufferedReader(new FileReader("KhachHang.txt"))){
            String Line;
            while ((Line= br.readLine())!= null){
                String[] data= Line.split(",");
                if (data.length==6){
                    String MaKH= data[0];
                    String HoTen = data[1];
                    String SDT = data[2];
                    String DiaChi = data[3];
                    String LoaiKH = data[4];
                    double DiemTichLuy = Double.parseDouble(data[5]);
                    DSKhachHang.add(new KhachHang(MaKH, LoaiKH, DiemTichLuy, HoTen, SDT, DiaChi));
                }
            }
        } catch (IOException e) {}
    }
}

