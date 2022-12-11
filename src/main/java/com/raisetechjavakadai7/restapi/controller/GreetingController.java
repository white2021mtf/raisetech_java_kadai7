package com.raisetechjavakadai7.restapi.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@Validated  // 追加
public class GreetingController {
    private static final String template = "%s";
    private final AtomicLong counter = new AtomicLong();
    private Object name;

    //年月日のクエリ文字列を受け取れるようにした
    @GetMapping("/birthdays")
    public Birthday birthday(@RequestParam(value = "birthday", defaultValue = "") String  birthday) throws ParseException {
        return new Birthday(String.format(template, birthday));
    }

    @GetMapping(value = "/validation")
    public String getPerson(
            @Valid @NotBlank @NotNull @Size(min=1,max=19) @RequestParam("name") String name,
            @Valid @NotNull @RequestParam("age") Integer age) {
        return "私の名前は" + name + "です。年齢は" + age + "です。";
    }

    @GetMapping("/names")
    public List<String> getNames(){
        return  List.of("猿","鳥","うす","桃太郎");
    }

    @PostMapping("/names")
    public ResponseEntity<String> create(@RequestBody CreateForm form){
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/names/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("name successfully created");
    }

    @PatchMapping("/names/{id}")
    public  ResponseEntity<Map<String, String>> update(@PathVariable("id") int id,
                                                       @RequestBody UpdateForm form){
        return  ResponseEntity.ok(Map.of("message","name successfully updated"));
    }

    @DeleteMapping("/names")
    public String deleteList(){
        return  "delete names list";
    }

    public  static  class CreateForm{
        private String name;
        public  String getName(){
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

    public  static  class UpdateForm{
        private String name;
        public  String getName(){
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

    @Data
    public class CalcForm {
        private String name;
    }
}



