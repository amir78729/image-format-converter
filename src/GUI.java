import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;


public class GUI {

    private File file;

    public GUI() {
        final JFrame frame = new JFrame("Image Format Converter");

        JButton btnFile = new JButton("Select an image file!");
        btnFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                int returnVal = fileChooser.showOpenDialog(frame);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    file = fileChooser.getSelectedFile();
                    //This is where a real application would open the file.
                    System.out.println("File: " + file.getName() + ".");
                    System.out.println("Path: " + file.getAbsolutePath());
                } else {
                    System.out.println("Open command cancelled by user.");
                }
                System.out.println(returnVal);
            }
        });

        frame.getContentPane().add(btnFile);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public static void main(String[] args) throws Exception {
        new GUI();
    }

}