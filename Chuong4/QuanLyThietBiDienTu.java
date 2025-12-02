package Chuong4;

public class QuanLyThietBiDienTu {

    public static void main(String[] args) {
        try {
            Router r = new Router("192.168.1.10", "TP_LINK");
            r.connect();
            r.reboot();

            System.out.println("Lưu trong tham chiếu NetworkDevice");
            NetworkDevice net = r;
            net.connect();
//            net.reboot(); // lỗi, networkdevice không biết hàm reboot()

            System.out.println("Lưu trong tham chiếu Restartable");
            Restartable res = r;
//            res.connect(); //lỗi, restartable không biết hàm connect()
            res.reboot();

        } catch (Exception e) {
            System.out.println("Lỗi thiết bị: " + e.getMessage());
        }
    }
}

abstract class NetworkDevice {

    private String ipAddress;
    private String name;

    public NetworkDevice(String ipAddress, String name) {
        if (ipAddress == null || ipAddress.isEmpty()) {
            throw new IllegalArgumentException("IP không được trống");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Tên thiết bị không được trống");
        }
        this.ipAddress = ipAddress;
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getName() {
        return name;
    }

    public abstract void connect();
}

interface Restartable {

    void reboot();
}

class Router extends NetworkDevice implements Restartable {

    public Router(String ipAddress, String name) {
        super(ipAddress, name);
    }

    @Override
    public void connect() {
        System.out.println("Conneting to Router " + getIpAddress());
    }

    @Override
    public void reboot() {
        System.out.println("Rebooting Router " + getName());
    }
}
