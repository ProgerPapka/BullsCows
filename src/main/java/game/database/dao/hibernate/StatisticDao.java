package game.database.dao.hibernate;

import game.database.service.hibernate.SessionUtil;
import game.domain.UserStatistic;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

public class StatisticDao extends SessionUtil{

    private static Logger logger = Logger.getLogger(StatisticDao.class);

    public boolean addStatistic(UserStatistic statistic){
        try {
            Session session = openTransactionSession();
            session.save(statistic);
            closeTransactionSesstion();
            logger.info("Statistic put to game.database");
            return true;
        } catch (Throwable e) {
            logger.error(e);
        }
        return false;
    }

    public List<UserStatistic> getAllStatistic(){
        try {
            openTransactionSession();
            String sql = "SELECT * FROM STATISTICS";
            Session session = getSession();
            Query query = session.createNativeQuery(sql).addEntity(UserStatistic.class);
            List<UserStatistic> statistics = query.list();
            closeTransactionSesstion();
            logger.info("All statistic got from game.database");
            return statistics;
        } catch (Throwable e){
            logger.error(e);
        }
        return Collections.emptyList();
    }
}
