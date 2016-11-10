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
import sun.dc.pr.PRError;

import javax.persistence.NoResultException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceConfiguration.class)
@Transactional
public class UserDaoTest {
    private final String USER_NAME = "Alex";
    private final String ANOTHER_USER_NAME = "Yasn";
    private final String USER_SURNAME = "Chulukas";
    private final String ANOUTHER_USER_SURNAME = "Kurobanus";
    private final String USER_EMAIL = "";
    private final String ANOTHER_USER_EMAIL = "soem.sfger@agtsfs.erfs";
    private final String USER_PHONE = "";
    private final String ANOTHER_USER_PHONE = "100304567";

    @Autowired
    private UserDao userDao;

    @Before
    public void setUp() {
        User user = new User();
        user.setName(USER_NAME);
        user.setSurname(USER_SURNAME);
        user.setEmail(USER_EMAIL);
        user.setPhoneNumber(USER_PHONE);
        userDao.add(user);
    }

    @Test
    public void testGetUser() {
        User user = userDao.getUser(USER_NAME, USER_SURNAME);
        Assert.assertNotNull(user);
    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setName(ANOTHER_USER_NAME);
        user.setSurname(ANOUTHER_USER_SURNAME);
        user.setEmail(ANOTHER_USER_EMAIL);
        user.setPhoneNumber(ANOTHER_USER_PHONE);
        userDao.add(user);
        Assert.assertNotNull(userDao.getUser(ANOTHER_USER_NAME, ANOUTHER_USER_SURNAME));
    }

    @Test
    public void testUpdateUser() {
        User user = userDao.getUser(USER_NAME, USER_SURNAME);
        user.setName(ANOTHER_USER_NAME);
        userDao.add(user);
        Assert.assertNotNull(userDao.getUser(ANOTHER_USER_NAME, USER_SURNAME));
    }

    @Test(expected = NoResultException.class)
    public void testDeleteUser() {
        User user = userDao.getUser(USER_NAME, USER_SURNAME);
        userDao.delete(user);
        userDao.getUser(USER_NAME, USER_SURNAME);
    }

    @Test
    public void testGetAllCars() {
        List<User> allEntities = userDao.getAll(User.class);
        Assert.assertTrue(allEntities.size() > 0);
    }
}
