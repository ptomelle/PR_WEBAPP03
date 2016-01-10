
package DAOManager;

import Domain.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class MOVDAOImpl implements MOVDAO {

    final String listaMOV = "select * from MOV";

    @Override
    public ArrayList<MOV> getListaMOV() throws SQLException {
        Connection con ;
        con = DAOMan.getConnection();

        ArrayList<MOV> lm = new ArrayList<MOV>();
        PreparedStatement pst = con.prepareStatement(listaMOV);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            MOV m = mapRowToMOV(rs);
            lm.add(m);
        }
        return lm;

    }

    @Override
    public int numMOV() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<MOV> getListaMOVMaggioriDi(BigDecimal soglia) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public MOV getMOVbyID(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delByID(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    final String updatebyID = "update CCN set saldo=saldo+? where id =? ";
    final String addMOV = "insert into MOV (id,codintest,descr,coddest,importo,data) values(?,?,?,?,?,?)";

    @Override
    public void add(MOV m) throws SQLException {
        // aggiunge il movimento e aggiorna il saldo corrispondente

        Connection con = DAOMan.getConnection();
        PreparedStatement pstu = con.prepareStatement(updatebyID);
        PreparedStatement psta = con.prepareStatement(addMOV);

        try {
            con.setAutoCommit(false);
            psta.setInt(1, m.getId());
            psta.setInt(2, m.getCodintest());
            psta.setString(3, m.getDescr());
            psta.setInt(4, m.getCoddest());  // BNULL ????
            psta.setBigDecimal(5, m.getImporto());
            psta.setString(6, m.getData());
            psta.execute();

            pstu.setBigDecimal(1, m.getImporto());
            pstu.setInt(2, m.getCodintest());
            pstu.execute();

            con.commit();

        } catch (SQLException e) {

            con.rollback();
            throw (e);

        } finally {

            con.setAutoCommit(true);
        }
    }

    // aggiungi un MOV con ID autogenerato 
    public void addAuto(MOV m)throws SQLException{
            // aggiunge il movimento e aggiorna il saldo corrispondente

        Connection con = DAOMan.getConnection();
        PreparedStatement pstu = con.prepareStatement(updatebyID);
        PreparedStatement psta = con.prepareStatement(addMOV);
        PreparedStatement pstc=con.prepareStatement("select max(id) from MOV");

        try {
            
            con.setAutoCommit(false);
            
            ResultSet rs = pstc.executeQuery();
            rs.next();
            int maxID;
            maxID=rs.getInt(1);
            if (rs.wasNull())
                maxID=100;      // gestione NULL
            
            
            m.setId(maxID+1);
            
            psta.setInt(1, m.getId());
            psta.setInt(2, m.getCodintest());
            psta.setString(3, m.getDescr());
            psta.setInt(4, m.getCoddest());  // BNULL ????
            psta.setBigDecimal(5, m.getImporto());
            psta.setString(6, m.getData());
            psta.execute();

            pstu.setBigDecimal(1, m.getImporto());
            pstu.setInt(2, m.getCodintest());
            pstu.execute();

            con.commit();

        } catch (SQLException e) {

            con.rollback();
            throw (e);

        } finally {

            con.setAutoCommit(true);
        }    
    };
    
    @Override
    public void updateByID(MOV cc) {
    }

   //   public MOV(int id, int codintest, String descr, int coddest, BigDecimal importo, String data) {
    private MOV mapRowToMOV(ResultSet rs) throws SQLException {
        return new MOV(
                rs.getInt("id"),
                rs.getInt("codintest"),
                rs.getString("descr"),
                rs.getInt("coddest"),
                rs.getBigDecimal("importo"),                
                rs.getString("data")

        );
    }

}
