import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.*;


public class GUI implements ActionListener {

    private File file;
    private String inputImage;
    private String outputImage;
    private String formatName;

    public GUI(){
        final JFrame frame = new JFrame("Image Format Converter");

        JButton chooseYourFileButton = new JButton("browse");
        chooseYourFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(frame);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    file = fileChooser.getSelectedFile();
                    //This is where a real application would open the file.
                    System.out.println("File: " + file.getName() + ".");
                    System.out.println("Path: " + file.getAbsolutePath());
                } else {
                    System.out.println("Open command cancelled by user.");
                }
                System.out.println(returnValue);
            }
        });

        JRadioButton png = new JRadioButton(".png");
        png.setMnemonic(KeyEvent.VK_B);
        png.setActionCommand(".png");
        png.setSelected(true);

        JRadioButton jpeg = new JRadioButton(".jpeg");
        jpeg.setMnemonic(KeyEvent.VK_B);
        jpeg.setActionCommand(".jpeg");

        JRadioButton bmp = new JRadioButton(".bmp");
        bmp.setMnemonic(KeyEvent.VK_B);
        bmp.setActionCommand(".bmp");

        JRadioButton gif = new JRadioButton(".gif");
        gif.setMnemonic(KeyEvent.VK_B);
        gif.setActionCommand(".gif");

        ButtonGroup group = new ButtonGroup();
        group.add(png);
        group.add(jpeg);
        group.add(bmp);
        group.add(gif);

        jpeg.addActionListener(this);
        png.addActionListener(this);
        bmp.addActionListener(this);
        gif.addActionListener(this);


        JPanel formatsPanel = new JPanel(new FlowLayout());
        formatsPanel.add(png);
        formatsPanel.add(jpeg);
        formatsPanel.add(bmp);
        formatsPanel.add(gif);

        frame.add(formatsPanel, BorderLayout.CENTER);

        frame.setLayout(new BorderLayout());
        frame.add(chooseYourFileButton , BorderLayout.SOUTH);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


//    public static void main(String[] args) throws Exception {
//        new GUI();
//    }

}