import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    private static ArrayList<Employee> emloyeeList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private static ArrayList<ChamCong> congList = new ArrayList<>();

    public Manager() {
    }

    // thêm nhân viên mới
    public void addEmployee() {

            System.out.println("Mời bạn nhập thông tin nhân viên: ");
            Scanner thongtin = new Scanner(System.in);
            System.out.println("Mời bạn nhập id nhân viên: ");
            String id ;
        do {
            id = thongtin.next();
            if(!checkId(id))
                System.out.println("ID nhân viên đã tồn tại mời nhập lại");
            continue;
        }while (!checkId(id));
            System.out.println("tuổi nhân viên: ");
            int age = thongtin.nextInt() ;
            System.out.println("Mời bạn nhâp tên nhân viên: ");
            String name = thongtin.nextLine();
            System.out.println("địa chỉ: ");
            String address = thongtin.nextLine();
            System.out.println("giới tính: ");
            String gender = thongtin.nextLine();
            System.out.println("số điện thoại: ");
            String phone = thongtin.nextLine();
            System.out.println("email: ");
            String email ;
        do {
            email = thongtin.next();
            if(!checkEmail(email))
                System.out.println("Email nhân viên đã tồn tại mời nhập lại");
            continue;
        }while (!checkEmail(email));
            Employee employee = new Employee(id, name, age, address, gender, phone, email);
            emloyeeList.add(employee);
        }


    // xem thông tin
    public  void showEmployee() {
        System.out.println(emloyeeList + "\n");
    }


    // sửa thông tin theo id
    public void editEmployee(String id) {
        int i = 0;
        for (Employee edit : emloyeeList
        ) {
            if (edit.getId().equals(id)) {
                System.out.println("Nhập Id mới: ");
                Scanner newInput = new Scanner(System.in);
                String newId = newInput.nextLine();
                edit.setId(newId);
                System.out.println("Nhập tên mới: ");
                String newName = newInput.nextLine();
                edit.setName(newName);
                System.out.println("Nhập tuổi: ");
                int newAge = newInput.nextInt();
                edit.setAge(newAge);
                System.out.println("Nhập địa chỉ: ");
                String newAddress = newInput.nextLine();
                edit.setAddress(newAddress);
                System.out.println("Nhập giới tính: ");
                String newGender = newInput.nextLine();
                edit.setGender(newGender);
                System.out.println("Nhập số điện thoại : ");
                String newPhone = newInput.nextLine();
                edit.setPhone(newPhone);
                System.out.println("Nhập email: ");
                String newEmail = newInput.nextLine();
                edit.setEmail(newEmail);
                System.out.println("Đã xong");
                i++;
            }
            if (i == 0) {
                System.out.println("Sửa không thành công: ");
            }
        }
    }

    // xóa
    public void deleteEmployee(String id) {
        for (int i = 0; i < emloyeeList.size(); i++) {
            if (emloyeeList.get(i).getId().equals(id)) {
                emloyeeList.remove(i);
            }
        }
    }

    // Quản lý chấm công
    public void managerEmployee(String id) {
        for (int i = 0; i < emloyeeList.size(); i++) {
            if (emloyeeList.get(i).getId().equals(id)) {
                boolean loop = true;
                while (loop) {
                    System.out.println("Chọn tính năng \n" +
                            "1. Thêm Nhân viên:  \n" +
                            "2. Tìm nhân viên theo Id: \n" +
                            "3. Sửa thông tin nhân viên: \n" +
                            "4. Xóa thông tin nhân viên: \n" +
                            "5. Chấm công cho nhân viên \n" +
                            "6. Chốt công \n" +
                            "7. Thoát");
                    int choose = sc.nextInt();
                    switch (choose) {
                        case 1:
                            addEmployee();
                            break;
                        case 2:
                            findEmployee(id);
                            break;
                        case 3:
                            editEmployee(id);
                            break;
                        case 4:
                            deleteEmployee(id);
                            break;
//                        case 5:
//                            timeSheet();
//                            break;
//                        case 6:
//                            latch();
//                            break;
                        case 7:
                            loop = false;
                            break;
                        default:
                            System.out.println("Hãy chọn lại: ");

                    }
                }
            }
        }
    }

    //tìm nhân viên theo id
    public int findEmployee(String id) {
        for (int i = 0; i < emloyeeList.size(); i++) {
            if (emloyeeList.get(i).equals(id)) {
                System.out.println("thong tin nhân viên:" + emloyeeList.get(i));
                return i;
            }
        }
        return -1;
    }

    //chấm công
    public void timeSheet(String id) {
        int i = 0;
        for (Employee edit : emloyeeList
        ) {
            if (edit.getId().equals(id)) {
                System.out.println("Nhập công: ");
                Scanner newCong = new Scanner(System.in);
                int newCongNgay = newCong.nextInt();
                edit.setCongNV(newCongNgay);
                i++;
            }
        }
    }
    // check công qua id
    public void showCong(String id) {
        for (Employee check : emloyeeList
        ) {
            if (check.getId().equals(id)) {
                for (int i = 0; i < check.getCongNV() ; i++) {
                    int a = ( check.getCongNV() + i);
                    System.out.println("Số công : " +  a);
                }

            }
        }
    }
    private boolean checkId(String id){
        boolean check = true;
        for (Employee checker:emloyeeList
        ) {
            if(checker.getId().equals(id)) check = false;
        }
        return check;
    }
    private boolean checkEmail(String email){
        boolean checkEmail = true;
        for (Employee checker1:emloyeeList
        ) {
            if(checker1.getId().equals(email)) checkEmail = false;
        }
        return checkEmail;
    }
    public void luong(String id) {
        for (Employee tinhLuong: emloyeeList
             ) {
            if(tinhLuong.getId().equals(id)){
                int a = tinhLuong.getCongNV()* 8 *500000;
                System.out.println("Lương của bạn là : " + a+ "Vnđ");
            }
        }
    }
}