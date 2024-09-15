package controller.ApplicationController;

import model.domain.Credentials;

public interface ApplicationController {
    public void start(); // Method to start the application
    public void onLoginSuccess(Credentials credentials); // Handle successful login
    public void openProjectView(Credentials credentials);// Open Project View
    public void openProjectViewForAdmin(); // Open Project View for Admin
    public void openConversationView(Credentials credentials);// Open Conversation View
    public void openConversationViewForProject(String projectName); // Open Conversation View for Project
    public void openAdminView();// Open Admin View
    public void back();// Go back to the previous view
}
