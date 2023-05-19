package model;

import java.time.LocalDate;
import java.util.Objects;

public class Ticket {
    private long id;
    private String name;
    private String bienSo;
    private double gia = 5000.0;
    private LocalDate ngayGui;
    private double tongTien;

    public Ticket() {
    }

    public static Ticket parse(String raw) {
        String[] files = raw.split(",");
        long id = Long.parseLong(files[0]);
        String name = files[1];
        String bienSo = files[2];
        double gia = Double.parseDouble(files[3]);
        LocalDate ngayGui = LocalDate.parse(files[4]);
        Ticket ticket = new Ticket()
                .setId(id)
                .setName(name)
                .setBienSo(bienSo)
                .setGia()
                .setNgayGui(ngayGui);
        return ticket;
    }

    public Ticket(long id, String name, String bienSo, double gia, LocalDate ngayGui) {
        this.id = id;
        this.name = name;
        this.bienSo = bienSo;
        this.gia = gia;
        this.ngayGui = ngayGui;
    }

    public long getId() {
        return id;
    }

    public Ticket setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Ticket setName(String name) {
        this.name = name;
        return this;
    }

    public String getBienSo() {
        return bienSo;
    }

    public Ticket setBienSo(String bienSo) {
        this.bienSo = bienSo;
        return this;
    }

    public double getGia() {
        return gia;
    }

    public Ticket setGia() {
        this.gia = gia;
        return this;
    }

    public LocalDate getNgayGui() {
        return ngayGui;
    }

    public Ticket setNgayGui(LocalDate ngayGui) {
        this.ngayGui = ngayGui;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", id, name, bienSo, gia, ngayGui);
    }

}
