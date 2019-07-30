import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.*;


public class GUI {

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

        final JPopupMenu popup = new JPopupMenu();

        JMenuItem jpeg = new JMenuItem(new AbstractAction(".jpeg") {
            public void actionPerformed(ActionEvent e) {
                formatName = "JPEG";
            }
        });
        popup.add(jpeg);


        JMenuItem png = new JMenuItem(new AbstractAction(".png") {
            public void actionPerformed(ActionEvent e) {
                formatName = "PNG";
            }
        });
        popup.add(png);


        JMenuItem bmp = new JMenuItem(new AbstractAction(".bmp") {
            public void actionPerformed(ActionEvent e) {
                formatName = "BMP";
            }
        });
        popup.add(bmp);


        JMenuItem gif = new JMenuItem(new AbstractAction(".gif") {
            public void actionPerformed(ActionEvent e) {
                formatName = "GIF";
            }
        });
        popup.add(gif);


        JButton selectFormat = new JButton("select a format");
        selectFormat.setBackground(Color.magenta);
        selectFormat.setVisible(true);

        selectFormat.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });


        frame.add(selectFormat , BorderLayout.SOUTH);


        frame.setLayout(new BorderLayout());
//        frame.add(chooseYourFileButton , BorderLayout.SOUTH);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }




//    public static void main(String[] args) throws Exception {
//        new GUI();
//    }

}