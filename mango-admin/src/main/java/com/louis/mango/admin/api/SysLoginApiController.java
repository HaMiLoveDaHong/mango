package com.louis.mango.admin.api;

import com.google.code.kaptcha.Producer;
import com.louis.mango.admin.config.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 登陆 api 接口
 *
 * @quthor haMi
 * @date2019/11/2
 */
@Slf4j
@RestController
@RequestMapping(value = {"/api/login"})
public class SysLoginApiController {

    @Autowired
    private Producer producer;

    /**
     * 生成验证码
     *
     * @param response
     * @param request
     */
    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, HttpServletRequest request) {
        try {
            response.setHeader("Cache-Control", "no-store,no-cache");
            response.setContentType("image/jpeg");
            //生成文字验证码
            String text = producer.createText();
            //生成图片验证码
            BufferedImage image = producer.createImage(text);
            //保存到验证码 到 session
            request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
            ServletOutputStream out = response.getOutputStream();
            ImageIO.write(image, "jpg", out);
            IOUtils.closeQuietly(out);
        } catch (IOException e) {
            log.info("接口：/api/login/captcha.jpg，报错信息:{},详情:{}", e.getMessage(), e);
        }

    }
}
