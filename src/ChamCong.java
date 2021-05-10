public class ChamCong extends Employee{
    private int cong;



    public ChamCong(String id, String name, int age, String address, String gender, String phone, String email, int cong) {
        super(id, name, age, address, gender, phone, email);
        this.cong = cong;
    }
    public ChamCong(String id,  String email, int cong) {
        super(id, email,cong);
        this.cong = cong;
    }

    public int getCong() {
        return cong;
    }

    public void setCong(int cong) {
        this.cong = cong;
    }

    @Override
    public void luong() {
         int luong = this.cong *500000;
    }

    @Override
    public String toString() {
        return "ChamCong{" +
                "cong=" + cong +
                '}';
    }
}
