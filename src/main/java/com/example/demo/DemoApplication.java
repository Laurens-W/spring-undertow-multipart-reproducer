package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @RestController
  @RequestMapping("/api")
  class SomeRequest {

    /**
     * @param object if the content of this part is larger than undertows new 16384 byte limit you
     *     will receive a DefaultHandlerExceptionResolver : Resolved
     *     [org.springframework.web.bind.MissingServletRequestParameterException: Required request
     *     parameter 'object' for method parameter type SomeObject is not present]
     * @return ok if request processed successfully
     */
    @RequestMapping(
        value = "/some-request",
        produces = {"application/json"},
        consumes = {"multipart/form-data"},
        method = RequestMethod.POST)
    public ResponseEntity<String> someMethod(@RequestParam("object") SomeObject object) {
      return ResponseEntity.ok("Request processed");
    }
  }

  static class SomeObject {
    private String data;
  }
}
