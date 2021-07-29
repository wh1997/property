package com.tianjian.property.controller;

import com.tianjian.property.config.RequestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author LiaoQuanfeng
 * Date on 2021\6\28 0028  15:09
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/test")
@CrossOrigin
public class TestController {

  @PostMapping("/test")
  public RequestResult test(@RequestBody(required = false) Map data) throws Exception {
    return RequestResult.create(0,"调用成功", "test");
  }

}
