package assignments.assignment4.frontend.anggota.ui;

import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;
import assignments.assignment4.frontend.componentTemplate.JButtonTemplate;
import assignments.assignment4.frontend.componentTemplate.JLabelTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// TODO: Implementasikan hal-hal yang diperlukan
public class AnggotaHomePanel extends SistakaPanel {
    JLabelTemplate welcomeAnggotaLabel;
    public AnggotaHomePanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        // Mengatur layout (GridLayout) dari panel utama
        setLayout(new GridLayout(7, 1, 5,5));
        // Membuat semua komponen yang diperlukan
        welcomeAnggotaLabel = new JLabelTemplate("", 18);
        JButtonTemplate peminjamanBtn = new JButtonTemplate("Peminjaman");
        JButtonTemplate pengembalianBtn = new JButtonTemplate("Pengembalian");
        JButtonTemplate pembayaranDendaBtn = new JButtonTemplate("Pembayaran Denda");
        JButtonTemplate detailAnggotaBtn = new JButtonTemplate("Detail Anggota");
        JButtonTemplate logoutBtn = new JButtonTemplate("Logout");
        // Menambah semua komponen tersebut ke dalam panel utama
        add(welcomeAnggotaLabel);
        add(peminjamanBtn);
        add(pengembalianBtn);
        add(pembayaranDendaBtn);
        add(detailAnggotaBtn);
        add(logoutBtn);
        // Menghandle event ketika peminjaman button diklik
        peminjamanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // Mengubah panel menjadi panel untuk melakukan peminjaman
                main.setPanel("peminjaman");
            }
        });
        // Menghandle event ketika pengembalian button diklik
        pengembalianBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // Mengubah panel menjadi panel untuk mengembalikan buku
                main.setPanel("pengembalian");
            }
        });
        // Menghandle event ketika pembayaran denda button diklik
        pembayaranDendaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // Mengubah panel menjadi panel untuk melakukan pembayaran
                main.setPanel("pembayaran");
            }
        });
        // Menghandle event ketika detail anggota button diklik
        detailAnggotaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // Mengubah panel menjadi panel untuk melihat detail user
                main.setPanel("detailUser");
            }
        });
        // Menghandle event ketika logout button diklik
        logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // Mengubah panel menjadi panel welcome
                main.setPanel("welcome");
            }
        });
    }

    @Override
    public void refresh() {
        // TODO: Implementasikan hal-hal yang diperlukan
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
        // Mengupdate text pada label
        welcomeAnggotaLabel.setText(String.format("Selamat datang kembali %s!", main.getUser().getNama()));

    }
}