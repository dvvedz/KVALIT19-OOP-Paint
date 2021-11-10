package inlamningsuppgift;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        JFrame frame = new JFrame("Paint");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Tools tool = new Tools();
        Canvas canvas = new Canvas();
        Binary bin = new Binary();

        try {
            bin.writeToFile(canvas);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // paint on mouse position
        canvas.mousePressed();
        canvas.mouseDragged();

        frame.add(canvas); // adds circle to frame
        frame.setSize(500, 500); // set frame size
        frame.setVisible(true); // makes the frame visible
        bin.readFromFile();

        // Settings
        while(true) {
            Scanner inp = new Scanner(System.in);
            System.out.print("Settings: ");
            String settingsQuery = inp.nextLine();

            if (settingsQuery.equals("set brush_radius") || settingsQuery.equals("br")) {
                canvas.brush = tool.brush();

            } else if (settingsQuery.equals("use color") || settingsQuery.equals("c")) {
                canvas.color = tool.color();

            } else if(settingsQuery.equals("list colors")) {
                tool.listColors();

            } else {
                System.out.println();
                String help = "### HELP ### \nCommands available:\n" +
                        tool.ANSI_GREEN + "use color or alternative shortcut c \n" +
                        "set brush_radius\n" + tool.ANSI_RESET;
                System.out.println(help);
            }

            try {
                bin.writeToFile(canvas);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
