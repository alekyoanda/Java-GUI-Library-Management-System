package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.pengguna.Anggota;
import assignments.assignment4.backend.pengguna.IdGenerator;
import assignments.assignment4.backend.pengguna.Mahasiswa;
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

// TODO: Implementasikan hal-hal yang diperlukan
public class TambahMahasiswaPanel extends SistakaPanel {
    // Membuat String[] dengan elemen semua program studi yang terdaftar
    private final String[] daftarProgramStudi = {"SIK", "SSI", "MIK", "DIK", "DTI"};
    // Mendeklarasikan textfield dan combo box
    private JTextFieldTemplate namaTextfield, tanggalLahirTextfield, angkatanTextfield;
    private JComboBox<String> daftarProgramStudiDropdown;

    public TambahMahasiswaPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        // Mengatur layout (GridBagLayout) dari panel utama
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3,0,0,0);
        // Membuat label baru, lalu menambahkannya ke dalam panel utama sesuai layout constraints
        JLabelTemplate tambahMhsLabel = new JLabelTemplate("Tambah Mahasiswa", 18);
        gbc.gridy = 0;
        add(tambahMhsLabel, gbc);
        // Membuat label baru, lalu menambahkannya ke dalam panel utamasesuai layout constraints
        JLabelTemplate namaLabel = new JLabelTemplate("Nama");
        gbc.gridy = 1;
        add(namaLabel, gbc);
        // Membuat textfield baru, lalu menambahkannya ke dalam panel utama sesuai layout constraints
        namaTextfield = new JTextFieldTemplate();
        gbc.gridy = 2;
        add(namaTextfield, gbc);
        // Membuat label baru, lalu menambahkannya ke dalam panel utama sesuai layout constraints
        JLabelTemplate tanggalLahirLabel = new JLabelTemplate("Tanggal Lahir (DD/MM/YYYY)");
        gbc.gridy = 3;
        add(tanggalLahirLabel, gbc);
        // Membuat textfield baru, lalu menambahkannya ke dalam panel utama sesuai layout constraints
        tanggalLahirTextfield = new JTextFieldTemplate();
        gbc.gridy = 4;
        add(tanggalLahirTextfield, gbc);
        // Membuat label baru, lalu menambahkannya ke dalam panel utama sesuai layout constraints
        JLabelTemplate programStudiLabel = new JLabelTemplate("Program Studi");
        gbc.gridy = 5;
        add(programStudiLabel, gbc);
        // Membuat combo box baru, menginisiasinya dengan array daftarProgramStudi, lalu menambahkannya ke dalam panel utamasesuai layout constraints
        daftarProgramStudiDropdown = new JComboBox<>(daftarProgramStudi);
        gbc.gridy = 6;
        add(daftarProgramStudiDropdown, gbc);
        // Membuat label baru, lalu menambahkannya ke dalam panel utama sesuai layout constraints
        JLabelTemplate angkatanLabel = new JLabelTemplate("Angkatan");
        gbc.gridy = 7;
        add(angkatanLabel, gbc);
        // Membuat textfield baru, lalu menambahkannya ke dalam panel utama sesuai layout constraints
        angkatanTextfield = new JTextFieldTemplate();
        gbc.gridy = 8;
        add(angkatanTextfield, gbc);
        // Membuat panel baru dan mengatur layoutnya, lalu menambahkannya ke dalam panel utama sesuai layout constraints
        JPanelTemplate panelBtn = new JPanelTemplate();
        panelBtn.setLayout(new FlowLayout());
        gbc.gridy = 9;
        add(panelBtn, gbc);
        // Membuat button baru, lalu menambahkannya ke dalam panelBtn sesuai layout
        JButtonTemplate tambahBtn = new JButtonTemplate("Tambah");
        panelBtn.add(tambahBtn);
        // Membuat button baru, lalu menambahkannya ke dalam panelBtn sesuai layout
        JButtonTemplate kembaliBtn = new JButtonTemplate("Kembali");
        panelBtn.add(kembaliBtn);
        // Menghandle event ketika tambah button diklik
        tambahBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // Menginisiasi variabel mahasiswaBaru dengan null
                Mahasiswa mahasiswaBaru = null;
                // Mengambil semua data terkait mahasiswa yang telah diinput user
                String nama = namaTextfield.getText();
                String tanggalLahir = tanggalLahirTextfield.getText();
                String programStudi = (String) daftarProgramStudiDropdown.getSelectedItem();
                String angkatan = angkatanTextfield.getText();
                // Mengecek apakah tahun angkatan yang diinput user merupakan angka
                if (SistakaPanel.isNumeric(angkatan)){
                    // Jika iya, maka panggil method addMahasiswa dan inisiasi variabel
                    // mahasiswaBaru tersebut menjadi return value dari addMahasiswa
                    mahasiswaBaru = SistakaNG.addMahasiswa(nama, tanggalLahir, programStudi, angkatan);
                }
                // Variabel untuk menampung message yang akan ditampilkan pada pop up frame
                String message = "";
                // Jika input user tidak valid
                if (mahasiswaBaru == null){
                    // Menampilkan pop up frame dengan message sesuai dengan pesan errornya
                    message = "Tidak dapat menambahkan mahasiswa silahkan periksa kembali input anda!";
                    JOptionPane.showMessageDialog(new JFrame(), message, "Warning", JOptionPane.WARNING_MESSAGE);
                    // Mengosongkan textfield
                    refresh();
                }
                // Jika input user valid
                else{
                    // Menampilkan pop up frame dengan message sesuai dengan pesan berhasilnya
                    message = String.format("Berhasil menambahkan mahasiswa dengan id %s!", mahasiswaBaru.getId());
                    JOptionPane.showMessageDialog(new JFrame(), message, "Success!", JOptionPane.INFORMATION_MESSAGE);
                    // Mengubah panel menjadi panel staf
                    main.setPanel("staf");
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
        // Mengosongkan semua textfield
        namaTextfield.setText("");
        tanggalLahirTextfield.setText("");
        angkatanTextfield.setText("");
    }
}
