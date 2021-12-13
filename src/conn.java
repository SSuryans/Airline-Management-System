import java.sql.*;
public class conn {
    Connection c; /*conn in notebook*/
    Statement s; /*stmt in notebook*/
    public conn() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconect=true&useSSL=false","root","su@111000");
            s=c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
