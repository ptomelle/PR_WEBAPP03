package DAOManager;

import Domain.CCN;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class CCNDAOImpl implements CCNDAO {

    final String listaCCN = "SELECT * FROM CCN";

    @Override
    public ArrayList<CCN> getListaCCN() throws SQLException {
        Connection con;
        con = DAOMan.getConnection();

        ArrayList<CCN> lcc = new ArrayList<CCN>();
        PreparedStatement pst = con.prepareStatement(listaCCN);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            CCN c = mapRowToCCN(rs);
            lcc.add(c);
        }
        return lcc;
    }

    final String numCCN = "select count(*) as totale from CCN";

    @Override
    public int numCCN() throws SQLException {
        Connection con;
        con = DAOMan.getConnection();
        PreparedStatement pst = con.prepareStatement(numCCN);
        ArrayList<CCN> lcc = new ArrayList<CCN>();

        ResultSet rs = pst.executeQuery();
        rs.next();
        int n = rs.getInt("totale");
        return n;

    }

    final String listaCCNMaggioriDi = "select * from CCN where saldo > ? ";

    @Override
    public ArrayList<CCN> getListaCCNMaggioriDi(BigDecimal soglia) throws SQLException {
        Connection con;
        con = DAOMan.getConnection();
        PreparedStatement pst = con.prepareStatement(listaCCNMaggioriDi);
        pst.setBigDecimal(1, soglia);

        ArrayList<CCN> lcc = new ArrayList<CCN>();
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            CCN c = mapRowToCCN(rs);
            lcc.add(c);
        }
        return lcc;
    }

    final String CCNbyID = "select * from CCN where id= ? ";

    @Override
    public CCN getCCNbyID(int id) throws SQLException {
        Connection con;
        con = DAOMan.getConnection();
        PreparedStatement pst = con.prepareStatement(CCNbyID);
        pst.setInt(1, id);
        CCN cc;
        ResultSet rs = pst.executeQuery();

        rs.next();
        cc = mapRowToCCN(rs);
        return cc;
    }

    final String deletebyID = "delete  from CCN where id= ? ";

    @Override
    public void delByID(int id) throws SQLException {
        Connection con;
        con = DAOMan.getConnection();
        PreparedStatement pst = con.prepareStatement(deletebyID);
        pst.setInt(1, id);
        pst.executeQuery();
    }

    //  public CCN(int id, String intestatario, String dataapertura, BigDecimal saldo) {
    final String addbyID = "insert into CCN values (?,?,?,?) ";

    @Override
    public void add(CCN cc) throws SQLException {
        Connection con;
        con = DAOMan.getConnection();
        PreparedStatement pst = con.prepareStatement(addbyID);
        pst.setInt(1, cc.getId());
        pst.setString(2, cc.getIntestatario());
        pst.setString(1, cc.getDataapertura());
        pst.setBigDecimal(4, cc.getSaldo());
        pst.executeQuery();
    }

    final String updatebyID = "update CCN set Intestatrio=?,DataAPertura=? Saldo=? where id =? ";
    @Override
    public void updateByID(CCN cc) throws SQLException {
        Connection con;
        con = DAOMan.getConnection();
        PreparedStatement pst = con.prepareStatement(updatebyID);

        pst.setString(1, cc.getIntestatario());
        pst.setString(2, cc.getDataapertura());
        pst.setBigDecimal(3, cc.getSaldo());

        pst.setInt(4, cc.getId());
        pst.executeQuery();

    }

    //  public CCN(int id, String intestatario, String dataapertura, BigDecimal saldo) {
    private CCN mapRowToCCN(ResultSet rs) throws SQLException {
        return new CCN(
                rs.getInt("id"),
                rs.getString("intestatario"),
                rs.getString("dataapertura"),
                rs.getBigDecimal("saldo")
        );
    }
}
