import java.sql.*;

public class Transaction{

    public static void main(String a[]){
        Connection con = null;
        try{
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb",
                "root",
                "bhakti"
            );

            con.setAutoCommit(false);

            PreparedStatement deduct = con.prepareStatement("UPDATE Bank SET Balance = Balance - ? WHERE AccountID= ?");
            deduct.setInt(1,50);
            deduct.setInt(2,5);
            deduct.executeUpdate();

           // int z = 5/0; 

            PreparedStatement add = con.prepareStatement("UPDATE Bank SET Balance = Balance + ? WHERE AccountID = ?");
            add.setInt(1,50);
            add.setInt(2,4);
            add.executeUpdate();

            con.commit();
            System.out.println("Transaction Successful");

            con.close();

        } catch(Exception e){
            System.out.println("Transaction Failed: " + e);
            try{
                con.rollback();
                System.out.println("Rollback Done");
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
            


    }
}