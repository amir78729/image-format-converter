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
    private JButton selectingPictureButton;
    private JButton selectingFormatButton;
    private JLabel showingInformation;
    private JLabel showStatus;
    private JLabel selectingFormatLabel;
    private JLabel selectingPictureLabel;
    private boolean fileIsSelected = false;
    private boolean formatIsSelected = false;

    Font consolas = new Font("Consolas",Font.BOLD, 12);
    Font consolasBold = new Font("Consolas",Font.BOLD, 15);
    Color noColor = new Color(0,0,0 , 0);
    Color red = new Color(200,0,0);
    Color darkGreen = new Color(0,150,0);

    /**
     * a method that can erase the format of our file
     * @param str ex: "image.jpg"
     * @return ex: "image"
     */
    static String stripExtension (String str) {
        // Handle null case specially.
        if (str == null) return null;
        // Get position of last '.'.
        int pos = str.lastIndexOf(".");
        // If there wasn't any '.' just return the string as is.
        if (pos == -1) return str;
        // Otherwise return the string, up to the dot.
        return str.substring(0, pos);
    }

    public GraphicalUserInterface(){

        super("IMAGE FORMAT CONVERTER");
        setLayout(new BorderLayout());
        setSize(600, 200);
        convert = new JButton("convert!");
        convert.setEnabled(false);
        convert.addActionListener(this);
        convert.setBorderPainted(false);
        convert.setFocusable(false);
        convert.setFont(consolas);
        convert.setBackground(new Color(20,20,20));
        convert.setForeground(new Color(200,200,0));

        //filechooser

        selectingPictureButton = new JButton("browse");
        selectingPictureButton.addActionListener(this);
        selectingPictureButton.setBorderPainted(false);
        selectingPictureButton.setFocusable(false);
        selectingPictureButton.setPreferredSize(new Dimension(85,30));
        selectingPictureButton.setFont(consolas);
        selectingPictureButton.setBackground(new Color(20,20,20));
        selectingPictureButton.setForeground(Color.white);



        //showing pop-up

        selectingFormatButton = new JButton(" - ");
        selectingFormatButton.setBorderPainted(false);
        selectingFormatButton.setFocusable(false);
        selectingFormatButton.setPreferredSize(new Dimension(85,30));
        selectingFormatButton.setFont(consolas);
        selectingFormatButton.setBackground(new Color(20,20,20));
        selectingFormatButton.setForeground(Color.white);

        final JPopupMenu popup = new JPopupMenu();
        JMenuItem jpeg = new JMenuItem(new AbstractAction(".jpeg") {
            public void actionPerformed(ActionEvent e) {
                formatName = "jpeg";
                selectingFormatButton.setText(".jpeg");
                formatIsSelected = true;
                convert.setText("Convert to \"." + formatName + "\"!");
                selectingFormatLabel.setForeground(darkGreen);
                if(fileIsSelected){
                    makeTheConvertButtonReady();
                }
            }
        });
        popup.add(jpeg);
        JMenuItem png = new JMenuItem(new AbstractAction(".png") {
            public void actionPerformed(ActionEvent e) {
                formatName = "png";
                selectingFormatButton.setText(".png");
                formatIsSelected = true;
                convert.setText("Convert to \"." + formatName + "\"!");
                selectingFormatLabel.setForeground(darkGreen);
                if(fileIsSelected){
                    makeTheConvertButtonReady();
                }
            }
        });
        popup.add(png);
        JMenuItem bmp = new JMenuItem(new AbstractAction(".bmp") {
            public void actionPerformed(ActionEvent e) {
                formatName = "bmp";
                selectingFormatButton.setText(".bmp");
                formatIsSelected = true;
                convert.setText("Convert to \"." + formatName + "\"!");
                selectingFormatLabel.setForeground(darkGreen);
                if(fileIsSelected){
                    makeTheConvertButtonReady();
                }
            }
        });
        popup.add(bmp);
        JMenuItem gif = new JMenuItem(new AbstractAction(".gif") {
            public void actionPerformed(ActionEvent e) {
                formatName = "gif";
                selectingFormatButton.setText(".gif");
                formatIsSelected = true;
                convert.setText("Convert to \"." + formatName + "\"!");
                selectingFormatLabel.setForeground(darkGreen);
                if(fileIsSelected){
                    makeTheConvertButtonReady();
                }
            }
        });
        popup.add(gif);
        selectingFormatButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });

        JPanel selectingPicturePanel = new JPanel(new FlowLayout());
        selectingPicturePanel.setBackground(Color.black);
        selectingPictureLabel = new JLabel("SELECT AN IMAGE :");
        selectingPictureLabel.setFont(consolas);
        selectingPictureLabel.setBackground(noColor);
        selectingPictureLabel.setForeground(red);

        selectingPicturePanel.add(selectingPictureLabel);
        selectingPicturePanel.add(selectingPictureButton);

        JPanel selectingFormatPanel = new JPanel(new FlowLayout());
        selectingFormatPanel.setBackground(Color.black);
        selectingFormatLabel = new JLabel("SELECT A FORMAT :");
        selectingFormatLabel.setFont(consolas);
        selectingFormatLabel.setBackground(noColor);
        selectingFormatLabel.setForeground(red);


        selectingFormatPanel.add(selectingFormatLabel);
        selectingFormatPanel.add(selectingFormatButton);

        JPanel formatAndImagePanel = new JPanel(new GridLayout(1, 2));
        formatAndImagePanel.add(selectingPicturePanel);
        formatAndImagePanel.add(selectingFormatPanel);

        JPanel showingTheInfoOfThePicturePanel = new JPanel(new GridLayout(2,1));
        showingTheInfoOfThePicturePanel.setBackground(Color.black);
        showingInformation = new JLabel();
        showingInformation.setFont(consolasBold);
        showingInformation.setBackground(new Color(0,0,0,0));
        showingInformation.setForeground(Color.white);
        showingInformation.setHorizontalAlignment(JLabel.CENTER);
        showingTheInfoOfThePicturePanel.add(showingInformation);
        showStatus = new JLabel();
        showStatus.setFont(consolasBold);
        showStatus.setBackground(new Color(0,0,0,0));
        showStatus.setForeground(Color.white);
        showStatus.setHorizontalAlignment(JLabel.CENTER);
        showingTheInfoOfThePicturePanel.add(showStatus);


        add(formatAndImagePanel, BorderLayout.NORTH);
        add(showingTheInfoOfThePicturePanel, BorderLayout.CENTER);
        add(convert, BorderLayout.SOUTH);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void makeTheConvertButtonReady(){
        convert.setEnabled(true);
        inputImage = file.getAbsolutePath();
        System.out.println(inputImage);
        outputImage = stripExtension(file.getAbsolutePath()) + "." + formatName;
        System.out.println(outputImage);
        convert.setText("Convert \"" + file.getName() + "\" to \"" + stripExtension(file.getName()) + "." + formatName + "\"!");
        showingInformation.setForeground(darkGreen);
        showingInformation.setText("\"" + file.getName() + "\" is going to be saved to the same path as a \" ." + formatName + " \" file:)");
        showStatus.setForeground(Color.white);
        showStatus.setText("ready to convert!");
        showStatus.setFont(consolas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == convert){
            System.out.println("CLICKED!");
            showStatus.setForeground(Color.white);



            try {
                boolean result = ImageConverter.convertFormat(inputImage,
                        outputImage, formatName);
                if (result) {
                    System.out.println("Image converted successfully.");
                    showStatus.setText("Image converted successfully ^_^");
                    showStatus.setForeground(Color.green);
                } else {
                    System.out.println("Could not convert image.");
                    showStatus.setText("Could not convert image x_x");
                    showStatus.setForeground(red);
                }
            } catch (IOException ex) {
                System.out.println("Error during converting image.");
                showStatus.setText("Error during converting image x_x");
                showStatus.setForeground(red);
                ex.printStackTrace();
            }
        }else if(e.getSource() == selectingPictureButton){
            final JFileChooser fileChooser = new JFileChooser("C:\\Users\\Amirhossein A\\Desktop");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int returnValue = fileChooser.showOpenDialog(fileChooser);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
                //This is where a real application would open the file.
                fileIsSelected = true;
                convert.setText("Convert \"" + file.getName() + "\"!");
                selectingPictureLabel.setForeground(darkGreen);
                if(formatIsSelected){
                    makeTheConvertButtonReady();
                }

                System.out.println("File: " + file.getName());
                System.out.println("Path: " + file.getAbsolutePath());



            } else {
                System.out.println("Open command cancelled by user.");
            }
            System.out.println(returnValue);
        }

    }

    public void waiting(){
        System.out.println("wait");
        for (int i = 0 ; i<100000; i++){
            showStatus.setText("-");
            showStatus.setText("\\");
            showStatus.setText("|");
            showStatus.setText("/");
        }

    }
}
