
public abstract class ConNguoi {
    private String HoTen;
    private String SDT;
    private String DiaChi;

    public ConNguoi() {}
    public ConNguoi(String HoTen, String SDT, String DiaChi) {
        this.HoTen = HoTen;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
    }
    public String getHoTen() { return HoTen;}
    public void setHoTen(String HoTen) { this.HoTen = HoTen;}
    public String getSDT() { return SDT;}
    public void setSDT(String SDT) { this.SDT = SDT;}
    public String getDiaChi() { return DiaChi;}
    public void setDiaChi(String DiaChi) { this.DiaChi = DiaChi;}
    public abstract void HienThiThongTin();
} 

class NhanVien extends ConNguoi {
    private String MaNV;
    private String ChucVu;
    private double Luong;
    private static int SoLuongNV = 0;

    NhanVien() {
        SoLuongNV++;
    }
    NhanVien(String MaNV, String HoTen, String SDT, String DiaChi, String ChucVu, double Luong){
        super(HoTen, SDT, DiaChi);
        this.MaNV= MaNV;
        this.ChucVu= ChucVu;
        this.Luong= Luong;
        SoLuongNV++;
    }
    public String getMaNV(){ return MaNV;}
    public void setMaNV(String MaNV){ this.MaNV= MaNV; }
    public String getChucVu(){ return ChucVu;}
    public void setChucVu(String ChucVu){ this.ChucVu= ChucVu; }
    public double getLuong(){ return Luong;}
    public void setLuong(double Luong){ this.Luong= Luong; }
    public static int getSoLuongNV(){ return SoLuongNV; }

    @Override
    public void HienThiThongTin(){
        System.out.println("Ma NV: " + MaNV);
        System.out.println("Ho Ten " + getHoTen());
        System.out.println("SDT: " + getSDT());
        System.out.println(" Dia Chi: "+ getDiaChi());
        System.out.println(" Chuc Vu: "+ ChucVu);
        System.out.println(" Luong: "+ Luong);
        System.out.println("-------------------");
    }
}

class KhachHang extends ConNguoi {
    private String MaKH;
    private String LoaiKH;
    private double DiemTichLuy;
    private static int SoLuongKH=0;
    
    public KhachHang(){ SoLuongKH++;}

    public KhachHang(String MaKH, String LoaiKH, double DiemTichLuy, String HoTen, String SDT, String DiaChi){
        super(HoTen, SDT, DiaChi);
        this.MaKH= MaKH;
        this.DiemTichLuy= DiemTichLuy;
        this.LoaiKH= LoaiKH;
        SoLuongKH++;
    }

    public String getMaKH(){ return MaKH;}
    public void setMaKH(String MaKH){ this.MaKH= MaKH;}
    public String getLoaiKH(){ return LoaiKH;}
    public void setLoaiKH(String LoaiKH){ this.LoaiKH= LoaiKH;}
    public double getDiemTichLuy(){ return DiemTichLuy;}
    public void setDiemTichLuy(double DiemTichLuy){ this.DiemTichLuy= DiemTichLuy;}
    public static int getSoLuongKH(){ return SoLuongKH;}

    @Override
    public void HienThiThongTin(){
        System.out.println("Ma KH: " + MaKH);
        System.out.println("Ho Ten " + getHoTen());
        System.out.println("SDT: " + getSDT());
        System.out.println(" Dia Chi: "+ getDiaChi());
        System.out.println(" Loai KH: "+ LoaiKH);
        System.out.println(" Diem Tich Luy: "+ DiemTichLuy);
        System.out.println("-------------------");
    }
}

