package br.com.worldBestEncrypter.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameUtils {

    public static JButton generateSystemButton(String label){
        JButton button = new JButton();
        button.setText(label);
        button.setSize(100,50);
        return button;
    }


    public static JFrame generateFrame(String windowsLabel, String titleText){
        JFrame frame = new JFrame(windowsLabel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500,250);
        frame.setLocationRelativeTo(null);

        JLabel title = new JLabel(titleText);

        JPanel panelTitle = new JPanel();
        panelTitle.add(title);

        frame.add(panelTitle, BorderLayout.PAGE_START);

        return frame;
    }

    public static JFrame generateFrame(String windowsLabel, String titleText, JFrame previousFrame) {
        JFrame frame = FrameUtils.generateFrame(windowsLabel, titleText);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                previousFrame.setVisible(true);
            }
        });

        return frame;
    }

    public static JTextArea generateTextArea(){
        JTextArea textArea = new JTextArea();
        return textArea;
    }

    public static void DisplayAlertMessage(String message){
        JOptionPane.showMessageDialog(null,message,"AVISO", JOptionPane.WARNING_MESSAGE);
    }
}
