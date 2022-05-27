package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.buku.Buku;
import assignments.assignment4.backend.buku.Kategori;
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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// TODO: Implementasikan hal-hal yang diperlukan
public class TambahBukuPanel extends SistakaPanel {
    private JTextFieldTemplate judulTextfield, penulisTextfield, penerbitTextfield, stokTextfield;
    private JComboBox<String> daftarKategoriDrowdown;
    // Menginisiasi array string dengan size 0
    private String[] daftarNamaKategori = new String[0];

    public TambahBukuPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        // Mengatur layout (GridBagLayout) dari panel utama
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3,0,0,0);
        // Menginstansiasi semua komponen yang diperlukan, lalu menambahkannya ke dalam panel utama sesuai layout constraints
        JLabelTemplate tambahBukuLabel = new JLabelTemplate("Tambah Buku", 18);
        gbc.gridy = 0;
        add(tambahBukuLabel, gbc);

        JLabelTemplate judulLabel = new JLabelTemplate("Judul");
        gbc.gridy = 1;
        add(judulLabel, gbc);

        judulTextfield = new JTextFieldTemplate();
        gbc.gridy = 2;
        add(judulTextfield, gbc);

        JLabelTemplate penulisLabel = new JLabelTemplate("Penulis");
        gbc.gridy = 3;
        add(penulisLabel, gbc);

        penulisTextfield = new JTextFieldTemplate();
        gbc.gridy = 4;
        add(penulisTextfield, gbc);

        JLabelTemplate penerbitLabel = new JLabelTemplate("Penerbit");
        gbc.gridy = 5;
        add(penerbitLabel, gbc);

        penerbitTextfield = new JTextFieldTemplate();
        gbc.gridy = 6;
        add(penerbitTextfield, gbc);

        daftarKategoriDrowdown = new JComboBox<>(daftarNamaKategori); // Menginisiasi combo box dengan String[] daftarNamaKategori
        gbc.gridy = 7;
        add(daftarKategoriDrowdown, gbc);

        JLabelTemplate stokLabel = new JLabelTemplate("Stok");
        gbc.gridy = 8;
        add(stokLabel, gbc);

        stokTextfield = new JTextFieldTemplate();
        gbc.gridy = 9;
        add(stokTextfield, gbc);

        JPanelTemplate panelBtn = new JPanelTemplate();
        panelBtn.setLayout(new FlowLayout());
        gbc.gridy = 10;
        add(panelBtn, gbc);
        // Membuat dua buah button, lalu menambahkannya ke dalam panelBtn sesuai layout
        JButtonTemplate tambahBtn = new JButtonTemplate("Tambah");
        panelBtn.add(tambahBtn);

        JButtonTemplate kembaliBtn = new JButtonTemplate("Kembali");
        panelBtn.add(kembaliBtn);
        // Menghandle event ketika tambah button diklik
        tambahBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "";
                // Mengecek apakah ada textfield yang kosong
                if (SistakaPanel.isTextfieldEmpty(judulTextfield, penulisTextfield, penerbitTextfield, stokTextfield)){
                    // Menampilkan pop up frame dengan message sesuai dengan pesan errornya
                    message = String.format("Textfield tidak boleh kosong!");
                    JOptionPane.showMessageDialog(new JFrame(), message, "Warning", JOptionPane.WARNING_MESSAGE);
                    refresh();
                }
                // Jika input stok buku bukan merupakan angka
                else if (!isNumeric(stokTextfield.getText())){
                    // Menampilkan pop up frame dengan message sesuai dengan pesan errornya
                    message = "Stok harus berupa angka lebih dari 0!";
                    JOptionPane.showMessageDialog(new JFrame(), message, "Warning", JOptionPane.WARNING_MESSAGE);
                    refresh();
                }
                else {
                    // Mengambil semua data terkait kategori yang ingin ditambahkan
                    String judul = judulTextfield.getText();
                    String penulis = penulisTextfield.getText();
                    String penerbit = penerbitTextfield.getText();
                    int stok = Integer.parseInt(stokTextfield.getText());
                    String namaKategori = (String) daftarKategoriDrowdown.getSelectedItem();
                    // Memanggil method addBuku
                    Buku bukuYangInginDitambahkan= SistakaNG.addBuku(judul, penulis, penerbit, namaKategori, stok);
                    // Jika stok buku yang diinput kurang dari atau sama dengan 0
                    if (stok <= 0){
                        // Menampilkan pop up frame dengan message sesuai dengan pesan errornya
                        message = "Stok harus lebih dari 0!";
                        JOptionPane.showMessageDialog(new JFrame(), message, "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    // Jika buku yang ingin ditambahkan sudah pernah ditambahkan
                    else if (bukuYangInginDitambahkan == null){
                        // Mencari buku yang sudah pernah ditambahkan tersebut
                        Buku bukuSudahDitambahkan = SistakaNG.findBuku(judul, penulis);
                        // Menampilkan pop up frame dengan message sesuai dengan pesan errornya
                        message = String.format("Buku %s sudah pernah ditambahkan", bukuSudahDitambahkan);
                        JOptionPane.showMessageDialog(new JFrame(), message, "Warning", JOptionPane.WARNING_MESSAGE);
                        refresh();
                    }
                    // Jika buku berhasil ditambah
                    else{
                        // Menampilkan pop up frame dengan message sesuai dengan pesan berhasilnya
                        message = String.format("Buku %s berhasil ditambahkan!", bukuYangInginDitambahkan);
                        JOptionPane.showMessageDialog(new JFrame(), message, "Success!", JOptionPane.INFORMATION_MESSAGE);
                        // Mengubah panel menjadi panel staf
                        main.setPanel("staf");
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
        // Memanggil method static getDaftarNamaKategori yang ada pada class SistakaNG
        daftarNamaKategori = SistakaNG.getDaftarNamaKategori();
        // Mengupdate combobox dengan isi semua nama kategori yang sudah pernah ditambahkan
        daftarKategoriDrowdown.setModel(new DefaultComboBoxModel<>(daftarNamaKategori));
        // Mengosongkan semua textfield
        judulTextfield.setText("");
        penulisTextfield.setText("");
        penerbitTextfield.setText("");
        stokTextfield.setText("");
    }


}
