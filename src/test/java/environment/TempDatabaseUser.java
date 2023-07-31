package environment;

import static environment.EnvVariables.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class TempDatabaseUser {

  public final static String DATABASE_TEST_USER = "test-admin" + UUID.randomUUID();
  public final static String DATABASE_TEST_USER_PASSWORD = "test-admin" + UUID.randomUUID();
  public final static String DATABASE_TEST_USER_TOKEN = "test-admin" + UUID.randomUUID();
  public final static String DATABASE_TEST_USER_ROLE = "app-admin";

  public static void SetTestUser(){
    try(Connection dbConnection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER_NAME, DATABASE_PASSWORD)){
      String sqlPattern = "INSERT INTO users (username, api_access_token, role) VALUES (?, ?, ?)";
      PreparedStatement sqlStatement = dbConnection.prepareStatement(sqlPattern);
      sqlStatement.setString(1, DATABASE_TEST_USER);
      sqlStatement.setString(2, DATABASE_TEST_USER_TOKEN);
      sqlStatement.setString(3, DATABASE_TEST_USER_ROLE);
      sqlStatement.executeUpdate();
    } catch (SQLException e) {
      System.err.print(e);
    }
  }

  public static void RemoveTestUser(){
    try(Connection dbConnection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER_NAME, DATABASE_PASSWORD)){
      String sqlPattern = "DELETE FROM users WHERE username=? AND api_access_token=?";
      PreparedStatement sqlStatement = dbConnection.prepareStatement(sqlPattern);
      sqlStatement.setString(1, DATABASE_TEST_USER);
      sqlStatement.setString(2, DATABASE_TEST_USER_TOKEN);
      sqlStatement.executeUpdate();
    } catch (SQLException e) {
      System.err.print(e);
    }
  }

  public static void SetTempAdminToken(){
    try(Connection dbConnection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER_NAME, DATABASE_PASSWORD)){
      String sqlPattern = "UPDATE users SET api_access_token=? WHERE username=?";
      PreparedStatement sqlStatement = dbConnection.prepareStatement(sqlPattern);
      sqlStatement.setString(1, DATABASE_ADMIN_TEMP_TOKEN);
      sqlStatement.setString(2, DATABASE_ADMIN_USER);
      sqlStatement.executeUpdate();
    } catch (SQLException e) {
      System.err.print(e);
    }
  }

  public static void ClearTempAdminToken(){
    try(Connection dbConnection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER_NAME, DATABASE_PASSWORD)){
      String sqlPattern = "UPDATE users SET api_access_token=? WHERE username=?";
      PreparedStatement sqlStatement = dbConnection.prepareStatement(sqlPattern);
      sqlStatement.setString(1, null);
      sqlStatement.setString(2, DATABASE_ADMIN_USER);
      sqlStatement.executeUpdate();
    } catch (SQLException e) {
      System.err.print(e);
    }
  }

}
