package br.com.worldBestEncrypter.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CesarCipherMenu {
    public CesarCipherMenu(JFrame MainMenuFrame){
        JFrame frame = FrameUtils.generateFrame("Cesar Cipher coder", "Cesar Cipher coder", MainMenuFrame);

        String[] numbers = new String[26];
        for(int i = 1; i <= 26; i++){
            numbers[i-1] = String.valueOf(i);
        }

        JComboBox<String> comboBox = new JComboBox<>(numbers);

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

        JPanel area = new JPanel(new BorderLayout());
        area.add(comboBox, BorderLayout.NORTH);
        area.add(textArea, BorderLayout.CENTER);



        frame.add(area, BorderLayout.CENTER);
        frame.add(panelButtons, BorderLayout.AFTER_LAST_LINE);

        frame.setVisible(true);
    }
}