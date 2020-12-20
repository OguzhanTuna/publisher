package com.bwcompany.publisher.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebMvc
@AllArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final ObjectMapper objectMapper;

/*  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    SerializationConfig.XJacksonHttpMessageConverter messageConverter = new SerializationConfig.XJacksonHttpMessageConverter();
    messageConverter.setObjectMapper(objectMapper);
    converters.add(messageConverter);
  }*/

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (HttpMessageConverter<?> converter : converters) {
            if (converter instanceof MappingJackson2HttpMessageConverter) {
                ObjectMapper mapper = ((MappingJackson2HttpMessageConverter) converter).getObjectMapper();
                mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                mapper.enable(MapperFeature.USE_STATIC_TYPING);
                mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
            }
        }
    }
}
