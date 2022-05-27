package assignments.assignment4.frontend.anggota.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.pengguna.Anggota;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;
import assignments.assignment4.frontend.componentTemplate.JButtonTemplate;
import assignments.assignment4.frontend.componentTemplate.JLabelTemplate;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Implementasikan hal-hal yang diperlukan
public class DetailUserPanel extends SistakaPanel {
    private JLabelTemplate detailAnggotaLabel;
    public DetailUserPanel(HomeGUI main) {
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

        detailAnggotaLabel = new JLabelTemplate("");
        gbc.gridy = 1;
        add(detailAnggotaLabel, gbc);

        JButtonTemplate kembaliBtn = new JButtonTemplate("Kembali");
        gbc.gridy = 2;
        add(kembaliBtn, gbc);
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
        // Mengupdate label menjadi berisi detail anggota
        detailAnggotaLabel.setText(((Anggota) main.getUser()).detail());
    }
}
