package br.com.worldBestEncrypter.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MorseMenu {
    public MorseMenu(JFrame MainMenuFrame){
        JFrame frame = FrameUtils.generateFrame("Morse coder", "Morse coder", MainMenuFrame);

        JTextArea textArea = FrameUtils.generateTextArea();

        JButton encryptButton = FrameUtils.generateSystemButton("Encrypt");
        JButton decryptButton = FrameUtils.generateSystemButton("Decrypt");

        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("ENCRIPTOGRAFADO");
            }
        });
        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("DESCRIPTOGRAFADO");
            }
        });

        JPanel panelButtons = new JPanel();
        panelButtons.add(encryptButton);
        panelButtons.add(decryptButton);

        frame.add(textArea, BorderLayout.CENTER);
        frame.add(panelButtons, BorderLayout.AFTER_LAST_LINE);

        frame.setVisible(true);
    }
}
