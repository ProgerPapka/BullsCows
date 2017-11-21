package game.database.service.jdbc;

import game.database.dao.jbdc.StatisticDao;
import game.database.dao.jbdc.UserDao;
import game.database.dao.jbdc.h2.ImplStatisticDao;
import game.database.dao.jbdc.h2.ImplUserDao;
import game.domain.User;
import game.domain.UserStatistic;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

/**
 * @author Эльдар
 * @version 1.0
 */
public class DatabaseH2 {

    private static Logger logger = Logger.getLogger(DatabaseH2.class);
    private static UserDao userDao = new ImplUserDao();
    private static StatisticDao statisticDao = new ImplStatisticDao();

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("Error load H2 JDBC driver" ,e);
        }
    }

    public static void createSchema() {
        try (Connection con = DriverManager.getConnection("jdbc:h2:./game", "sa", "")) {
            TablesH2.createUserTable(con);
            TablesH2.createStatisticsTable(con);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public static void deleteSchema() {
        try (Connection con = DriverManager.getConnection("jdbc:h2:./game", "sa", "")) {
            TablesH2.deleteUserTable(con);
            TablesH2.deleteStatisticsTable(con);
        } catch (Exception e) {
            logger.error(e);
        }

    }

    public static boolean addUser(User user) {
        try (Connection con = DriverManager.getConnection("jdbc:h2:./game", "sa", "")) {
            return userDao.addUser(con, user);
        } catch (Exception e) {
            logger.error(e);
        }
        return false;
    }

    public static boolean addStatistic(UserStatistic statistic) {
        try (Connection con = DriverManager.getConnection("jdbc:h2:./game", "sa", "")) {
            return statisticDao.addStatistic(con, statistic);
        } catch (Exception e) {
            logger.error(e);
        }
        return false;
    }

    public static int getStatistics() throws Exception {
        try (Connection con = DriverManager.getConnection("jdbc:h2:./game", "sa", "")) {
            List<UserStatistic> statistics = statisticDao.selectStatistics(con);
            int sum = 0;
            for (UserStatistic statistic : statistics) {
                sum += statistic.getCount();
            }
            return sum / statistics.size();
        } catch (Exception e) {
            logger.error(e);
            throw e;
        }
    }


    public static User getUser(String login) throws Exception {
        try (Connection con = DriverManager.getConnection("jdbc:h2:./game", "sa", "")) {
            return userDao.selectUserByLogin(con, login);
        } catch (Exception e) {
            logger.error(e);
            throw e;
        }
    }


}
