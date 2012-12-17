import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: 51ibm
 * Date: 12-11-25
 * Time: 下午3:22
 * To change this template use File | Settings | File Templates.
 */
public class parkingBoyTest {
    ParkingBoy PB ;
    @Before
    public void Init() {
        ArrayList<ParkPlace>  AL = new    ArrayList<ParkPlace>();
        AL.add(new ParkPlace(1));
        AL.add(new ParkPlace(1));
        PB = new ParkingBoy(AL);
    }
    @Test
    public void parkingBoy_Parking_HavePlace()  {
        Ticket proof =  PB.parking(new Car());
        Assert.assertNotNull(proof);
    }
    @Test
    public void parkingBoy_Parking_HavePlace_SmartChooseParkPlace()  {
        PB.SetIChooseParkPlaceMethod(new SmartChooseParkPlaceMethod());
        Ticket proof =  PB.parking(new Car());
        Assert.assertNotNull(proof);
    }
    @Test   ( expected = NoPlaceException.class)
    public void parkingBoy_Parking_NoPlace() {

        PB.parking(new Car());
        PB.parking(new Car());

        PB.parking(new Car());
    }
    @Test
    public void parkingBoy_GetCar()  {

        Car C = new Car();
        Ticket proof =  PB.parking(C);
        Assert.assertSame(C ,PB.getCar(proof));
    }
    @Test ( expected = NoCarException.class)
    public void parkingBoy_GetCar_NoThisCar()  {
        Car C = new Car();
        Ticket proof =  PB.parking(C);
        PB.getCar(proof);
        PB.getCar(proof);
    }
}
