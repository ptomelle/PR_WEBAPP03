package DAOManager;

import java.sql.*;
import java.util.ArrayList;
import Domain.*;
import java.math.BigDecimal;

public interface CCNDAO {
    // lista dei CCN
    ArrayList<CCN> getListaCCN() throws SQLException;

    //num ccn 
    int numCCN() throws SQLException;

    //lista dei correntisti con saldo > di ....
    ArrayList<CCN> getListaCCNMaggioriDi(BigDecimal soglia) throws SQLException;

    //----------------CRUD----------------------
    // un CCN partendo dal codice 
    CCN getCCNbyID(int id) throws SQLException;

    // elimina il CCP 
    void delByID(int id) throws SQLException;

    // aggiungielimina il correntista 
    void add(CCN cc) throws SQLException;

    // modifica un CCN  utilizza come riferimento id 
    // aggiorna tutti i campi escluso id
    void updateByID(CCN cc) throws SQLException;
}
