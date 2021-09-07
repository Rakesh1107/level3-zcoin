package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnector {

    private static String url = "jdbc:mysql://localhost:3306/zcoin?autoReconnect=true&useSSL=false";
    private static String user = "root";
    private static String password = "1234";
    static Connection connection;
    
    public static Connection createConnection() {
		try {
            if(connection == null) {
            	Class.forName("com.mysql.jdbc.Driver");
                
                connection = DriverManager.getConnection(url, user, password);
            }
			
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		return connection;
		  
	}
    
    

    public static void addUser(Customer customer) throws CustomException {
        try (PreparedStatement preparedStatement = createConnection().prepareStatement("insert into users values (?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, customer.getFullName());
            preparedStatement.setString(2, customer.getEmailId());
            preparedStatement.setLong(3, customer.getMobileNumber());
            preparedStatement.setInt(4, customer.gethID());
            preparedStatement.setString(5, customer.getPassword());
            preparedStatement.setLong(6, customer.getBalance());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new CustomException("Inserting user records failed");
        }
    }



	public static void updatePassword(int hid, String newPassword) throws CustomException {
		
		try (PreparedStatement preparedStatement = createConnection().prepareStatement("update users set password = ? where hid = ?")) {
            preparedStatement.setString(1, password);
            preparedStatement.setInt(2, hid);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new CustomException("Changing Password failed");
        }
	}

	
}
