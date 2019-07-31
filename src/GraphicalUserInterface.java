import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class GraphicalUserInterface extends JFrame implements ActionListener{
    private File file;
    private String inputImage = "C:\\Users\\Amirhossein A\\Desktop\\^_^.jpg";
    private String outputImage= "C:\\Users\\Amirhossein A\\Desktop\\^_^.jpg_.png";
    private String formatName;
    private JButton convert;
    private JButton chooseYourFileButton;
    private boolean fileIsSelected = false;
    private boolean formatIsSelected = false;
    public GraphicalUserInterface(){

        super("IMAGE FORMAT CONVERTER");
        setLayout(new BorderLayout());
        setSize(500, 500);
        convert = new JButton("convert!");
        convert.setEnabled(false);

        //filechooser

        chooseYourFileButton = new JButton("browse");
        chooseYourFileButton.addActionListener(this);


        //showing pop-up

        JButton selectFormat = new JButton("select a format");

        final JPopupMenu popup = new JPopupMenu();
        JMenuItem jpeg = new JMenuItem(new AbstractAction(".jpeg") {
            public void actionPerformed(ActionEvent e) {
                formatName = "jpeg";
                selectFormat.setText(".jpeg");
                formatIsSelected = true;
                convert.setText("Convert to \"." + formatName + "\"!");
                if(fileIsSelected){
                    convert.setEnabled(true);
                    convert.setText("Convert \"" + file.getName() + "\" to \"." + formatName + "\"!");
                }
            }
        });
        popup.add(jpeg);
        JMenuItem png = new JMenuItem(new AbstractAction(".png") {
            public void actionPerformed(ActionEvent e) {
                formatName = "png";
                selectFormat.setText(".png");
                formatIsSelected = true;
                convert.setText("Convert to \"." + formatName + "\"!");
                if(fileIsSelected){
                    convert.setEnabled(true);
                    convert.setText("Convert \"" + file.getName() + "\" to \"." + formatName + "\"!");
                }
            }
        });
        popup.add(png);
        JMenuItem bmp = new JMenuItem(new AbstractAction(".bmp") {
            public void actionPerformed(ActionEvent e) {
                formatName = "bmp";
                selectFormat.setText(".bmp");
                formatIsSelected = true;
                convert.setText("Convert to \"." + formatName + "\"!");
                if(fileIsSelected){
                    convert.setEnabled(true);
                    convert.setText("Convert \"" + file.getName() + "\" to \"." + formatName + "\"!");
                }
            }
        });
        popup.add(bmp);
        JMenuItem gif = new JMenuItem(new AbstractAction(".gif") {
            public void actionPerformed(ActionEvent e) {
                formatName = "gif";
                selectFormat.setText(".gif");
                formatIsSelected = true;
                convert.setText("Convert to \"." + formatName + "\"!");
                if(fileIsSelected){
                    convert.setEnabled(true);
                    convert.setText("Convert \"" + file.getName() + "\" to \"." + formatName + "\"!");
                }
            }
        });
        popup.add(gif);
        selectFormat.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });


        add(convert, BorderLayout.CENTER);
        add(chooseYourFileButton, BorderLayout.NORTH);
        add(selectFormat, BorderLayout.SOUTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == convert){
            System.out.println("CLICKED!");
            try {
                boolean result = ImageConverter.convertFormat(inputImage,
                        outputImage, formatName);
                if (result) {
                    System.out.println("Image converted successfully.");
                } else {
                    System.out.println("Could not convert image.");
                }
            } catch (IOException ex) {
                System.out.println("Error during converting image.");
                ex.printStackTrace();
            }
        }else if(e.getSource() == chooseYourFileButton){
            final JFileChooser fileChooser = new JFileChooser("C:\\Users\\Amirhossein A\\Desktop");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int returnValue = fileChooser.showOpenDialog(fileChooser);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
                //This is where a real application would open the file.
                fileIsSelected = true;
                convert.setText("Convert \"" + file.getName() + "\"!");
                if(formatIsSelected){
                    convert.setEnabled(true);
                    convert.setText("Convert \"" + file.getName() + "\" to \"." + formatName + "\"!");
                }

                System.out.println("File: " + file.getName());
                System.out.println("Path: " + file.getAbsolutePath());

                inputImage = file.getName();
                System.out.println(inputImage);

                outputImage = file.getName() + "_." + formatName;
                System.out.println(outputImage);


            } else {
                System.out.println("Open command cancelled by user.");
            }
            System.out.println(returnValue);
        }
    }
}
