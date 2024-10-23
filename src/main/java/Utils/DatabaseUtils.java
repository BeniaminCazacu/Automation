package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv; //


public class DatabaseUtils {

    private static final Dotenv dotenv = Dotenv.load(); //

    public static String getDbUrl() {

        String url = dotenv.get("DB_URL");

        if (url == null) {
            throw new IllegalStateException("Environment variable DB_URL is not set.");
        }

        return url;
    }

    public static String getDbUser() {

        String user = dotenv.get("DB_USER");

        if (user == null) {
            throw new IllegalStateException("Environment variable DB_USER is not set.");
        }

        return user;
    }

    public static String getDbPassword() {

        String password = dotenv.get("DB_PASSWORD");

        if (password == null) {
            throw new IllegalStateException("Environment variable DB_PASSWORD is not set.");
        }

        return password;
    }

    public static String getDbOrganizationId() {

        String organisationID = dotenv.get("DB_ORG_ID");

        if (organisationID == null) {
            throw new IllegalStateException("Environment variable DB_ORG_ID is not set.");
        }

        return organisationID;
    }

    public static void deleteVenueByOrganisationId(String organisationId) {
        String query = "DELETE FROM venues WHERE organisationId = ?";

        System.out.println("Deleting from db organization " + organisationId);

        try (Connection connection = DriverManager.getConnection(getDbUrl(), getDbUser(), getDbPassword()); //
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, organisationId);
            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println("Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        deleteVenueByOrganisationId(getDbOrganizationId()); //
    }
}
