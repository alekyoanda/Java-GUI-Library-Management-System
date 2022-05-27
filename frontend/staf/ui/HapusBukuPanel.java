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
public class HapusBukuPanel extends SistakaPanel {
    private JComboBox<String> daftarBukuDropDown;
    // Menginisiasi array string dengan size 0
    private String[] daftarJudulDanPenulisBuku = new String[0];

    public HapusBukuPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        // Mengatur layout (GridBagLayout) dari panel utama
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3,0,0,0);
        // Menginstansiasi semua komponen yang diperlukan, lalu menambahkannya ke dalam panel utama sesuai layout constraints
        JLabelTemplate hapusBukuLabel = new JLabelTemplate("Hapus Buku", 18);
        gbc.gridy = 0;
        add(hapusBukuLabel, gbc);

        JLabelTemplate bukuLabel = new JLabelTemplate("Buku");
        gbc.gridy = 1;
        add(bukuLabel, gbc);

        daftarBukuDropDown = new JComboBox<>(daftarJudulDanPenulisBuku); // Menginisiasi combo box dengan String[] daftarJudulDanPenulisBuku
        gbc.gridy = 2;
        add(daftarBukuDropDown, gbc);

        JPanelTemplate panelBtn = new JPanelTemplate();
        panelBtn.setLayout(new FlowLayout());
        gbc.gridy = 3;
        add(panelBtn, gbc);
        // Membuat dua buah button, lalu menambahkannya ke dalam panelBtn sesuai layout
        JButtonTemplate hapusBtn = new JButtonTemplate("Hapus");
        panelBtn.add(hapusBtn);

        JButtonTemplate kembaliBtn = new JButtonTemplate("Kembali");
        panelBtn.add(kembaliBtn);
        // Menghandle event ketika hapus button diklik
        hapusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message;
                // Jika belum ada buku yang ditambahkan
                if (daftarJudulDanPenulisBuku.length == 0){
                    // Menampilkan pop up frame dengan message sesuai dengan pesan errornya
                    message = "Silahkan memilih buku!";
                    JOptionPane.showMessageDialog(new JFrame(), message, "Warning", JOptionPane.WARNING_MESSAGE);
                }
                // Jika sudah ada
                else {
                    // Mengambil semua data terkait buku yang ingin dihapus
                    String judulDanPenulisBuku = (String) daftarBukuDropDown.getSelectedItem();
                    String judul = judulDanPenulisBuku.substring(0, judulDanPenulisBuku.lastIndexOf("oleh") - 1);
                    String penulis = judulDanPenulisBuku.substring(judulDanPenulisBuku.lastIndexOf("oleh") + 5);
                    // Mencari buku yang ingin dihapus tersebut sesuai judul dan penulis buku yang dipilih user
                    Buku bukuYangInginDihapus = SistakaNG.findBuku(judul, penulis);
                    // Menampilkan pop up frame dengan message sesuai dengan return value dari method deleteBuku
                    message = SistakaNG.deleteBuku(bukuYangInginDihapus);
                    JOptionPane.showMessageDialog(new JFrame(), message, "Info", JOptionPane.INFORMATION_MESSAGE);
                    // Jika buku berhasil terhapus, maka ubah panel menjadi panel staf
                    if (SistakaNG.findBuku(judul, penulis) == null) main.setPanel("staf");
                }
            }
        });

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
        daftarBukuDropDown.setModel(new DefaultComboBoxModel<>(daftarJudulDanPenulisBuku));
    }


}
