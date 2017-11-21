package game.domain;

import javax.persistence.*;

/**
 * This class describe user statistics
 * @version 1.0
 * @author Эльдар
 */
@Entity
@Table(name = "STATISTICS")
public class UserStatistic {

    /**
     * Login is a unique user name
     * Count is the number of attempts
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(name = "login")
    private String login;
    @Column(name = "count")
    private int count;

    /**
     * Constructor with the parameters
     * @param login
     * @param count
     */
    public UserStatistic(String login, int count) {
        this.login = login;
        this.count = count;
    }

    public UserStatistic() {
    }

    /**
     * Return user name
     * @return string Login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Set user name
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Return count
     * @return int count
     */
    public int getCount() {
        return count;
    }

    /**
     * Set the user number of attempts
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserStatistic statistic = (UserStatistic) o;

        if (count != statistic.count) return false;
        return login != null ? login.equals(statistic.login) : statistic.login == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + count;
        return result;
    }
}
