package com.lulu.mvc;

import com.google.gson.Gson;
import com.lulu.mvc.resolver.MagicBox;
import com.lulu.mvc.resolver.MagicBoxVo;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class DemoArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(MagicBox.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        System.out.println("resolve argument");

        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        String magicStr = request.getParameter("magic");

//        MagicBoxVo vo = new Gson().fromJson(magicStr, MagicBoxVo.class);

        MagicBoxVo magicBoxVo = new MagicBoxVo();
        magicBoxVo.setRandomNum(magicStr.split("-")[0]);
        magicBoxVo.setGift(magicStr.split("-")[1]);

        return magicBoxVo;
    }
}
