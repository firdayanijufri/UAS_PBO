import java.sql.*;
import java.util.*;

/**
 *
 * @author windows
 */
public abstract class ProfileImpl implements ProfileServices {

    @Override
    public Profil insert(Profil UAS) throws SQLException {
        PreparedStatement st = KoneksiDb.getConnection().prepareStatement("insert into biodata values(?,?,?,?,?)");
        st.setString(1, UAS.getId());
        st.setString(2, UAS.getNama());
        st.setString(3, UAS.getJk());
        st.setString(4, UAS.getAlamat());
        st.setString(5, UAS.getEmail());
        st.executeUpdate();



        return UAS;
    }

    @Override
    public void update(Profil UAS) throws SQLException {
        PreparedStatement st = KoneksiDb.getConnection().prepareStatement("update biodata set nama=?,alamat=?,jk=?,email=? where nomhs=?");

        st.setString(1, UAS.getNama());
        st.setString(3, UAS.getAlamat());
        st.setString(4, UAS.getJk());
        st.setString(5, UAS.getEmail());
        st.setString(3, UAS.getId());
        st.executeUpdate();

    }
    
    public void delete(int id) throws SQLException {
        PreparedStatement st = KoneksiDb.getConnection().prepareStatement("delete from biodata where id=?");
        st.setInt(1, id);
        st.executeUpdate();
    }

    @Override
    public List getAll() throws SQLException {
        Statement st = KoneksiDb.getConnection().createStatement();
        ResultSet rs = st.executeQuery("select * from biodata");
        List list = new ArrayList();
        while (rs.next()) {
            Profil p = new Profil();
            p.setId(rs.getString("id"));
            p.setNama(rs.getString("nama"));
            p.setJk(rs.getString("jk"));
            p.setAlamat(rs.getString("alamat"));
            p.setEmail(rs.getString("email"));
            list.add(p);
        }
        return list;
    }
}
