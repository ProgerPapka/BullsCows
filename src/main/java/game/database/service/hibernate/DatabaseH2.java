package game.database.service.hibernate;

import game.database.dao.hibernate.StatisticDao;
import game.database.dao.hibernate.UserDao;
import game.domain.User;
import game.domain.UserStatistic;

import java.util.List;

public class DatabaseH2 {

    private static UserDao userDao = new UserDao();
    private static StatisticDao statisticDao = new StatisticDao();

    public static boolean addUser(User user) {
        return userDao.addUser(user);
    }

    public static boolean addStatistic(UserStatistic statistic) {
        return statisticDao.addStatistic(statistic);
    }

    public static int getStatistics() {
        List<UserStatistic> statistics = statisticDao.getAllStatistic();
        if (statistics.isEmpty()){
            return 0;
        }
        int sum = 0;
        for (UserStatistic statistic : statistics) {
            sum += statistic.getCount();
        }
        return sum / statistics.size();
    }


    public static User getUser(String login) {
        return userDao.getUserByLogin(login);
    }
}
