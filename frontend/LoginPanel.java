package assignments.assignment4.frontend;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.pengguna.Anggota;
import assignments.assignment4.backend.pengguna.Pengguna;
import assignments.assignment4.backend.pengguna.Staf;
import assignments.assignment4.frontend.componentTemplate.JButtonTemplate;
import assignments.assignment4.frontend.componentTemplate.JLabelTemplate;
import assignments.assignment4.frontend.componentTemplate.JTextFieldTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Implementasikan hal-hal yang diperlukan
public class LoginPanel extends SistakaPanel {
    JTextFieldTemplate idTextfield;
    public LoginPanel(HomeGUI main){
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        // Mengatur layout (GridBagLayout) dari panel utama
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3,0,0,0);
        // Membuat label baru, lalu menambahkannya ke dalam panel sesuai layout constraints
        JLabelTemplate inputIdLabel = new JLabelTemplate("Masukkan ID Anda untuk login ke sistem");
        gbc.gridy = 0;
        add(inputIdLabel, gbc);
        // Membuat textfield baru, lalu menambahkannya ke dalam panel sesuai layout constraints
        idTextfield = new JTextFieldTemplate();
        gbc.gridy = 1;
        add(idTextfield, gbc);
        // Membuat button baru, lalu menambahkannya ke dalam panel sesuai layout constraints
        JButtonTemplate loginBtn = new JButtonTemplate("Login");
        gbc.gridy = 2;
        add(loginBtn, gbc);
        // Menghandle event ketika login button diklik
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // Mengambil id dari textfield
                String id = idTextfield.getText();
                String message = "";
                // Mengecek apakah id yang diinput ada pada daftar staf ataupun daftar anggota
                Pengguna penggunaLoggedIn = SistakaNG.handleLogin(id);
                // Jika user tidak mengisi textfield
                if (id.equals("")){
                    // Menampilkan pop up frame dengan message sesuai dengan pesan errornya
                    message = "Harap masukkan id anda pada kotak di atas!";
                    JOptionPane.showMessageDialog(new JFrame(), message, "Warning", JOptionPane.WARNING_MESSAGE);
                }
                // Jika id yang diinput user tidak ada pada daftar staf ataupun daftar anggota
                else if (penggunaLoggedIn == null){
                    // Menampilkan pop up frame dengan message sesuai dengan pesan errornya
                    message = String.format("Pengguna dengan id %s tidak ditemukan", id);
                    JOptionPane.showMessageDialog(new JFrame(), message, "Warning", JOptionPane.WARNING_MESSAGE);
                    // Mengosongkan textfield
                    idTextfield.setText("");
                }
                // Jika id yang diinput user ada
                else {
                    // Mengosongkan textfield
                    idTextfield.setText("");
                    // Menginisiasi user sekarang menjadi user dengan id yang diinput tadi
                    main.setUser(penggunaLoggedIn);
                    // Mengubah panel menjadi panel dari tipe dari user sekarang
                    main.setPanel(penggunaLoggedIn.getTipe());
                }
            }
        });
    }

    @Override
    public void refresh() {
        // ignored
    }
}
