package bkr.api.session.dto;

/**
 * 用户登录入力DTO
 * 
 * @author chengd
 */
public class UserLoginReqDto {

    /** 用户名 */
    private String name;

    /** 密码 */
    private String password;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
