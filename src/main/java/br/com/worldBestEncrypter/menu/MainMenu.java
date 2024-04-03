package br.com.worldBestEncrypter.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    public MainMenu(){

            JFrame f = FrameUtils.generateFrame("Melhor Encriptografador/Criptogrador do mundo", "Melhor Encriptografador/Criptogrador do mundo");

            JButton morseButton = FrameUtils.generateSystemButton("MORSE");
            JButton cesarCipherButton = FrameUtils.generateSystemButton("CESAR CIPHER");
            morseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.setVisible(false);
                    final MorseMenu menu = new MorseMenu(f);
                }
            });

            cesarCipherButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.setVisible(false);
                    final CesarCipherMenu menu = new CesarCipherMenu(f);
                }
            });


            JPanel panelButtons = new JPanel();
            panelButtons.add(morseButton);
            panelButtons.add(cesarCipherButton);

            f.add(panelButtons, BorderLayout.CENTER);

            f.setVisible(true);
        }
}
