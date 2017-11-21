package game.database.service.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static Logger logger = Logger.getLogger(HibernateUtil.class);
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory()
            throws ExceptionInInitializerError{
        try {
            return new Configuration().configure().buildSessionFactory();
        }
        catch (HibernateException e) {
            logger.error(e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        try {
            getSessionFactory().close();
        }         catch (HibernateException e) {
            logger.error(e);
        }
    }
}
