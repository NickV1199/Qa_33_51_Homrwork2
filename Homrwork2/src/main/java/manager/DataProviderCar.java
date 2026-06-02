package manager;

import models.Car;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DataProviderCar {


   @DataProvider
    public Iterator<Object[]> carsCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("Homrwork2/src/test/resources/cars"));
        String line = reader.readLine();
        while (line !=null){
            String[]all= line.split(",");
            list.add(new Object[]{Car.builder()
                    .manufacture(all[0])
                    .model(all[1])
                    .year(all[2])
                    .fuel(all[3])
                    .seats(Integer.parseInt(all[4]))
                    .carClass(all[5])
                    .carRegNumber(all[6])
                    .price(Double.parseDouble(all[7]))
                    .about(all[8])
                    .build()});
            line = reader.readLine();
        }
        return list.iterator();
    }

}
