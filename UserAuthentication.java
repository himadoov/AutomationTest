package axsos.academy;

public class UserAuthentication {

    public boolean authenticate(String username, String password) {
        return "admin".equals(username) && "password123".equals(password);
    }
}
