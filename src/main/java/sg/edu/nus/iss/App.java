package sg.edu.nus.iss;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        String filePathName = args[0];
        String portNumber = args[1];

        File cookieFile = new File(filePathName);

        if (!cookieFile.exists()) {
            System.out.println("Cookie file not found boohoo :( Guhbye!!");
            System.exit(0);
        }

        // Slide 8
        ServerSocket ss = new ServerSocket(Integer.parseInt(portNumber));
        Socket socket = ss.accept();

        // Store the data sent over from client, e.g. get-cookie
        String msgReceived = "";

        // Slide 9
        try (InputStream is = socket.getInputStream()) {
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);

            try (OutputStream os = socket.getOutputStream()) {
                BufferedOutputStream bos = new BufferedOutputStream(os);
                DataOutputStream dos = new DataOutputStream(bos);

                // Write logic to receive and send. Putting the while loop here allows us to close only after everything is done. No reapeated opening and closing
                while (!msgReceived.equals("close")) {
                    // slide 9 - receive message
                    msgReceived = dis.readUTF();

                    if (msgReceived.equals("get-cookie")) {
                        // instantiate cookie.java
                        // Get random cookie 
                        // Send it back to client using DataOutputStream (dos.writeUTF(xxxxxxxx))
                    }
                }
                // close all output stream
                dos.close();
                bos.close();
                os.close();
            }
            catch (EOFException e) {
                e.printStackTrace();
                socket.close();
            }

            // close all input stream in reverse order
            dis.close();
            bis.close();
            is.close();
        }
        catch (EOFException e) {
            e.printStackTrace();
            socket.close();
            ss.close();
        }
    }
}
