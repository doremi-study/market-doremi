package com.doremi.marketdoremi.web;

import com.doremi.marketdoremi.domain.member.Role;
import com.doremi.marketdoremi.web.dto.MemberRoleDto;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class MemberRolesDeserializer extends JsonDeserializer<Role> {

    @Override
    public Role deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        ObjectCodec codec = p.getCodec();
        String str = codec.readValue(p, String.class);
        return Role.valueOf(str);
    }
}
