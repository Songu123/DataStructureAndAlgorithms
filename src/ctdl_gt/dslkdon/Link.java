package ctdl_gt.dslkdon;

import java.io.Serializable;

public class Link  implements Serializable {
    private String maSV;
    private String hoTen;
    private double diem;
    private String kq, xl;
    public Link nextLink;

    public Link(String maSV, String hoTen, double diem, String kq, String xl, Link nextLink) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diem = diem;
        this.kq = kq;
        this.xl = xl;
        this.nextLink = nextLink;
    }

    public Link(String maSV, String hoTen, double diem) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diem = diem;
        this.nextLink = null;
    }

    public Link() {
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public String getKq() {
        return kq;
    }

    public void setKq(String kq) {
        this.kq = kq;
    }

    public String getXl() {
        return xl;
    }

    public void setXl(String xl) {
        this.xl = xl;
    }

    public Link getNextLink() {
        return nextLink;
    }

    public void setNextLink(Link nextLink) {
        this.nextLink = nextLink;
    }

    @Override
    public String toString() {
        return "Link{" +
                "maSV='" + maSV + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", diem=" + diem +
                ", kq='" + kq + '\'' +
                ", xl='" + xl + '\'' +
                ", nextLink=" + nextLink +
                '}';
    }
}
