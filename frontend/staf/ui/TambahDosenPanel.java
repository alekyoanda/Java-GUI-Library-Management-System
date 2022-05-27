package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.pengguna.Anggota;
import assignments.assignment4.backend.pengguna.Dosen;
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
import java.util.List;

// TODO: Implementasikan hal-hal yang diperlukan
public class TambahDosenPanel extends SistakaPanel {
    private JTextFieldTemplate namaTextfield;
    public TambahDosenPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        // Mengatur layout (GridBagLayout) dari panel utama
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3,0,0,0);
        // Membuat label baru, lalu menambahkannya ke dalam panel utama sesuai layout constraints
        JLabelTemplate tambahDosenLabel = new JLabelTemplate("Tambah Dosen", 18);
        gbc.gridy = 0;
        add(tambahDosenLabel, gbc);
        // Membuat label baru, lalu menambahkannya ke dalam panel utamasesuai layout constraints
        JLabelTemplate namaLabel = new JLabelTemplate("Nama");
        gbc.gridy = 1;
        add(namaLabel, gbc);
        // Membuat textfield baru, lalu menambahkannya ke dalam panel utamasesuai layout constraints
        namaTextfield = new JTextFieldTemplate();
        gbc.gridy = 2;
        add(namaTextfield, gbc);
        // Membuat panel baru dan mengatur layoutnya, lalu menambahkannya ke dalam panel utama sesuai layout constraints
        JPanelTemplate panelBtn = new JPanelTemplate();
        panelBtn.setLayout(new FlowLayout());
        gbc.gridy = 3;
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
                // Mengambil semua data terkait dosen yang telah diinput user
                String nama = namaTextfield.getText();
                String message = "";
                // Jika user tidak mengisi textfield
                if (nama.equals("")){
                    // Menampilkan pop up frame dengan message sesuai dengan pesan errornya
                    message = "Tidak dapat menambahkan dosen silahkan periksa kembali input anda!";
                    JOptionPane.showMessageDialog(new JFrame(), message, "Warning", JOptionPane.WARNING_MESSAGE);
                }
                // Jika user mengisi textfield
                else{
                    // Memanggil method addDosen dan inisiasi variabel dosenBaru menjadi return value dari addMahasiswa
                    Dosen dosenBaru = SistakaNG.addDosen(nama);
                    // Menampilkan pop up frame dengan message sesuai dengan pesan berhasilnya
                    message = String.format("Berhasil menambahkan dosen dengan id %s!", dosenBaru.getId());
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
    }
}
