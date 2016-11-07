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

    @Autowired
    private CarDao carDao;

    @Before
    public void setUp() {
        Car car = new Car();
        car.setModel("Lancer");
        car.setManufacturer("Mitsubishi");
        car.setBodyStyle("cool");
        car.setAmountLeft(3);
        car.setPrice(70000);
        car.setProductionYear(2016);
        carDao.addCar(car);
    }

    @Test
    public void testGetCar() {
        Car car = carDao.getCar("Lancer");
        Assert.assertNotNull(car);
    }

    @Test
    public void testAddCar() {
        Car car = new Car();
        car.setModel("Starwagon");
        car.setManufacturer("Mitsubishi");
        car.setBodyStyle("star");
        car.setAmountLeft(32);
        car.setPrice(10000);
        car.setProductionYear(2010);
        carDao.addCar(car);
        Assert.assertNotNull(carDao.getCar("starwagon"));
    }

    @Test
    public void testUpdateCar() {
        Car car = carDao.getCar("Lancer");
        car.setModel("Lancer!!!");
        carDao.updateCar(car);
        Assert.assertNotNull(carDao.getCar("Lancer!!!"));
    }

    @Test(expected = NoResultException.class)
    public void testDeleteCountry() {
        Car car = carDao.getCar("Lancer");
        carDao.deleteCar(car);
        carDao.getCar("Lancer");
    }

    @Test
    public void testGetAllCars() {
        List<Car> allEntities = carDao.getAllEntities(Car.class);
        Assert.assertTrue(allEntities.size() > 0);
    }
}
