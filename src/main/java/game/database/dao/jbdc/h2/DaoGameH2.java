package game.database.dao.jbdc.h2;

import game.domain.User;
import game.domain.UserStatistic;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Deprecated
public class DaoGameH2 {

    private static Logger logger = Logger.getLogger(DaoGameH2.class);

    @Deprecated
    public static void addUser(Connection connection, User user) {
        try (Statement stmt = connection.createStatement()) {

            stmt.executeUpdate("INSERT INTO USERS (login, password) VALUES ('" +
                    user.getLogin() + "' ,'" + user.getPassword() + "')");

        } catch (SQLException e) {
            logger.error(e);
        }
    }

    @Deprecated
    public static void addStatistic(Connection connection, UserStatistic statistic) {
        try (Statement stmt = connection.createStatement()) {

            stmt.executeUpdate("INSERT INTO STATISTICS (login, count) VALUES  ('" +
                    statistic.getLogin() + "' ," + statistic.getCount() + ")");

        } catch (SQLException e) {
            logger.error(e);
        }
    }

    @Deprecated
    public static ResultSet selectStatistics(Connection connection) throws Exception {
        ResultSet list = null;
        try (Statement stmt = connection.createStatement()) {
            list = stmt.executeQuery("SELECT count FROM STATISTICS;");
            return list;
        } catch (SQLException e) {
            logger.error(e);
        }
        throw new Exception("List is empty");
    }

    @Deprecated
    public static User selectUser(Connection connection, String login) throws Exception {
        ResultSet list = null;
        try (Statement stmt = connection.createStatement()) {
            list = stmt.executeQuery("SELECT * FROM USERS WHERE (USERS.login = '" + login + "');");
            while (list.next()) {
                String name = list.getString("login");
                String password = list.getString("password");
                return new User(name, password);
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        throw new Exception("User does not exist");
    }

}
