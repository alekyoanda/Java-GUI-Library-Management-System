package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;
import assignments.assignment4.frontend.componentTemplate.JButtonTemplate;
import assignments.assignment4.frontend.componentTemplate.JLabelTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Implementasikan hal-hal yang diperlukan
public class StafHomePanel extends SistakaPanel {
    private JLabelTemplate welcomeStafLabel;
    @Override
    public void refresh() {
        // TODO: Implementasikan hal-hal yang diperlukan
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
        // Mengupdate text pada label
        welcomeStafLabel.setText(String.format("Selamat datang kembali %s!", main.getUser().getNama()));
    }

    public StafHomePanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        // Mengatur layout (GridLayout) dari panel utama
        setLayout(new GridLayout(10, 1, 5,5));
        // Membuat semua komponen yang diperlukan
        welcomeStafLabel = new JLabelTemplate("", 18);
        JButtonTemplate tambahMahasiswaBtn = new JButtonTemplate("Tambah Mahasiswa");
        JButtonTemplate tambahDosenBtn = new JButtonTemplate("Tambah Dosen");
        JButtonTemplate tambahKategoriBtn = new JButtonTemplate("Tambah Kategori");
        JButtonTemplate tambahBukuBtn = new JButtonTemplate("Tambah Buku");
        JButtonTemplate hapusBukuBtn = new JButtonTemplate("Hapus Buku");
        JButtonTemplate tigaPeringkatPertamaBtn = new JButtonTemplate("3 Peringkat Pertama");
        JButtonTemplate detailAnggotaBtn = new JButtonTemplate("Detail Anggota");
        JButtonTemplate daftarPeminjamBukuBtn = new JButtonTemplate("Daftar Peminjam Buku");
        JButtonTemplate logoutBtn = new JButtonTemplate("Logout");
        // Menambah semua komponen tersebut ke dalam panel utama
        add(welcomeStafLabel);
        add(tambahMahasiswaBtn);
        add(tambahDosenBtn);
        add(tambahKategoriBtn);
        add(tambahBukuBtn);
        add(hapusBukuBtn);
        add(tigaPeringkatPertamaBtn);
        add(detailAnggotaBtn);
        add(daftarPeminjamBukuBtn);
        add(logoutBtn);
        tambahMahasiswaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // Mengubah panel menjadi panel untuk menambah mahasiswa
                main.setPanel("tambahMhs");
            }
        });
        // Menghandle event ketika tambah dosen button diklik
        tambahDosenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // Mengubah panel menjadi panel untuk menambah dosen
                main.setPanel("tambahDosen");
            }
        });
        // Menghandle event ketika tambah kategori button diklik
        tambahKategoriBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // Mengubah panel menjadi panel untuk menambah kategori
                main.setPanel("tambahKategori");
            }
        });
        // Menghandle event ketika tambah buku button diklik
        tambahBukuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // Mengubah panel menjadi panel untuk menambah buku
                main.setPanel("tambahBuku");
            }
        });
        // Menghandle event ketika hapus buku button diklik
        hapusBukuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // Mengubah panel menjadi panel untuk menghapus buku
                main.setPanel("hapusBuku");
            }
        });
        // Menghandle event ketika tiga peringkat pertama button diklik
        tigaPeringkatPertamaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // Mengubah panel menjadi panel untuk menampilkan 3 peringkat anggota pertama
                main.setPanel("peringkat");
            }
        });
        // Menghandle event ketika detail anggota button diklik
        detailAnggotaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // Mengubah panel menjadi panel untuk menampilkan detail anggota
                main.setPanel("detailAnggota");
            }
        });
        // Menghandle event ketika daftar peminjam buku button diklik
        daftarPeminjamBukuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // Mengubah panel menjadi panel untuk menampilkan daftar peminjam buku
                main.setPanel("daftarPeminjam");
            }
        });
        // Menghandle event ketika logout button diklik
        logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // Mengubah panel menjadi panel untuk welcome kembali
                main.setPanel("welcome");
            }
        });
    }

}
