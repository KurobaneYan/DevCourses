import com.netcracker.sd4.persistence.api.dao.impl.CarDao;
import com.netcracker.sd4.persistence.configuration.PersistenceConfiguration;
import com.netcracker.sd4.persistence.domain.Car;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceConfiguration.class)
@Transactional
public class CarDaoTest {
    private final String MODEL = "model XKR";
    private final String ANOTHER_MODEL = "super new XR";
    private final String MANUFACTURER = "My favorite MMM";
    private final String BODY_STYLE = "MY Style";
    private final int PRICE = 1000000;
    private final int YEAR = 2016;
    private final int AMOUNT_LEFT = 100;

    @Autowired
    private CarDao carDao;

    @Before
    public void setUp() {
        Car car = new Car();
        car.setModel(MODEL);
        car.setManufacturer(MANUFACTURER);
        car.setBodyStyle(BODY_STYLE);
        car.setAmountLeft(AMOUNT_LEFT);
        car.setPrice(PRICE);
        car.setProductionYear(YEAR);
        carDao.add(car);
    }

    @Test
    public void testGetCar() {
        Car car = carDao.getCarByModel(MODEL);
        Assert.assertNotNull(car);
    }

    @Test
    public void testAddCar() {
        Car car = new Car();
        car.setModel(ANOTHER_MODEL);
        car.setManufacturer(MANUFACTURER);
        car.setBodyStyle(BODY_STYLE);
        car.setAmountLeft(AMOUNT_LEFT);
        car.setPrice(PRICE);
        car.setProductionYear(YEAR);
        carDao.add(car);
        Assert.assertNotNull(carDao.getCarByModel(ANOTHER_MODEL));
    }

    @Test
    public void testUpdateCar() {
        Car car = carDao.getCarByModel(MODEL);
        car.setModel(MODEL + "2");
        carDao.update(car);
        Assert.assertNotNull(carDao.getCarByModel(MODEL + "2"));
    }

    @Test(expected = NoResultException.class)
    public void testDeleteCountry() {
        Car car = carDao.getCarByModel(MODEL);
        carDao.delete(car);
        carDao.getCarByModel(MODEL);
    }

    @Test
    public void testGetAllCars() {
        List<Car> allEntities = carDao.getAll(Car.class);
        Assert.assertTrue(allEntities.size() > 0);
    }
}
