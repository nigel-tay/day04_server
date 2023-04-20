package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cookie {
    List <String> cookies = null;

    public void readCookieFile(String fileName) throws FileNotFoundException, IOException {
        // Instantiate cookies collection object
        cookies = new ArrayList<>();

        // Use a File object to pass the fileName
        File newFile = new File(fileName);

        // Use FileReader and BufferedReader for reading from cookie file
        // Instantiate FileReader and BufferedReader
        FileReader fr = new FileReader(newFile);
        BufferedReader br = new BufferedReader(fr);
        String currentLine = "";
        // While loop to go through the file
        // Read each line and add into the cookies collection object
        while((currentLine = br.readLine()) != null) {
            cookies.add(currentLine);
        }

        // Close fr and br
        br.close();
        fr.close();
    }

    public String getRandomCookie() {
        // Use Math random function to get random item from cookies collection object
        Random random = new Random();

        // Check if cookies collection has been loaded
        // If cookies collection is loaded, generate and return random cookie
        if (cookies == null) {
            return "No cookies...";
        }
        else {
            String randomCookie = cookies.get(random.nextInt(cookies.size()));
            return randomCookie;
        }
    }
}
