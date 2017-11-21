package game.database.dao.jbdc;

import game.domain.User;

import java.sql.Connection;

public interface UserDao {

    boolean addUser(Connection connection, User user);

    User selectUserByLogin(Connection connection, String login);
}
