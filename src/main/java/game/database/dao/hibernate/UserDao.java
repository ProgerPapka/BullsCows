package game.database.dao.hibernate;

import game.database.service.hibernate.SessionUtil;
import game.domain.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserDao extends SessionUtil {

    private static Logger logger = Logger.getLogger(User.class);

    public boolean addUser(User user) {
        try {
            Session session = openTransactionSession();
            session.save(user);
            closeTransactionSesstion();
            logger.info("User put to game.database");
            return true;
        } catch (Throwable e) {
            logger.error(e);
        }
        return false;
    }

    public User getUserByLogin(String login) {
        try {
            openTransactionSession();
            String sql = "SELECT * FROM USERS WHERE login = :name";
            Session session = getSession();
            Query query = session.createNativeQuery(sql).addEntity(User.class);
            query.setParameter("name", login);
            User user = (User) query.getSingleResult();
            closeTransactionSesstion();
            logger.info("User got from game.database");
            return user;
        } catch (Throwable e){
            logger.error(e);
        }
        return null;
    }
}
