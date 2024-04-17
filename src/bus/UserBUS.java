package bus;

import dao.UserDAO;
import dto.UserDTO;
import java.util.ArrayList;
import java.util.Arrays;

public class UserBUS {
    private ArrayList<UserDTO> userList;
    
    public UserBUS() {
        
    }

    public ArrayList<UserDTO> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<UserDTO> userList) {
        this.userList = userList;
    }
    
    public void list() {
        UserDAO userDAO = new UserDAO();
        userList = new ArrayList<>();
        userList = userDAO.list();
    }
    
    public UserDTO checkUser(String userName, char[] password) {
        for (UserDTO user : userList) {
            char[] correctPass = user.getPassword().toCharArray();
            if (user.getTenUser().equals(userName) && Arrays.equals(password, correctPass) && user.isEnable()) {
                return user;
            }
        }
        return null;
    }
}
