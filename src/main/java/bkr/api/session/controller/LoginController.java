package bkr.api.session.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bkr.base.api.result.JsonResult;
import bkr.base.api.result.ResultCode;
import bkr.base.util.string.StringUtil;
import bkr.core.session.dto.UserDto;
import bkr.core.session.service.LoginService;

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
    public JsonResult<UserDto> login(HttpServletRequest request,
            HttpServletResponse response, @RequestParam Map<String, String> map) {
        // 入力验证
        // 用户名
        String userName = map.get("userName");
        if (StringUtil.isEmpty(userName)) {
            return new JsonResult<UserDto>(ResultCode.PARAMS_ERROR, "用户名不能为空！");
        }

        // 密码
        String password = map.get("password");
        if (StringUtil.isEmpty(password)) {
            return new JsonResult<UserDto>(ResultCode.PARAMS_ERROR, "密码不能为空！");
        }

        // 根据用户名和密码取得注册用户
        UserDto user = loginService
                .login(map.get("userName"), map.get("password"));

        // 用户不存在的长
        if (user == null) {
            return new JsonResult<UserDto>(ResultCode.FAILURE, "登录失败,用户名密码错误");
        }
        // 返回用户信息
        return new JsonResult<UserDto>(ResultCode.SUCCESS, "登录成功",user);
    }
}
