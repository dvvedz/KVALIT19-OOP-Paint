package inlamningsuppgift;
import java.awt.*;
import java.io.Serializable;
import java.util.Scanner;

public class Tools implements Serializable {

    public String ANSI_RESET = "\u001B[0m";
    public String ANSI_RED = "\u001B[31m";
    public String ANSI_GREEN = "\u001B[32m";

    private Color[] colorArr = {Color.BLACK, Color.WHITE, Color.BLUE, Color.GREEN, Color.PINK, Color.RED, Color.CYAN, Color.GRAY,
            Color.LIGHT_GRAY, Color.darkGray, Color.ORANGE, Color.YELLOW, Color.MAGENTA};
    private String[] colorStrArr = {"black", "white", "blue", "green", "pink", "red", "cyan", "gray", "lightgray", "darkgray",
            "orange", "yellow", "magenta"};

    /**
     *
     * With help of this method you can set the size of the brush.
     *
     * @return The instance variable "brush" from the binary file Canvas.data
     */
    public int brush() {
        Scanner inp = new Scanner(System.in);
        System.out.print("brush_radius > ");
        try {
            String whatColor = inp.nextLine();
            System.out.println(ANSI_GREEN + "brush_radius: " + whatColor + ANSI_RESET);
            Binary.readBin.brush = Integer.parseInt(whatColor);
            return Binary.readBin.brush;

        } catch (NumberFormatException e) {
            System.out.println(ANSI_RED + "Error" + ANSI_RESET);
        }
        return 10;
    }

    /**
     *
     * With help of this method you can set the color of the brush.
     *
     * @return The instance variable "color" fro the binary file Canvas.data
     */
    public Color color() {
        Scanner inp = new Scanner(System.in);
        System.out.print("color > ");
        String whatColor = inp.nextLine();
        for (int i = 0; i < colorStrArr.length ; i++) {
            if(colorStrArr[i].equals(whatColor)) {
                System.out.println(ANSI_GREEN + "color: " + whatColor + ANSI_RESET);
                Binary.readBin.color = colorArr[i];
                return Binary.readBin.color;
            }
        }
        return Color.BLACK;
    }

    /**
     *
     *  Call this method if you want to show the user all available colors.
     *
     */
    public void listColors() {
        System.out.println();
        for (String i: colorStrArr) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }

}
