import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 51ibm
 * Date: 12-11-25
 * Time: 下午4:39
 * To change this template use File | Settings | File Templates.
 */
public class ParkingBoy {
    protected List< ParkPlace> ParkPlaces = new ArrayList<ParkPlace>();
    private IChooseParkPlaceMethod  ChooseParkPlacMethodObj = new DefaultChooseParkPlacMethod() ;

    public ParkingBoy(List<ParkPlace> PPs) {
        ParkPlaces =  PPs;
    }

    public void AddParkPlace (ParkPlace PP)
    {
        ParkPlaces.add(PP);
    }

    public Ticket parking(Car c)
    {
        return  ChooseParkPlacMethodObj.ChooseParkPlace(ParkPlaces).parking(c) ;
    }

    public Car getCar(Ticket proof) {
        for (ParkPlace PP : ParkPlaces)
        {
            if(PP.HaveCar(proof))
            {
                return PP.GetParkedCar(proof);
            }
        }
        throw new NoCarException("没有此车 请拨打110！");
    }

    public void SetIChooseParkPlaceMethod(SmartChooseParkPlaceMethod smartChooseParkPlaceMethod) {
        this.ChooseParkPlacMethodObj = smartChooseParkPlaceMethod;
    }
}
