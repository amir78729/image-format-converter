import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String inputImage = "D:/negar.jpg";
        String outputImage = "D:/output.png";
        String formatName = "PNG";
//        try {
//            boolean result = ImageConverter.convertFormat(inputImage,
//                    outputImage, formatName);
//            if (result) {
//                System.out.println("Image converted successfully.");
//            } else {
//                System.out.println("Could not convert image.");
//            }
//        } catch (IOException ex) {
//            System.out.println("Error during converting image.");
//            ex.printStackTrace();
//        }

//        new GUI();
        new GraphicalUserInterface();
    }
}