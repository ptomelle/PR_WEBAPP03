package DAOManager;

import java.sql.*;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;



public class DAOMan {


    final static String ClassMysql = "com.mysql.jdbc.Driver";
    final static String ClassPostgres = "org.postgresql.Driver";
    final static String ClassDerby = "org.apache.derby.jdbc.ClientDriver";

    final static String connMysql = "jdbc:mysql://172.16.6.53/CCP_DB?user=admindb&password=admindb";
    final static String connPostgres = "jdbc:postgresql://172.16.6.53/DB_CCP?user=admindb&password=quintabi";
    final static String connDerby = "jdbc:derby://localhost:1527/CCP_DB;user=admindb;password=admindb";

    final static String URLMYSQL = "jdbc:mysql://localhost/ccp_db";
    final static String URLPOSTGRES = "jdbc:postgresql://172.16.6.53/DB_CCP";
    final static String URLDERBY = "jdbc:derby://localhost:1527/CCN_DB";

    static BasicDataSource ds=null;

    public DAOMan() {
        ds = new BasicDataSource();
        //ds.setDriverClassName(ClassMysql);
        ds.setDriverClassName(ClassDerby);
        //ds.setUrl(URLMYSQL);
        ds.setUrl(URLDERBY);
        ds.setUsername("admindb");
        ds.setPassword("admindb");
        
        
    }

    public static Connection getConnection() {
        Connection con = null;

        try {
            con = ds.getConnection();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return con;
    }

    public static MOVDAO movDAO = new MOVDAOImpl();
    public static CCNDAO ccnDAO = new CCNDAOImpl();

}
