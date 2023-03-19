package project109.backend.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;

import project109.backend.entity.Good;
import project109.backend.service.GoodServiceTest;
import project109.backend.util.Common;

@RestController
public class TestController {

  @Autowired
  private GoodServiceTest service;

  @GetMapping("/test")
  public String controllerWorks() {
    return "The TestController is working.";
  }

  @GetMapping("/test/pathvar/{var}")
  public String getPathVar(@PathVariable("var") String var) {
    return String.format("I got %s. Thx.", var);
  }

  @GetMapping("/test/list")
  public List<Good> getList() throws Exception {
    List<Good> goodList = service.getList();
    return goodList;
  }


  @GetMapping("/test/getId/{index}")
  public String getIdByIndex(@PathVariable("index")int index) throws Exception{
    String goodId=null;
    try {
      goodId=service.get(index).getId();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "index: " + index + " 不存在。", e);
    }
    return goodId;
  }

  @PostMapping("/test/add")
  public String addItem(@RequestBody Good g) throws Exception {
    g.setId(Common.CreateRandomId(8));
    try {
      service.insert(g);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }
    return String.format("%s is appended successfully.", g.getName());
  }

  @PutMapping("/test/update/{id}")
  public String updateItem(@PathVariable("id") String id, @RequestBody Good g) {
    try {
      service.update(id, g);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id: " + id + " 不存在。", e);
    }
    return String.format("%s is updated successfully.", g.getName());
  }

  @DeleteMapping("/test/delete/{id}")
  public String deleteById(@PathVariable("id") String id) throws Exception {
    try{
      service.delete(id);
    }
    catch (Exception e) {
      //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id: " + id + " 不存在。", e);
      throw e;
    }
    return String.format("The element of id: %s is deleted.", id);
  }
}
