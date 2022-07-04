package Xml;
import org.testng.annotations.DataProvider;
import java.io.IOException;
public class ExcelDataProvider {
    @DataProvider(name="DaTa")
    public Object[][] testData() throws IOException {
        DataTestNG ex =new DataTestNG();
        ex.data();
        int row = ex.a;
        int col = ex.b;
        System.out.println(row+"     "+col);
        Object[][] arr = new Object[row][2];
        int ij=0;
        for (int i=1;i<=row;i++,ij++){
            String data1= ex.getData(i,0);
            String data2= ex.getData(i,1);
            arr[ij][0]= data1;
            arr[ij][1] = data2;
            System.out.println(data1+"\t"+data2);
        }
        return arr;
    }
    }

