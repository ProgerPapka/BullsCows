package game.database.dao.jbdc.h2;

import game.database.dao.jbdc.UserDao;
import game.domain.User;
import org.apache.log4j.Logger;

import java.sql.*;

public class ImplUserDao implements UserDao {

    private static Logger logger = Logger.getLogger(ImplUserDao.class);

    @Override
    public boolean addUser(Connection connection, User user) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(
                    "INSERT INTO USERS (login, password) VALUES (?,?)");
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPassword());
            logger.info("User put to database");
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
        }
        return false;
    }

    @Override
    public User selectUserByLogin(Connection connection, String login) {
        ResultSet list = null;
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(
                    "SELECT * FROM USERS WHERE login = ?");
            stmt.setString(1, login);
            list = stmt.executeQuery();
            while (list.next()) {
                String name = list.getString("login");
                String password = list.getString("password");
                logger.info("User got from database");
                return new User(name, password);
            }
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
        }
        return null;
    }
}
