import java.sql.SQLException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public interface ProfileServices {
    Profil insert(Profil UAS) throws SQLException;
    void update(Profil UAS) throws SQLException;
    void delete(String id) throws SQLException;
    List getAll() throws SQLException;
}
