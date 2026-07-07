public class LoginCheck {

    public static void main(String[] args) {

        String username = "admin";
        String password = "123";

        String inputUsername = "admin";
        String inputPassword = "123";

        boolean loginSuccess = username.equals(inputUsername) && password.equals(inputPassword);

        System.out.println("Username Match: " + username.equals(inputUsername));
        System.out.println("Password Match: " + password.equals(inputPassword));
        System.out.println("Login Success: " + loginSuccess);
    }
}