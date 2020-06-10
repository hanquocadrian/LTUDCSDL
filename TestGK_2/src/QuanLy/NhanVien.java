
package QuanLy;

public class NhanVien {
    private int ma;
    private String ten;
    private boolean phai;
    private PhongBan pb;

    public NhanVien() {
        this(0,"",true,new PhongBan());
    }

    public NhanVien(int ma, String ten, boolean phai, PhongBan pb) {
        this.ma = ma;
        this.ten = ten;
        this.phai = phai;
        this.pb = pb;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean isPhai() {
        return phai;
    }

    public String getPhai(){
        return isPhai()?"Nam":"Nữ";
    }
    
    public void setPhai(boolean phai) {
        this.phai = phai;
    }

    public PhongBan getPb() {
        return pb;
    }

    public void setPb(PhongBan pb) {
        this.pb = pb;
    }

    @Override
    public String toString() {
        return "ma=" + ma + ", ten=" + ten + ", phai=" + getPhai() + ", pb=" + pb;
    }
}
