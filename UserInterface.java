import java.util.Scanner;

public class UserInterface {
    public static void tampilkanMenu(){
        System.out.println();
        System.out.println("+===============+");
        System.out.println("| Pilih Menu:   |");
        System.out.println("+---------------+");
        System.out.println("|  [C] : Create |");
        System.out.println("|  [R] : Read   |");
        System.out.println("|  [U] : Update |");
        System.out.println("|  [D] : Delete |");
        System.out.println("|  [X] : Exit   |");
        System.out.println("+===============+");
    }
    public static void main(String[] args) {
        Database db = new Database();
        System.out.println("Aplikasi Simple CRUD TEXT DATABASE");
        while (true){
            tampilkanMenu();
            Scanner sc = new Scanner(System.in);
            System.out.print("Pilih : ");
            String pilihan = sc.nextLine();
            pilihan = pilihan.toUpperCase();

            switch (pilihan){
                case "C":
                    System.out.println("INFO: Anda memilih menu Create");
                    System.out.println("---------------------------------------------------");
                    System.out.println("INPUT DATA BARU");
                    System.out.print("NIM            : ");
                    String nim = sc.nextLine();
                    System.out.print("NAMA MAHASISWA : ");
                    String nama = sc.nextLine();
                    System.out.print("ALAMAT         : ");
                    String alamat = sc.nextLine();
                    System.out.print("SEMESTER       : ");
                    int semester = sc.nextInt();
                    sc.nextLine();
                    System.out.print("SKS            : ");
                    int sks = sc.nextInt();
                    sc.nextLine();
                    System.out.print("IPK            : ");
                    double ipk = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("----------------------------------------------------");
                    boolean status = db.insert(nim,nama,alamat,semester,sks,ipk);
                    if (status==true){
                        System.out.println("DATA BARU BERHASIL DI TAMBAHKAN");
                    }else {
                        System.out.println("NIM "+nim+" sudah ada di DATABASE");
                        System.out.println("GAGAL MENAMBAH DATA BARU");
                    }
                    System.out.println("----------------------------------------------------");
                    break;

                case "R":
                    System.out.println("INFO: Anda memilih menu Read");
                    db.view();
                    break;

                case "U":
                    System.out.println("INFO: Anda memilih menu Update");
                    db.view();
                    System.out.print("Input Key (NIM Mahasiswa yang akan di Update): ");
                    String key = sc.nextLine();
                    int index = db.search(key);
                    if (index >=0 ){
                        System.out.println("Anda akan meng-Update data "+ db.getData().get(index));
                        System.out.println("---------------------------------------------------");
                        System.out.println("INPUT DATA BARU");
                        System.out.print("NIM            : ");
                        nim = sc.nextLine();
                        System.out.print("NAMA MAHASISWA : ");
                        nama = sc.nextLine();
                        System.out.print("ALAMAT         : ");
                        alamat = sc.nextLine();
                        System.out.print("SEMESTER       : ");
                        semester = sc.nextInt();
                        sc.nextLine();
                        System.out.print("SKS            : ");
                        sks = sc.nextInt();
                        sc.nextLine();
                        System.out.print("IPK            : ");
                        ipk = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("----------------------------------------------------");
                        status = db.update(index,nim,nama,alamat,semester,sks,ipk);
                        if (status==true){
                            System.out.println("DATA BERHASIL DI PERBAHARUI");
                        }else{
                            System.err.println("GAGAL MEMPERBAHARUI DATA");
                        }
                    }else {
                        System.err.println("Mahasiswa dengan NIM : "+ key + "tidak ada di Database");
                    }
                    break;

                case "D":
                    System.out.println("INFO: Anda memilih menu Delate");
                    db.view();
                    System.out.println("Input key (NIM mahasiswa yang ingin di hapus): ");
                    key = sc.nextLine();
                    index = db.search(key);
                    if (index >=0){
                        System.out.println("APAKAH ANDA YAKIN MENGHAPUS DATA INI "+ db.getData().get(index)+"? Y/N");
                        System.out.print("Pilih : ");
                        pilihan = sc.nextLine();
                        if (pilihan.equalsIgnoreCase("Y")){
                            status = db.delete(index);
                            if (status==true){
                                System.out.println("DATA BERHASIL DI HAPUS");
                            }else {
                                System.err.println("DATA GAGAL DI HAPUS");
                            }
                        }

                    }else {
                        System.err.println("Mahasiswa dengan NIM : "+ key + "tidak ada di Database");
                    }
                    break;

                case "X":
                    System.out.println("INFO: Anda memilih menu EXIT");
                    System.out.println("APAKAH ANDA YAKIN AKAN KELUAR DARI APLIKASI? Y/N");
                    System.out.print("Pilih : ");
                    pilihan = sc.nextLine();
                    if (pilihan.equalsIgnoreCase("Y")){
                        System.exit(0);

                    }
                    break;
            }
        }
    }
}
