package game.database.dao.jbdc;

import game.domain.UserStatistic;

import java.sql.Connection;
import java.util.List;

public interface StatisticDao {

    boolean addStatistic(Connection connection, UserStatistic statistic);

    List<UserStatistic> selectStatistics(Connection connection);
}
