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
import java.util.ArrayList;
import java.util.List;

// TODO: Implementasikan hal-hal yang diperlukan
public class PembayaranPanel extends SistakaPanel {
    JTextFieldTemplate jumlahDendaTextfield;
    public PembayaranPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        // Mengatur layout (GridBagLayout) dari panel utama
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3,0,0,0);
        // Menginstansiasi semua komponen yang diperlukan, lalu menambahkannya ke dalam panel utama sesuai layout constraints
        JLabelTemplate bayarDendaLabel = new JLabelTemplate("Bayar Denda", 18);
        gbc.gridy = 0;
        add(bayarDendaLabel, gbc);

        JLabelTemplate jumlahDendaLabel = new JLabelTemplate("Jumlah Denda");
        gbc.gridy = 1;
        add(jumlahDendaLabel, gbc);

        jumlahDendaTextfield = new JTextFieldTemplate();
        gbc.gridy = 2;
        add(jumlahDendaTextfield, gbc);

        JPanelTemplate panelBtn = new JPanelTemplate();
        panelBtn.setLayout(new FlowLayout());
        gbc.gridy = 3;
        add(panelBtn, gbc);
        // Membuat dua buah button, lalu menambahkannya ke dalam panelBtn sesuai layout
        JButtonTemplate bayarBtn = new JButtonTemplate("Bayar");
        panelBtn.add(bayarBtn);

        JButtonTemplate kembaliBtn = new JButtonTemplate("Kembali");
        panelBtn.add(kembaliBtn);
        // Menghandle event ketika bayar button diklik
        bayarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
                String message = "";
                // Mengambil denda dari textfield
                String dendaString = jumlahDendaTextfield.getText();
                // Jika denda yang diinput user bukan merupakan angka
                if (!isNumeric(dendaString)){
                    // Menampilkan pop up frame dengan message sesuai dengan pesan errornya
                    message = "Jumlah Bayar harus berupa angka!";
                    JOptionPane.showMessageDialog(new JFrame(), message, "Warning", JOptionPane.WARNING_MESSAGE);
                    refresh();
                }
                // Jika denda yang diinput user merupakan angka
                else{
                    // Parsing denda bertipe string ke long
                    long bayarDenda = Long.parseLong(dendaString);
                    // Menampilkan pop up frame dengan message sesuai dengan pesan yang direturn di method bayarDenda
                    message = SistakaNG.bayarDenda(bayarDenda);
                    JOptionPane.showMessageDialog(new JFrame(), message, "Info", JOptionPane.INFORMATION_MESSAGE);
                    // Mengubah panel menjadi panel anggota
                    main.setPanel("anggota");
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
        // Mengosongkan textfield
        jumlahDendaTextfield.setText("");
    }
}
