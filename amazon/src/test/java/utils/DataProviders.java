package utils;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
    
    @DataProvider(name = "nonExistantEmail")
    public String[][] nonExistantEmail() throws IOException
    {
        String path = System.getProperty("user.dir") + Prop.getProperties("excelPath");
        ExcelFile xl = new ExcelFile(path);

        int rownum = 5;
        int colcount = xl.getCellCount("Login", 0);

        String data[][] = new String[rownum][colcount];

        for(int i=1; i<=rownum; i++)
        {
            for(int j=1; j<colcount; j++)
            {
                data[i-1][j] = xl.getCellData("Login", i, j);
            }
        }
        return data;
    }

    @DataProvider(name = "RegisteredEmail")
    public String[][] RegisteredEmail() throws IOException
    {
        String path = System.getProperty("user.dir") + Prop.getProperties("excelPath");
        ExcelFile xl = new ExcelFile(path);

        int rownum = 7;
        int colcount = xl.getCellCount("Login", 0);

        String data[][] = new String[2][colcount];

        for(int i=6; i<=rownum; i++)
        {
            for(int j=1; j<colcount; j++)
            {
                data[i-6][j] = xl.getCellData("Login", i, j);
            }
        }
        return data;
    }

    

}
