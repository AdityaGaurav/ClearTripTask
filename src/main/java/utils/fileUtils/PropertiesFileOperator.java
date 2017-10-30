package utils.fileUtils;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileOperator {

    private final static String testProperties = "build.props";
    private static String userDirectoryPath = System.getProperty("user.dir");
    private static String seperator = File.separator;
    private static String testpropsFilePath = new File(userDirectoryPath).getAbsolutePath() + seperator + "src"+seperator+"test"+seperator+"testresources"+seperator+testProperties;
    private static Properties props;

    private static void loadProperties() {
        try {
            FileReader reader = new FileReader(testpropsFilePath);
            props = new Properties();
            props.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTestProperties(String property) throws Exception{
        if (props == null) {
            loadProperties();
        }
        if (property.trim().length() == 0) {
                   throw new Exception("Given Property is empty. Please provide correct property name");
        }
        return props.getProperty(property);
    }

    public static String getBrowserName() {
        if (props == null) {
            loadProperties();
        }
        return props.getProperty("browserName");
    }

    public static String getURLName() {
        if (props == null) {
            loadProperties();
        }
        return props.getProperty("URL");
    }

    public static String getHostName() {
        if (props == null) {
            loadProperties();
        }
        return props.getProperty("hostName");
    }
    public static String getTestpropsFilePath(){
        if (props == null) {
            loadProperties();
        }
        return props.getProperty("");
    }
}
