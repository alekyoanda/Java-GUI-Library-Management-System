package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.buku.Buku;
import assignments.assignment4.backend.pengguna.Anggota;
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
import java.util.List;

// TODO: Implementasikan hal-hal yang diperlukan
public class DetailAnggotaPanel extends SistakaPanel {
    private JComboBox<String> daftarIdDropdown;
    private JLabelTemplate detailAnggotaLabel;
    // Menginisiasi array string dengan size 0
    private String[] daftarId = new String[0];
    public DetailAnggotaPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        // Mengatur layout (GridBagLayout) dari panel utama
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3,0,0,0);
        // Menginstansiasi semua komponen yang diperlukan, lalu menambahkannya ke dalam panel utama sesuai layout constraints
        JLabelTemplate lihatDetailAnggotaLabel = new JLabelTemplate("Lihat Detail Anggota", 18);
        gbc.gridy = 0;
        add(lihatDetailAnggotaLabel, gbc);

        JLabelTemplate pilihIdAnggotaLabel = new JLabelTemplate("Pilih id Anggota");
        gbc.gridy = 1;
        add(pilihIdAnggotaLabel, gbc);

        daftarIdDropdown = new JComboBox<>(daftarId);
        gbc.gridy = 2;
        add(daftarIdDropdown, gbc);

        detailAnggotaLabel = new JLabelTemplate("");
        gbc.gridy = 3;
        add(detailAnggotaLabel, gbc);

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
                // TODO
                String message = "";
                // Jika belum ada anggota di dalam daftar anggota
                if (daftarId.length == 0){
                    // Menampilkan pop up frame dengan message sesuai dengan pesan errornya
                    message = "Silahkan memilih ID Anggota!";
                    JOptionPane.showMessageDialog(new JFrame(), message, "Warning", JOptionPane.WARNING_MESSAGE);
                }
                // Jika sudah ada
                else {
                    // Mengambil semua data terkait buku yang ingin dihapus
                    String id = (String) daftarIdDropdown.getSelectedItem();
                    // Mencari anggota berdasarkan id
                    Anggota anggotaYangInginDicari = SistakaNG.findAnggota(id);
                    // Jika anggota dengan id yang diinput user ada di daftar anggota
                    if (anggotaYangInginDicari != null){
                        // Mengupdate label menjadi berisi detail dari anggota
                        detailAnggotaLabel.setText(anggotaYangInginDicari.detail());
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
        // Memanggil method static getDaftarIdAnggota yang ada pada class SistakaNG
        daftarId = SistakaNG.getDaftarIdAnggota();
        // Mengupdate combobox dengan isi semua id dari anggota yang sudah pernah ditambahkan
        daftarIdDropdown.setModel(new DefaultComboBoxModel<>(daftarId));
        // Mengosongkan textfield
        detailAnggotaLabel.setText("");
    }


}
