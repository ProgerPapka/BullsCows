package game.database.dao.jbdc.h2;

import game.database.dao.jbdc.StatisticDao;
import game.domain.UserStatistic;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImplStatisticDao implements StatisticDao {

    private static Logger logger = Logger.getLogger(ImplStatisticDao.class);

    @Override
    public boolean addStatistic(Connection connection, UserStatistic statistic) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(
                    "INSERT INTO STATISTICS (login, count) VALUES  (?,?)");
            stmt.setString(1, statistic.getLogin());
            stmt.setInt(2, statistic.getCount());
            logger.info("Statistic put to database");
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
    public List<UserStatistic> selectStatistics(Connection connection) {
        ResultSet list = null;
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(
                    "SELECT count FROM STATISTICS");
            list = stmt.executeQuery();
            List<UserStatistic> statistics = new ArrayList<>();
            while (list.next()) {
                statistics.add(new UserStatistic(
                        list.getString("login"),
                        list.getInt("count")
                ));
            }
            logger.info("Statistics got from database");
            return statistics;
        } catch (SQLException e) {
            logger.error(e);
        }
        finally {
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
        }
        return Collections.emptyList();
    }
}
