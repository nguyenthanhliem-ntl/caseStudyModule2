public class FulltimeEmloyee  extends Employee {
    private int luongCung;
    private int tienThuong;
    private int tienPhat;

    public FulltimeEmloyee(int luongCung, int tienThuong, int tienPhat, String cong, int email, String id) {
        super(id, cong, email);
        this.luongCung = luongCung;
        this.tienThuong = tienThuong;
        this.tienPhat = tienPhat;
    }

    public int getLuongCung() {
        return luongCung;
    }

    public void setLuongCung(int luongCung) {
        this.luongCung = luongCung;
    }

    public int getTienThuong() {
        return tienThuong;
    }

    public void setTienThuong(int tienThuong) {
        this.tienThuong = tienThuong;
    }

    public int getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(int tienPhat) {
        this.tienPhat = tienPhat;
    }

    public FulltimeEmloyee(String id, String email, int cong) {
        super(id, email, cong);
    }

    @Override
    public void luong() {
        int luong = this.getLuongCung() + this.getTienThuong()- this.getTienPhat();
          }
}
