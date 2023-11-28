package doan;

import java.util.*;
import java.io.*;

interface IThem {
    public void them();
}

interface IXuat {
    public void xuat();
}

interface IXoa {
    public void xoa();
}

interface ISua {
    public void sua();
}

interface ITimkiem {
    public void timkiem();
}

public class maytinh {
    public static void main(String args[]) {
        Scanner rd = new Scanner(System.in);
        DSPC pc = new DSPC();
        pc.dataread();
        int menu;
        do {
            clear();
            System.out.print("MENU\n1. Them pc\n2. Xuat danh sach pc\n3. Tim kiem\n4. Xoa\n5. Sua\n0. Thoat\nChon: ");
            menu = rd.nextInt();
            switch (menu) {
                case 1:
                    pc.them();
                    break;
                case 2:
                    pc.xuat();
                    break;
                case 3:
                    pc.timkiem();
                    break;
                case 4:
                    pc.xoa();
                    break;
                case 5:
                    pc.sua();
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (menu != 0);
        pc.datawrite();
        rd.close();
    }

    static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

class DSPC implements IThem, ISua, ITimkiem, IXoa, IXuat {
    int soluong;
    PC[] ds;

    public DSPC() {
        ds = new PC[0];
        soluong = 0;
    }

    public DSPC(int soluong, PC[] ds) {
        this.ds = ds;
        this.soluong = soluong;
    }

    public void them() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        ds = Arrays.copyOf(ds, soluong + 1);
        ds[soluong] = new PC();
        ds[soluong].nhap();
        soluong++;
    }

    public void xuat() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int i = 0; i < soluong; i++) {
            System.out.println("STT " + (i + 1));
            ds[i].xuat();
            System.out.println();
        }
        Scanner rd = new Scanner(System.in);
        System.out.println("Nhan ENTER de tiep tuc");
        rd.nextLine();
    }

    public void timkiem() {
        Scanner rd = new Scanner(System.in);
        int menu;
        do {
            System.out.print("\033[H\033[2J");
            System.out.print("Tim kiem theo:\n1. Id\n2. CPU\n3. GPU\n0. Thoat\nChon: ");
            menu = rd.nextInt();
            int count;
            switch (menu) {
                case 1:// ID
                    System.out.print("\033[H\033[2J");
                    System.out.print("Nhap id can tim: ");
                    int id = rd.nextInt();
                    count = 0;
                    for (int i = 0; i < soluong; i++) {
                        if (ds[i].getid() == id) {
                            count++;
                            ds[i].xuat();
                        }
                    }
                    if (count == 0) {
                        System.out.println("Khong tim thay id=" + id);
                        System.out.println("Nhan ENTER de tiep tuc");
                        rd.nextLine();
                        rd.nextLine();
                    } else {
                        System.out.println("Nhan ENTER de tiep tuc");
                        rd.nextLine();
                        rd.nextLine();
                    }
                    break;
                case 2:// CPU
                    System.out.print("\033[H\033[2J");
                    System.out.print("Nhap ten cpu can tim: ");
                    rd.nextLine();
                    String cpu = rd.nextLine();
                    count = 0;
                    for (int i = 0; i < soluong; i++) {
                        if (ds[i].getcpu().equals(cpu)) {
                            count++;
                            ds[i].xuat();
                        }
                    }
                    if (count == 0) {
                        System.out.println("Khong tim thay cpu=" + cpu);
                        System.out.println("Nhan ENTER de tiep tuc");
                        rd.nextLine();
                    } else {
                        System.out.println("Nhan ENTER de tiep tuc");
                        rd.nextLine();
                    }
                    break;
                case 3:// GPU
                    System.out.print("\033[H\033[2J");
                    System.out.print("Nhap ten gpu can tim: ");
                    rd.nextLine();
                    String gpu = rd.nextLine();
                    count = 0;
                    for (int i = 0; i < soluong; i++) {
                        if (ds[i].getgpu().equals(gpu)) {
                            count++;
                            ds[i].xuat();
                        }
                    }
                    if (count == 0) {
                        System.out.println("Khong tim thay cpu=" + gpu);
                        System.out.println("Nhan ENTER de tiep tuc");
                        rd.nextLine();
                    } else {
                        System.out.println("Nhan ENTER de tiep tuc");
                        rd.nextLine();
                    }
                    break;
                default:
                    break;
            }
        } while (menu != 0);
    }

    public void xoa() {
        Scanner rd = new Scanner(System.in);
        int menu;
        do {
            System.out.print("\033[H\033[2J");
            System.out.print("Xoa theo:\n1. Id\n2. CPU\n3. GPU\n0. Thoat\nChon: ");
            menu = rd.nextInt();
            int count;
            switch (menu) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.print("Nhap id can xoa: ");
                    int id = rd.nextInt();
                    count = 0;
                    for (int i = 0; i < soluong; i++) {
                        if (ds[i].getid() == id) {
                            count++;
                            for (int j = i; j < soluong - 1; j++) {
                                ds[j] = ds[j + 1];
                            }
                            soluong--;
                            ds = Arrays.copyOf(ds, soluong);
                        }
                    }
                    if (count == 0) {
                        System.out.println("Khong tim thay id=" + id + " de xoa");
                        System.out.println("Nhan ENTER de tiep tuc");
                        rd.nextLine();
                        rd.nextLine();
                    } else {
                        System.out.println("Xoa thanh cong\nNhan ENTER de tiep tuc");
                        rd.nextLine();
                        rd.nextLine();
                    }
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.print("Nhap ten cpu can xoa: ");
                    rd.nextLine();
                    String cpu = rd.nextLine();
                    count = 0;
                    for (int i = 0; i < soluong; i++) {
                        if (ds[i].getcpu().equals(cpu)) {
                            count++;
                            for (int j = i; j < soluong - 1; j++) {
                                ds[j] = ds[j + 1];
                            }
                            soluong--;
                            ds = Arrays.copyOf(ds, soluong);
                        }
                    }
                    if (count == 0) {
                        System.out.println("Khong tim thay cpu=" + cpu + " de xoa");
                        System.out.println("Nhan ENTER de tiep tuc");
                        rd.nextLine();
                    } else {
                        System.out.println("Xoa thanh cong\nNhan ENTER de tiep tuc");
                        rd.nextLine();
                    }
                    break;
                // case 3:
                // pc.timkiem();
                // break;
                // case 4:
                // pc.xoa();
                // break;
                // case 0:
                // break;
                default:
                    break;
            }
        } while (menu != 0);
    }

    public void sua() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner rd = new Scanner(System.in);
        for (int i = 0; i < soluong; i++) {
            System.out.println("STT " + (i + 1));
            ds[i].xuat();
            System.out.println();
        }
        System.out.println("Chon stt pc can chinh sua: ");
        String stt = rd.nextLine();
        String menu;
        do {
            System.out.print("\033[H\033[2J");
            ds[Integer.valueOf(stt)-1].xuat();
            System.out.print("Sua theo:\n");
            System.out.print("1. Id\n2. CPU\n3. GPU\n4. Ram\n5. Storage\n6. Tat ca\n0. Thoat\nChon: ");
            menu = rd.nextLine();
            switch (menu) {
                case "1":
                    System.out.print("Nhap id moi: ");
                    ds[Integer.valueOf(stt)-1].setid(Integer.valueOf(rd.nextLine()));    
                    break;
                case "2":
                    System.out.print("Nhap CPU moi: ");
                    ds[Integer.valueOf(stt)-1].setcpu(rd.nextLine());                    
                    break;
                case "3":
                    System.out.print("Nhap gpu moi: ");
                    ds[Integer.valueOf(stt)-1].setgpu(rd.nextLine());
                    break;
                case "4":
                    System.out.print("Nhap ram moi: ");
                    ds[Integer.valueOf(stt)-1].setram(rd.nextLine());
                    break;
                case "5":
                    System.out.print("Nhap storage moi: ");
                    ds[Integer.valueOf(stt)-1].setstorage(rd.nextLine());
                    break;
                case "6":
                    ds[Integer.valueOf(stt)-1].nhap();
                    break;
                default:
                    break;
            }
        } while (Integer.valueOf(menu) != 0);
    }

    public void datawrite() {
        try {
            FileWriter fw = new FileWriter("doan\\data.txt");
            String write = "";
            for (int i = 0; i < soluong; i++) {
                write = write + ds[i].getid() + ",";
                write = write + ds[i].getcpu() + ",";
                write = write + ds[i].getgpu() + ",";
                write = write + ds[i].getram() + ",";
                write = write + ds[i].getstorage() + "\n";
            }
            fw.write(write);
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void dataread() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("doan\\data.txt"));
            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split(",");
                ds = Arrays.copyOf(ds, soluong + 1);
                ds[soluong] = new PC();
                ds[soluong].setid(Integer.valueOf(arr[0]));
                ds[soluong].setcpu(arr[1]);
                ds[soluong].setgpu(arr[2]);
                ds[soluong].setram(arr[3]);
                ds[soluong].setstorage(arr[4]);
                soluong++;
                line = br.readLine();
            }
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class PC implements IXuat{
    private int id;
    private String cpu;
    private String gpu;
    private String ram;
    private String storage;

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getcpu() {
        return cpu;
    }

    public void setcpu(String cpu) {
        this.cpu = cpu;
    }

    public String getgpu() {
        return gpu;
    }

    public void setgpu(String gpu) {
        this.gpu = gpu;
    }

    public String getram() {
        return ram;
    }

    public void setram(String ram) {
        this.ram = ram;
    }

    public String getstorage() {
        return storage;
    }

    public void setstorage(String storage) {
        this.storage = storage;
    }

    public PC() {
        id = -1;
        cpu = gpu = ram = storage = "";
    }

    public PC(int id, String cpu, String gpu, String ram, String storage) {
        this.id = id;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.storage = storage;
    }

    public void nhap() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner rd = new Scanner(System.in);
        System.out.print("Nhap id: ");
        id = rd.nextInt();
        rd.nextLine();
        System.out.print("Nhap ten cpu: ");
        cpu = rd.nextLine();
        System.out.print("Nhap ten gpu: ");
        gpu = rd.nextLine();
        System.out.print("Nhap ram: ");
        ram = rd.nextLine();
        System.out.print("Nhap storage: ");
        storage = rd.nextLine();
    }

    public void xuat() {
        Scanner rd = new Scanner(System.in);
        System.out.println("Id: " + id);
        System.out.println("Cau hinh:");
        System.out.println("\tCPU: " + cpu + "\n\tGPU: " + gpu + "\n\tRAM: " + ram + "\n\tStorage: " + storage);
    }
}