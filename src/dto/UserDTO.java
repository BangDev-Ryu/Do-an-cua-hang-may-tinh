package dto;

public class UserDTO {
    private String idUser;
    private String password;
    private String userName;
    private String role;
    private boolean enable;

    public UserDTO() {
        
    }

    public UserDTO(String idUser, String password, String userName, String role, boolean enable) {
        this.idUser = idUser;
        this.password = password;
        this.userName = userName;
        this.role = role;
        this.enable = enable;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
