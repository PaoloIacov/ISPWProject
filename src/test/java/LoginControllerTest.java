
import controller.ApplicationController.CLIApplicationController;
import controller.CLIController.CLILoginController;
import model.dao.ConnectionFactory;
import model.dao.LoginDAO;
import model.domain.Credentials;
import view.CLIView.CLILoginView;
import java.sql.Connection;

import java.io.IOException;
import java.sql.SQLException;

// ConversationControllerTest class for CLILoginController and CLILoginView
public class LoginControllerTest {

    static Connection connection;
    static CLIApplicationController mockApplicationController;

    public static void main(String[] args) {
        // Mock ApplicationController
        try {
            connection = ConnectionFactory.getConnection();
            mockApplicationController = new CLIApplicationController(connection) {
                @Override
                public void onLoginSuccess(Credentials credentials) {
                    System.out.println("Login Successful! Welcome, " + credentials.getUsername());
                }

                @Override
                public void back() {
                    // Mock behavior for back navigation
                }
            };
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error establishing connection to the database.");
        }

        // Mock LoginDAO
        LoginDAO mockLoginDAO = new LoginDAO(connection) {
            @Override
            public boolean validateCredentials(Credentials credentials) throws SQLException {
                // Simulate validation: username is "testuser" and password is "testpass"
                return "testuser".equals(credentials.getUsername()) && "testpass".equals(credentials.getPassword());
            }
        };

        // ConversationControllerTest with correct credentials
        System.out.println("ConversationControllerTest Case 1: Valid Login");
        CLILoginView mockLoginViewValid = new CLILoginView() {
            @Override
            public Credentials getCredentialsInput() {
                // Provide valid credentials
                return new Credentials("testuser", "testpass");
            }

            @Override
            public void showError(String errorMessage) {
                System.out.println("Error: " + errorMessage);
            }
        };

        CLILoginController loginControllerValid = new CLILoginController(mockLoginViewValid, mockLoginDAO, mockApplicationController);
        loginControllerValid.start();

        // ConversationControllerTest with incorrect credentials
        System.out.println("\nConversationControllerTest Case 2: Invalid Login");
        CLILoginView mockLoginViewInvalid = new CLILoginView() {
            @Override
            public Credentials getCredentialsInput() {
                // Provide invalid credentials
                return new Credentials("wronguser", "wrongpass");
            }

            @Override
            public void showError(String errorMessage) {
                System.out.println("Error: " + errorMessage);
            }
        };

        CLILoginController loginControllerInvalid = new CLILoginController(mockLoginViewInvalid, mockLoginDAO, mockApplicationController);
        loginControllerInvalid.start();
    }
}
