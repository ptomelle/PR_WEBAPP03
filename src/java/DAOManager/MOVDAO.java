
package DAOManager;

import java.sql.*;
import java.util.ArrayList;
import Domain.*;
import java.math.BigDecimal;

public interface MOVDAO {
    
    // lista dei MOV
    ArrayList<MOV> getListaMOV() throws SQLException ;
    

    //num mov 
    int numMOV()throws SQLException ;

    //lista dei movimenti importo > ....
    ArrayList<MOV> getListaMOVMaggioriDi(BigDecimal soglia) throws SQLException ;
    
    
        //----------------CRUD----------------------
    // un MOV partendo dal codice NULL se non presente
    MOV getMOVbyID(int id)throws SQLException ;

    // elimina un MOV 
    void delByID(int id)throws SQLException;
    
    // aggiungi un MOV 
    void add(MOV m)throws SQLException;
    
    // aggiungi un MOV con ID autogenerato 
    void addAuto(MOV m)throws SQLException;
    
    // modifica un MOV  utilizza come riferimento id 
    // aggiorna tutti i campi escluso id
    void updateByID (MOV cc)throws SQLException;
    
}
