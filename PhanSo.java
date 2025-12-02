

public class PhanSo {

    private int tu;
    private int mau;

    public PhanSo() {
        this(0, 1);
    }

    public PhanSo(int tu, int mau) {
        if (mau == 0) {
            throw new IllegalArgumentException("Mẫu số không thể bằng 0");
        }
        this.tu = tu;
        this.mau = mau;
        this.rutGon();
    }

    public int getTu() {
        return tu;
    }

    public void setTu(int tu) {
        this.tu = tu;
        this.rutGon();
    }

    public int getMau() {
        return mau;
    }

    public void setMau(int mau) {
        if (mau == 0) {
            throw new IllegalArgumentException("Mẫu số không thể bằng 0");
        }
        this.mau = mau;
        this.rutGon();
    }

    private int timUCLN(int a, int b) {
        return (b == 0) ? Math.abs(a) : timUCLN(b, a % b);
    }

    public void rutGon() {
        int ucln = timUCLN(this.tu, this.mau);
        
        this.tu /= ucln;
        this.mau /= ucln;

        if (this.mau < 0) {
            this.tu = -this.tu;
            this.mau = -this.mau;
        }
    }

    public PhanSo cong(PhanSo other) {
        int tuMoi = (this.tu * other.mau) + (other.tu * this.mau);
        int mauMoi = this.mau * other.mau;
        return new PhanSo(tuMoi, mauMoi);
    }

    public PhanSo tru(PhanSo other) {
        int tuMoi = (this.tu * other.mau) - (other.tu * this.mau);
        int mauMoi = this.mau * other.mau;
        return new PhanSo(tuMoi, mauMoi);
    }

    public PhanSo nhan(PhanSo other) {
        return new PhanSo(this.tu * other.tu, this.mau * other.mau);
    }

    public PhanSo chia(PhanSo other) {
        if (other.tu == 0) {
            throw new IllegalArgumentException("Không thể chia cho phân số có giá trị 0");
        }
        return new PhanSo(this.tu * other.mau, this.mau * other.tu);
    }

    @Override
    public String toString() {
        if (mau == 1) return String.valueOf(tu);
        return tu + "/" + mau;
    }

}