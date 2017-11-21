package game.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class describe authorize users
 * @version 1.0
 * @author Эльдар
 */
@Entity
@Table(name = "USERS")
public class User {

    /**
     * Login is a unique user name
     * Password need to log on to the website
     */
    @Id
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    /**
     * Constructor with the parameters
     * @param login
     * @param password
     */
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {
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
     * Return password
     * @return string password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set user password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null)
            return false;
        return password != null ? password.equals(user.password) : user.password == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
