package assignments.assignment4.frontend;

import assignments.assignment4.frontend.componentTemplate.JButtonTemplate;
import assignments.assignment4.frontend.componentTemplate.JLabelTemplate;
import assignments.assignment4.frontend.componentTemplate.JPanelTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePanel extends SistakaPanel {
    public WelcomePanel(HomeGUI homeGUI) {
        super(homeGUI);
        // TODO: Implementasikan hal-hal yang diperlukan
        // Mengatur layout dari frame utama menjadi BoxLayout dengan orientasi vertikal
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        // Membuat panel baru untuk menampung label
        JPanelTemplate panel1 = new JPanelTemplate();
        // Mengatur layout dari panel ini menjadi GridBagLayout agar label terletak di tengah panel
        panel1.setLayout(new GridBagLayout());
        // Membuat label
        JLabelTemplate welcomeLabel = new JLabelTemplate("Welcome to SistakaNG");
        welcomeLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        // Menambahkan label ke dalam panel
        panel1.add(welcomeLabel);

        // Membuat panel baru lagi untuk menampung button
        JPanelTemplate panel2 = new JPanelTemplate();
        // Mengatur layout dari panel ini menjadi GridBagLayout agar button terletak di tengah panel
        panel2.setLayout(new GridBagLayout());
        // Menginstansiasi GridBagConstraints untuk mengatur layout komponen-komponen di dalam panel ini
        GridBagConstraints gbc = new GridBagConstraints();
        // Mengatur margin dari tiap komponen yang berada di panel ini
        gbc.insets = new Insets(10,0, 0, 0);
        // Membuat login button
        JButtonTemplate loginBtn = new JButtonTemplate("Login", 400, 40);
        // Mengatur posisi login button menjadi urutan pertama dari atas
        gbc.gridy = 0;
        // Menambahkan login button ke panel ini dan memasukkan GridBagConstraintsnya juga
        panel2.add(loginBtn, gbc);
        // Membuat exit button
        JButtonTemplate exitBtn = new JButtonTemplate("Exit", 400, 40);
        // Mengatur posisi login button menjadi urutan pertama dari atas
        gbc.gridy = 1;
        // Menambahkan exit button ke panel ini dan memasukkan GridBagConstraintsnya juga
        panel2.add(exitBtn, gbc);
        // Menambahkan panel1 dan panel2 ke frame
        add(panel1);
        add(panel2);
        // Menghandle event ketika login button diklik
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // Pergi ke login panel
                homeGUI.setPanel("login");
            }
        });
        // Menghandle event ketika exit button diklik
        exitBtn.addActionListener(new ActionListener() {
            @Override
            // Menutup frame utama
            public void actionPerformed(ActionEvent e){
                homeGUI.exit();
            }
        });
    }

    @Override
    public void refresh() {
        // ignored
    }
}
