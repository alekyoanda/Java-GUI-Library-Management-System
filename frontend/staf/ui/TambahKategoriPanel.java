package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.buku.Kategori;
import assignments.assignment4.backend.pengguna.Anggota;
import assignments.assignment4.backend.pengguna.Dosen;
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
import java.util.List;

// TODO: Implementasikan hal-hal yang diperlukan
public class TambahKategoriPanel extends SistakaPanel {
    private JTextFieldTemplate namaTextfield, poinTextField;
    public TambahKategoriPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        // Mengatur layout (GridBagLayout) dari panel utama
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3,0,0,0);
        // Menginstansiasi semua komponen yang diperlukan, lalu menambahkannya ke dalam panel utama sesuai layout constraints
        JLabelTemplate tambahKategoriLabel = new JLabelTemplate("Tambah Kategori", 18);
        gbc.gridy = 0;
        add(tambahKategoriLabel, gbc);

        JLabelTemplate namaLabel = new JLabelTemplate("Nama");
        gbc.gridy = 1;
        add(namaLabel, gbc);

        namaTextfield = new JTextFieldTemplate();
        gbc.gridy = 2;
        add(namaTextfield, gbc);

        JLabelTemplate poinLabel = new JLabelTemplate("Poin");
        gbc.gridy = 3;
        add(poinLabel, gbc);

        poinTextField = new JTextFieldTemplate();
        gbc.gridy = 4;
        add(poinTextField, gbc);

        JPanelTemplate panelBtn = new JPanelTemplate();
        panelBtn.setLayout(new FlowLayout());
        gbc.gridy = 5;
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
                if (SistakaPanel.isTextfieldEmpty(namaTextfield, poinTextField)){
                    // Menampilkan pop up frame dengan message sesuai dengan pesan errornya
                    message = String.format("Textfield tidak boleh kosong!");
                    JOptionPane.showMessageDialog(new JFrame(), message, "Warning", JOptionPane.WARNING_MESSAGE);
                    // Mengosongkan semua textfield
                    refresh();
                }
                // Jika input poin kategori bukan merupakan angka
                else if (!isNumeric(poinTextField.getText())){
                    // Menampilkan pop up frame dengan message sesuai dengan pesan errornya
                    message = "Poin harus berupa angka!";
                    JOptionPane.showMessageDialog(new JFrame(), message, "Warning", JOptionPane.WARNING_MESSAGE);
                    // Mengosongkan semua textfield
                    refresh();
                }
                else {
                    // Mengambil semua data terkait kategori yang ingin ditambahkan
                    String nama = namaTextfield.getText();
                    int poin = Integer.parseInt(poinTextField.getText());
                    // Memanggil method addKategori
                    Kategori kategoriYangInginDitambahkan= SistakaNG.addKategori(nama, poin);
                    // Jika kategori yang ingin ditambahkan sudah pernah ditambahkan
                    if (kategoriYangInginDitambahkan == null){
                        // Mencari kategori yang sudah pernah ditambahkan tersebut
                        Kategori kategoriSudahDitambahkan = SistakaNG.findKategori(nama);
                        // Menampilkan pop up frame dengan message sesuai dengan pesan errornya
                        message = String.format("Kategori %s sudah pernah ditambahkan!", kategoriSudahDitambahkan.getNama());
                        JOptionPane.showMessageDialog(new JFrame(), message, "Warning", JOptionPane.WARNING_MESSAGE);
                        // Mengosongkan semua textfield
                        refresh();
                    }
                    // Jika kategori berhasil ditambahkan
                    else{
                        // Menampilkan pop up frame dengan message sesuai dengan pesan berhasilnya
                        message = String.format("Kategori %s dengan poin %d berhasil ditambahkan", nama, poin);
                        JOptionPane.showMessageDialog(new JFrame(), message, "Success!", JOptionPane.INFORMATION_MESSAGE);
                        // Mengubah panel menjadi panel staf
                        main.setPanel("staf");
                    }
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
        // Mengosongkan semua textfield
        namaTextfield.setText("");
        poinTextField.setText("");
    }
}
