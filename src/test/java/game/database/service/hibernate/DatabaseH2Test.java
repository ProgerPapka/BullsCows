package game.database.service.hibernate;

import game.domain.User;
import game.domain.UserStatistic;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.*;

public class DatabaseH2Test {

    private static User user;
    private static UserStatistic statistic;
    private static UserStatistic statistic2;

    @BeforeClass
    public static void init() {
        user = new User("Masha", "123");
        statistic = new UserStatistic("Masha", 7);
        statistic2 = new UserStatistic("Masha", 9);
    }

    @Test
    public void testStatistics() throws Exception {
        assertTrue(DatabaseH2.addStatistic(statistic));
        assertTrue(DatabaseH2.addStatistic(statistic2));
        int statistic = DatabaseH2.getStatistics();
        assertEquals(statistic,8);
    }

    @Test
    public void testUser() throws Exception {
        assertTrue(DatabaseH2.addUser(user));
        User u = DatabaseH2.getUser("Masha");
        assertEquals(user, u);
    }

}