import com.netcracker.sd4.persistence.api.dao.impl.UserDao;
import com.netcracker.sd4.persistence.configuration.PersistenceConfiguration;
import com.netcracker.sd4.persistence.domain.User;
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
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Before
    public void setUp() {
        User user = new User();
        user.setName("Alex");
        user.setSurname("Chuduk");
        user.setEmail("a4dix3@gmail.com");
        user.setPhoneNumber("1142095");
        userDao.addUser(user);
    }

    @Test
    public void testGetUser() {
        User user = userDao.getUser("Alex", "Chuduk");
        Assert.assertNotNull(user);
    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setName("Yan");
        user.setSurname("Kurobane");
        user.setEmail("yan@gmail.com");
        user.setPhoneNumber("12304424");
        userDao.addUser(user);
        Assert.assertNotNull(userDao.getUser("Yan", "Kurobane"));
    }

    @Test
    public void testUpdateUser() {
        User user = userDao.getUser("Alex", "Chuduk");
        user.setName("Yan");
        userDao.updateUser(user);
        Assert.assertNotNull(userDao.getUser("Yan", "Chuduk"));
    }

    @Test(expected = NoResultException.class)
    public void testDeleteCountry() {
        User user = userDao.getUser("Alex", "Chuduk");
        userDao.deleteUser(user);
        userDao.getUser("Alex", "Chuduk");
    }

    @Test
    public void testGetAllCars() {
        List<User> allEntities = userDao.getAllEntities(User.class);
        Assert.assertTrue(allEntities.size() > 0);
    }
}
