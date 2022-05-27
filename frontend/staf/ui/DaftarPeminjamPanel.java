package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.buku.Buku;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;
import assignments.assignment4.frontend.componentTemplate.JButtonTemplate;
import assignments.assignment4.frontend.componentTemplate.JLabelTemplate;
import assignments.assignment4.frontend.componentTemplate.JPanelTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// TODO: Implementasikan hal-hal yang diperlukan
public class DaftarPeminjamPanel extends SistakaPanel {
    private JComboBox<String> daftarBukuDropdown;
    private JLabelTemplate detailDaftarPeminjamBuku;
    // Menginisiasi array string dengan size 0
    private String[] daftarJudulDanPenulisBuku = new String[0];
    public DaftarPeminjamPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        // Mengatur layout (GridBagLayout) dari panel utama
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3,0,0,0);
        // Menginstansiasi semua komponen yang diperlukan, lalu menambahkannya ke dalam panel utama sesuai layout constraints
        JLabelTemplate lihatDaftarPeminjamLabel = new JLabelTemplate("Lihat Daftar Peminjam", 18);
        gbc.gridy = 0;
        add(lihatDaftarPeminjamLabel, gbc);

        JLabelTemplate pilihBukuLabel = new JLabelTemplate("Pilih buku");
        gbc.gridy = 1;
        add(pilihBukuLabel, gbc);

        daftarBukuDropdown = new JComboBox<>(daftarJudulDanPenulisBuku); // Menginisiasi combo box dengan String[] daftarJudulDanPenulisBuku
        gbc.gridy = 2;
        add(daftarBukuDropdown, gbc);

        detailDaftarPeminjamBuku = new JLabelTemplate("");
        gbc.gridy = 3;
        add(detailDaftarPeminjamBuku, gbc);

        JPanelTemplate panelBtn = new JPanelTemplate();
        panelBtn.setLayout(new FlowLayout());
        gbc.gridy = 4;
        add(panelBtn, gbc);
        // Membuat dua buah button, lalu menambahkannya ke dalam panelBtn sesuai layout
        JButtonTemplate lihatBtn = new JButtonTemplate("Lihat");
        panelBtn.add(lihatBtn);

        JButtonTemplate kembaliBtn = new JButtonTemplate("Kembali");
        panelBtn.add(kembaliBtn);
        // Menghandle event ketika lihat button diklik
        lihatBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "";
                // Jika belum ada buku yang ditambahkan
                if (daftarJudulDanPenulisBuku.length == 0){
                    message = "Silahkan memilih buku!";
                    JOptionPane.showMessageDialog(new JFrame(), message, "Warning", JOptionPane.WARNING_MESSAGE);
                }
                // Jika sudah ada
                else {
                    // Mengambil semua data terkait buku yang ingin dihapus
                    String judulDanPenulisBuku = (String) daftarBukuDropdown.getSelectedItem();
                    String judul = judulDanPenulisBuku.substring(0, judulDanPenulisBuku.lastIndexOf("oleh") - 1);
                    String penulis = judulDanPenulisBuku.substring(judulDanPenulisBuku.lastIndexOf("oleh") + 5);
                    // Mencari buku tersebut sesuai judul dan penulis buku yang dipilih user
                    Buku bukuYangInginDicari = SistakaNG.findBuku(judul, penulis);
                    // Jika buku yang dicari ada di dalam daftar buku
                    if (bukuYangInginDicari != null){
                        // Mengupdate label menjadi list daftar peminjam dari buku tersebut
                        detailDaftarPeminjamBuku.setText(SistakaNG.daftarPeminjam(bukuYangInginDicari));
                    }
                }
            }
        });
        // Menghandle event ketika kembali button diklik
        kembaliBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // Mengubah panel menjadi panel staf
                main.setPanel("staf");
            }
        });
    }

    @Override
    public void refresh() {
        // TODO: Implementasikan hal-hal yang diperlukan
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
        // Memanggil method static getDaftarJudulDanPenulisBuku yang ada pada class SistakaNG
        daftarJudulDanPenulisBuku = SistakaNG.getDaftarJudulDanPenulisBuku();
        // Mengupdate combobox dengan isi semua judul dan penulis buku yang sudah pernah ditambahkan
        daftarBukuDropdown.setModel(new DefaultComboBoxModel<>(daftarJudulDanPenulisBuku));
        // Mengosongkan textfield
        detailDaftarPeminjamBuku.setText("");
    }
}
