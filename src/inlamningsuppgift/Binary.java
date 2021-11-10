package inlamningsuppgift;

import java.io.*;


public class Binary {

    public static Canvas readBin;

    /**
     *
     * This method creates file if it's not already created.
     * This method writes to a binary file if the file already exists.
     *
     * @param c
     * @throws IOException
     */
    void writeToFile(Canvas c) throws IOException {
        ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("Canvas.data"));
        objOut.writeObject(c);
    }

    /**
     *
     * This method reads the object instances from the the binary file if its created.
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    void readFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("Canvas.data"));
        readBin = (Canvas) objIn.readObject();
    }
}
