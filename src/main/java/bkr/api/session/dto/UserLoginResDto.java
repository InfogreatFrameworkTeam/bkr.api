package bkr.api.session.dto;

import java.util.List;

/**
 * 用户登录结果DTO
 * 
 * @author chengd
 */
public class UserLoginResDto {
    /** 用户Id */
    private Long userId;

    /** 用户名 */
    private String name;

    /** 邮箱 */
    private String mail;

    /** 头像 */
    private String photo;

    /** 用户角色 */
    private RoleDto role;

    /** 用户权限 */
    private List<PermissionDto> permissionList;

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

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
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail
     *            the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo
     *            the photo to set
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * @return the role
     */
    public RoleDto getRole() {
        return role;
    }

    /**
     * @param role
     *            the role to set
     */
    public void setRole(RoleDto role) {
        this.role = role;
    }

    /**
     * @return the permissionList
     */
    public List<PermissionDto> getPermissionList() {
        return permissionList;
    }

    /**
     * @param permissionList
     *            the permissionList to set
     */
    public void setPermissionList(List<PermissionDto> permissionList) {
        this.permissionList = permissionList;
    }

}
