package bkr.api.session.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bkr.api.session.dto.UserLoginResDto;
import bkr.api.session.dto.UserLoginReqDto;
import bkr.base.api.result.JsonResult;
import bkr.base.api.result.ResultCode;
import bkr.base.util.string.StringUtil;
import bkr.core.user.entity.User;
import bkr.core.user.service.LoginService;

/**
 * 登录登出控制器
 * 
 * @author chengd
 * 
 */
@RestController
@RequestMapping("/api")
public class LoginController {

    /** 登录服务 */
    @Autowired
    private LoginService loginService;

    /**
     * 登录
     * 
     * @param response
     *            ：用于保存token到cookie中
     * @param map
     *            ：包含userName和password
     * @return
     */
    @RequestMapping(value = "/login", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public JsonResult<UserLoginResDto> login(@RequestBody UserLoginReqDto loginReqDto) {
        // 入力验证
        // 用户名
        if (StringUtil.isEmpty(loginReqDto.getName())) {
            return new JsonResult<UserLoginResDto>(ResultCode.PARAMS_ERROR, "用户名不能为空！");
        }

        // 密码
        if (StringUtil.isEmpty(loginReqDto.getPassword())) {
            return new JsonResult<UserLoginResDto>(ResultCode.PARAMS_ERROR, "密码不能为空！");
        }

        // 根据用户名和密码取得注册用户
        User user = loginService.login(loginReqDto.getName(),
                loginReqDto.getPassword());

        // 用户不存在的长
        if (user == null) {
            return new JsonResult<UserLoginResDto>(ResultCode.FAILURE, "登录失败,用户名密码错误");
        }

        // 在使用hibernate 最为数据持久层时，我们会映射实体之间的关系，而当我们要访问其中一个实体1时，通常会关联到具有关联关系的实体2，
        // 这是如果使用Jackson来获取实体1的时，就会无限级联的访问关联的实体2，这样就会造成“无限递归引用的异常”
        // 有映射关系的表 不能用检索结果作为出力
        // 返回用户信息
        UserLoginResDto dto = new UserLoginResDto();
        dto.setUser(user);
        dto.setRole(user.getRole());
        dto.setPermissionList(user.getPermissionList());
        return new JsonResult<UserLoginResDto>(ResultCode.SUCCESS, "登录成功", dto);
    }
}
