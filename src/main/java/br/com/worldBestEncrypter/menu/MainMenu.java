package br.com.worldBestEncrypter.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    public MainMenu(){

            JFrame f = FrameUtils.generateFrame("Melhor Encriptografador/Criptogrador do mundo", "Melhor Encriptografador/Criptogrador do mundo");

            JButton encryptButton = FrameUtils.generateSystemButton("MORSE");
            JButton decryptButton = FrameUtils.generateSystemButton("CESAR CYPHER");
            encryptButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.setVisible(false);
                    final MorseMenu menu = new MorseMenu(f);
                }

            });


            JPanel panelButtons = new JPanel();
            panelButtons.add(encryptButton);
            panelButtons.add(decryptButton);

            f.add(panelButtons, BorderLayout.CENTER);

            f.setVisible(true);
        }
}
