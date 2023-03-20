package project109.backend.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jakarta.activation.DataContentHandlerFactory;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import project109.backend.entity.Good;
import project109.backend.service.GoodServiceTest;

//@Path("testx")
@Controller
public class TestControllerx {

  @Autowired
  private GoodServiceTest service;

  @GetMapping("/testx")
  public String controllerWorks() {
    return "The TestControllerx is working.";
  }

  //@GET
  //@Path("response")
  @GetMapping("/testx/response")
  public Response sendResponse() {
    return Response.ok().build();
  }

  //@GET
  //@Path("pathvar/{var}")
  @GetMapping("/testx/pathvar/{var}")
  public Response getPathVar(@PathParam("var") String var) {
    String msg = String.format("I got %s. Thx.", var);
    return Response.status(Response.Status.OK).build();
  }

  // @GET
  // @Path("/pathvar/{var}")
  // public Response get(@Context HttpServletRequest request, @Context HttpServletResponse response) {
  //   final WebResponse webResponse = new WebResponse(request, response);
  //   final LogReport logReport = new LogReport();
  //   logReport.setFunction(this, new Throwable());
  //   try {
  //     final Member member = loginBL.checkLogin(request, response, false, null);// 檢查使用者已登入(loginToken有效)
  //     final MemberInfoDTO memberInfoDTO = modelMapper.map(memberInfoService.get(member.getLoginId()), MemberInfoDTO.class);
  //     webResponse.OK();
  //     webResponse.setData(memberInfoDTO);// 傳出只有特定欄位的DTO
  //   } catch (ApiException e) {
  //     //apiUtil.webResponseError(webResponse, logReport, e);
  //   } catch (Exception e) {
  //     //apiUtil.webResponseError(webResponse, logReport, e);
  //   }
  //   return Response.status(StatusType ).entity(webResponse.getData()).build();
  // }

  // @GET
  // @Path("/list")
  // public List<Good> getList() throws Exception {
  //   List<Good> goodList = service.getList();
  //   return goodList;
  // }

  // @GET
  // @Path("/getId/{index}")
  // public String getIdByIndex(@PathVariable("index")int index) throws Exception{
  //   String goodId=null;
  //   try {
  //     goodId=service.get(index).getId();
  //   } catch (Exception e) {
  //     throw new ResponseStatusException(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "index: " + index + " 不存在。", e);
  //   }
  //   return goodId;
  // }

  // @POST
  // @Path("/test/add")
  // public String addItem(@RequestBody Good g) throws Exception {
  //   g.setId(Common.CreateRandomId(8));
  //   try {
  //     service.insert(g);
  //   } catch (Exception e) {
  //     throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
  //   }
  //   return String.format("%s is appended successfully.", g.getName());
  // }

  // @Path("/update/{id}")
  // @PATCH
  // public String updateItem(@PathVariable("id") String id, @RequestBody Good g) {
  //   try {
  //     service.update(id, g);
  //   } catch (Exception e) {
  //     throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id: " + id + " 不存在。", e);
  //   }
  //   return String.format("%s is updated successfully.", g.getName());
  // }

  // @Path("/delete/{id}")
  // @DELETE
  // public String deleteById(@PathVariable("id") String id) throws Exception {
  //   try{
  //     service.delete(id);
  //   }
  //   catch (Exception e) {
  //     //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id: " + id + " 不存在。", e);
  //     throw e;
  //   }
  //   return String.format("The element of id: %s is deleted.", id);
  // }
}