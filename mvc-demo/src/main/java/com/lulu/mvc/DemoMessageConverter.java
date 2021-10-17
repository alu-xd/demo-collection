package com.lulu.mvc;

import com.google.gson.Gson;
import com.lulu.mvc.resolver.MagicBoxVo;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class DemoMessageConverter extends AbstractGenericHttpMessageConverter<MagicBoxVo> {
    @Override
    protected boolean supports(Class<?> clazz) {
        return MagicBoxVo.class == clazz;
    }

    @Override
    public MagicBoxVo read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String value = StreamUtils.copyToString(inputMessage.getBody(), StandardCharsets.UTF_8);
        MagicBoxVo magicBoxVo = new Gson().fromJson(value, MagicBoxVo.class);
        magicBoxVo.setUnknownBox(new MagicBoxVo.UnknownBox("unknown-" + magicBoxVo.getUnknownBox().getBox()));
        return magicBoxVo;
    }

    @Override
    protected MagicBoxVo readInternal(Class<? extends MagicBoxVo> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String value = StreamUtils.copyToString(inputMessage.getBody(), StandardCharsets.UTF_8);
        MagicBoxVo magicBoxVo = new Gson().fromJson(value, MagicBoxVo.class);
        magicBoxVo.setUnknownBox(new MagicBoxVo.UnknownBox("unknown-" + magicBoxVo.getUnknownBox().getBox()));
        return magicBoxVo;
    }

    @Override
    protected void writeInternal(MagicBoxVo unknownBox, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

    }
}
