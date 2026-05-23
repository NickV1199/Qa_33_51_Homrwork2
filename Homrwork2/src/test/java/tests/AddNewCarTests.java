package tests;

import models.Car;
import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends TestBase {


    @BeforeClass
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().setEmail("bobthebobert@gmail.com").setPassword("Bobert123!"));
            app.getHelperUser().submit();
            logger.info("Before method finished logout");
        }
    }



    @Test
    public void addNewCarSuccess(){
        logger.info("Start test with name 'addNewCarSuccess'");
        logger.info("Test login data --->  email: 'bobthebobert@gmail.com' & password: 'Bobert123!'");

        int i = new Random().nextInt(1000)+1000;
        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Opel")
                .model("Astra")
                .year("2025")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNumber("678-900-"+i)
                .price(50)
                .about("Nice car")
                .build();

        logger.info("Test car data --->  location: 'Tel Aviv, Israel', manufacture: 'Opel', model: 'Astra', year: '2025', fuel: 'Petrol', seats: '4', carClass: 'C', carRegNumber: '678-900-" + i + "', price: '50', about: 'Nice car'");


        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        //app.getHelperCar().attachPhoto("ссылка на папку");
        app.getHelperCar().submitCarForm();

        logger.info("New car added");

    }

}
