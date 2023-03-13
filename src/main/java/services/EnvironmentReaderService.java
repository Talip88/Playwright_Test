package services;

import java.io.IOException;
import java.util.Properties;

public class EnvironmentReaderService {

    private static Properties props= new Properties();

    static {
        String environmentFile=System.getProperty("env");
        if (environmentFile==null){
            environmentFile="production";
        }

        String filePath=environmentFile.concat(".properties");
        try {
            props.load(EnvironmentReaderService.class.getClassLoader().getResourceAsStream(filePath));
        } catch (IOException e) {
            System.out.println("Did not manage to read properties file");
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key){
        return props.getProperty(key);
    }


}
