

package (Name of your package);

/**
 *
 * 
 */
import java.sql.*;

public class DataBase {

    private Connection con;

    private Statement stm;

   public DataBase(){
   }

   public void connect(){
       try{
		// register of JDBC driver by Mysql
        Class.forName("com.mysql.jdbc.Driver").newInstance();

        // openning connection
        con = DriverManager.getConnection("jdbc:mysql://localhost","root"/*username*/,"root"/*password*/);
        
        stm = con.createStatement();

      }
       catch(SQLException e){
           System.out.println(e.getMessage());
       }
       catch(ClassNotFoundException c){
           System.out.println(c.getMessage());
       }
        catch(InstantiationException i){
            System.out.println(i.getMessage());
       }
        catch(IllegalAccessException il){
            System.out.println(il.getMessage());
       }
   }
   public int inclusion(String sql){
        try{
        return stm.executeUpdate(sql);
        }
        catch (SQLException e){
            return -1;
        }
   }
   
   public int exclusion(String sql){
       try{
        return stm.executeUpdate(sql);
        }
        catch (SQLException e){
            return -1;
        }
   }

   
   public void disconnect(){
       try{
            con.close();
        }catch(SQLException sqlex){
            System.out.println("Connection Error "+ sqlex);
        }
   }

   public ResultSet search(String sql){
       try{
		 // executes a select command and receives the return on resultset

         return stm.executeQuery(sql);


        }
        catch (SQLException e){
           return null;
        }
   }

}
