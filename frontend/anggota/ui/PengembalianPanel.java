package assignments.assignment4.frontend.anggota.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.buku.Buku;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;
import assignments.assignment4.frontend.componentTemplate.JButtonTemplate;
import assignments.assignment4.frontend.componentTemplate.JLabelTemplate;
import assignments.assignment4.frontend.componentTemplate.JPanelTemplate;
import assignments.assignment4.frontend.componentTemplate.JTextFieldTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Implementasikan hal-hal yang diperlukan
public class PengembalianPanel extends SistakaPanel {
    private JTextFieldTemplate tanggalPengembalianTextfield;
    private JComboBox<String> daftarBukuDropDown;
    // Menginisiasi array string dengan size 0
    private String[] daftarJudulDanPenulisBuku = new String[0];

    public PengembalianPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        // Mengatur layout (GridBagLayout) dari panel utama
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3,0,0,0);
        // Menginstansiasi semua komponen yang diperlukan, lalu menambahkannya ke dalam panel utama sesuai layout constraints
        JLabelTemplate pengembalianBukuLabel = new JLabelTemplate("Pengembalian Buku", 18);
        gbc.gridy = 0;
        add(pengembalianBukuLabel, gbc);

        JLabelTemplate bukuLabel = new JLabelTemplate("Buku");
        gbc.gridy = 1;
        add(bukuLabel, gbc);

        daftarBukuDropDown = new JComboBox<>(daftarJudulDanPenulisBuku); // Menginisiasi combo box dengan String[] daftarJudulDanPenulisBuku
        gbc.gridy = 2;
        add(daftarBukuDropDown, gbc);

        JLabelTemplate tanggalPeminjamanLabel = new JLabelTemplate("Tanggal Peminjaman (DD/MM/YYYY)");
        gbc.gridy = 3;
        add(tanggalPeminjamanLabel, gbc);

        tanggalPengembalianTextfield = new JTextFieldTemplate();
        gbc.gridy = 4;
        add(tanggalPengembalianTextfield, gbc);

        JPanelTemplate panelBtn = new JPanelTemplate();
        panelBtn.setLayout(new FlowLayout());
        gbc.gridy = 5;
        add(panelBtn, gbc);
        // Membuat dua buah button, lalu menambahkannya ke dalam panelBtn sesuai layout
        JButtonTemplate kembalikanBtn = new JButtonTemplate("Kembalikan");
        panelBtn.add(kembalikanBtn);

        JButtonTemplate kembaliBtn = new JButtonTemplate("Kembali");
        panelBtn.add(kembaliBtn);
        // Menghandle event ketika kembalikan button diklik
        kembalikanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "";
                // Mengambil tanggal pengembalian buku dari textfield
                String tanggalPengembalian = tanggalPengembalianTextfield.getText();
                // Jika belum ada buku yang ditambahkan
                if (daftarJudulDanPenulisBuku.length == 0){
                    // Menampilkan pop up frame dengan message sesuai dengan pesan errornya
                    message = "Silahkan memilih buku!";
                    JOptionPane.showMessageDialog(new JFrame(), message, "Warning", JOptionPane.WARNING_MESSAGE);
                }
                // Jika tanggal peminjaman yang diinput user tidak valid
                else if (!isDateValid(tanggalPengembalian)){
                    // Menampilkan pop up frame dengan message sesuai dengan pesan errornya
                    message = "Tanggal yang dimasukkan harus dalam format DD/MM/YYYY!";
                    JOptionPane.showMessageDialog(new JFrame(), message, "Warning", JOptionPane.WARNING_MESSAGE);
                }
                else{
                    // Mengambil judul dan penulis buku dari buku yang ingin dikembalikan dari textfield
                    String judulDanPenulisBuku = (String) daftarBukuDropDown.getSelectedItem();
                    String judul = judulDanPenulisBuku.substring(0, judulDanPenulisBuku.lastIndexOf("oleh") - 1);
                    String penulis = judulDanPenulisBuku.substring(judulDanPenulisBuku.lastIndexOf("oleh") + 5);
                    // Mencari buku berdasarkan judul dan penulisnya
                    Buku bukuYangInginDikembalikan = SistakaNG.findBuku(judul, penulis);
                    // Menyimpan stok awal buku sebelum kembalikan
                    int stokBukuSebelumDikembalikan = bukuYangInginDikembalikan.getStok();
                    // Menampilkan pop up frame dengan message sesuai dengan pesan yang direturn di method kembalikanBuku
                    message = SistakaNG.kembalikanBuku(bukuYangInginDikembalikan, tanggalPengembalian);
                    JOptionPane.showMessageDialog(new JFrame(), message, "Info", JOptionPane.INFORMATION_MESSAGE);
                    // Mengecek apakah buku berhasil dikembalikan, jika iya, maka kembali ke panel anggota
                    if (stokBukuSebelumDikembalikan != bukuYangInginDikembalikan.getStok()) main.setPanel("anggota");
                    else {refresh();}
                }
            }
        });
        // Menghandle event ketika kembali button diklik
        kembaliBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // Mengubah panel menjadi panel anggota
                main.setPanel("anggota");
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
        // Mengosongkan textfield
        tanggalPengembalianTextfield.setText("");
    }
}
