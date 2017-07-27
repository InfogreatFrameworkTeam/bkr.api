package bkr.api.session.dto;


/**
 * 权限表dto
 * 
 * @author chengd
 */
public class PermissionDto {
    /** 权限Id */
    private Long permissionId;

    /** 权限名 */
    private String name;

    /**
     * @return the permissionId
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * @param permissionId
     *            the permissionId to set
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
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
}
