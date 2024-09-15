package view;

public interface View {
    public void display();
    public void close();
    public void refresh();
    public void back();
    public void showError(String message);
}


