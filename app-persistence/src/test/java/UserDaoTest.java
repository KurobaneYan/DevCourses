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
    public void getUser() {
        User user = userDao.getUser("Alex", "Chuduk");
        Assert.assertNotNull(user);
    }
}
