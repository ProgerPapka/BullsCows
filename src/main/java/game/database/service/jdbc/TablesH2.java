package game.database.service.jdbc;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class allows you to delete and create the tables.
 *
 * @author Эльдар
 * @version 1.0
 */
class TablesH2 {

    private static Logger logger = Logger.getLogger(TablesH2.class);

    static void createUserTable(Connection connection) {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE USERS (login varchar(255) NOT NULL, password varchar(255) NOT NULL);");

            //stmt.executeUpdate("INSERT INTO USERS (login, password) VALUES ('Eldar','2002')");

        } catch (SQLException e) {
            logger.error(e);
        }finally {
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
        }
    }

    static void createStatisticsTable(Connection connection) {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE STATISTICS (login varchar(255) NOT NULL," +
                    " count integer NOT NULL);");

            //stmt.executeUpdate("INSERT INTO STATISTICS (login, count) VALUES ('Eldar',7)");

        } catch (SQLException e) {
            logger.error(e);
        }finally {
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
        }
    }

    static void deleteUserTable(Connection connection) {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.execute("DROP TABLE USERS");
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
        }
    }

    static void deleteStatisticsTable(Connection connection) {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.execute("DROP TABLE STATISTICS");
        } catch (SQLException e) {
            logger.error(e);
        }finally {
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
        }
    }

}
