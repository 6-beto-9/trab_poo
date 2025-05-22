package src;

import java.io.*;
import java.util.*;

public class ConfigLoader {
    public static List<Property> loadConfig(String path) throws IOException {
        List<Property> properties = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("src/gameConfig.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.trim().split("\\s+");
            int sell = Integer.parseInt(parts[0]);
            int rent = Integer.parseInt(parts[1]);
            properties.add(new Property(sell, rent));
        }
        br.close();
        return properties;
    }
}
