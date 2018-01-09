package utils.fileUtils;

import java.io.IOException;
import java.util.List;

public class ExcelFileUtilTest {
    public static void main(String[] args) throws IOException {
        String currentDirectory = System.getProperty("user.dir");
        String filepath=currentDirectory+"\\src\\test\\testresources\\AllFlightDetails.xls";
        List<String> output = ExcelFileUtils.readColumnsValueRowWise(filepath,"FlightDetails");
        for(String str: output){
            System.out.println(str);
        }
    }

}
