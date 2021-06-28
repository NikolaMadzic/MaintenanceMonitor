package fh.technikum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RestController_Test {
    @Test
    public void statusMeldung_Test(){
        //Arrange
        RestController rctest = new RestController();
        String erwarten = "testFall";
        String wert;
        //Act
        wert = rctest.statusMeldung("testFall");
        //Assert
        Assertions.assertEquals(erwarten, wert);
    }

    @Test
    public void maintenanceMode_Test(){
        //Arrange
        RestController rctest = new RestController();
        String erwarten = rctest.statusMeldung("testobjekt");
        String wert;
        //Act
        wert = rctest.maintenanceMode().getEntity().toString();
        //Assert
        Assertions.assertEquals(erwarten, wert);

    }
}
