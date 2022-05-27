package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.backend.SistakaNG;
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
public class PeringkatPanel extends SistakaPanel {
    private JLabelTemplate dataPeringkatLabel;
    public PeringkatPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        // Mengatur layout (GridBagLayout) dari panel utama
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3,0,0,0);
        // Menginstansiasi semua komponen yang diperlukan, lalu menambahkannya ke dalam panel utama sesuai layout constraints
        JLabelTemplate peringkatLabel = new JLabelTemplate("Peringkat", 18);
        gbc.gridy = 0;
        add(peringkatLabel, gbc);

        dataPeringkatLabel = new JLabelTemplate(SistakaNG.handleRankingAnggota());
        gbc.gridy = 1;
        add(dataPeringkatLabel, gbc);

        JButtonTemplate kembaliBtn = new JButtonTemplate("Kembali");
        gbc.gridy = 2;
        add(kembaliBtn, gbc);
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
        // Mengupdate text pada label dengan isi 3 peringkat anggota teratas
        dataPeringkatLabel.setText(SistakaNG.handleRankingAnggota());
    }
}
