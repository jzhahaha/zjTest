//package com.test.demo.controller;
//
//import com.test.demo.model.ZJModels;
//import com.test.demo.service.ZJUserGetService;
//import com.test.demo.service.ZJUserPostService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
//import static org.springframework.http.HttpStatus.OK;
//
//@RestController
//@RequestMapping(value = "/zj")
//public class ZJController {
//
////    private final static Logger logger = LoggerFactory.getLogger(ZJController.class);
//
//    @Autowired
//    private ZJUserGetService zjUserGetService;
//
//    @Autowired
//    private ZJUserPostService zjUserPostService;
//
//    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
//    public ZJModels getZJUserById(@PathVariable("id") int id){
////        logger.error("error:start==========================================");
////        logger.info("id:start==============================================");
////        logger.debug("id debug start:======================================");
//        return zjUserGetService.getUserById(id);
//    }
//
//
//
//    @PostMapping(value = "/createUser")
//    public ZJModels createUser(@RequestParam(value = "name",defaultValue ="mmmmm")String name,
//                               @RequestParam(value = "age",defaultValue ="0")int age,
//                               @RequestParam(value = "area",defaultValue ="nnnnn")String area){
//        ZJModels result = new ZJModels();
//        result.setName(name);
//        result.setAge(age);
//        result.setArea(area);
////        zjUserPostService.createUserByUser(result);
//        zjUserPostService.createUserByPara(name, age, area);
//        return result;
//
//    }
//
//
//    @RequestMapping(value = "/name/{name}",method = RequestMethod.GET)
//    public ResponseEntity<?> getZJUserByName(@PathVariable("name") String name){
//
//        return new ResponseEntity<>(zjUserGetService.getUserByName(name),OK);
//    }
//
//    @RequestMapping(value = "/age/{age}",method = RequestMethod.GET)
//    public List<ZJModels> getZJUserByAge(@PathVariable("age") int age){
//        return zjUserGetService.getUserByAge(age);
//    }
//
//
////  name参数 not present
//    @PostMapping(value = "/updateById1/{id}")
//    public ZJModels updateZJUserById(@RequestParam(value = "name")String name ,
//                                      @RequestParam(value = "age",defaultValue = "0")int age,
//                                      @RequestParam(value = "area")String area,
//                                      @PathVariable(value = "id")int id){
//        ZJModels zjModels = new ZJModels();
//        zjModels.setId(id);
//        zjModels.setName(name);
//        zjModels.setAge(age);
//        zjModels.setArea(area);
//        zjUserPostService.updateByUser(id , zjModels);
//        return zjModels;
//    }
//
//    //name参数 not present
//    @RequestMapping(value = "/updateByPara",method = RequestMethod.POST)
//    public ZJModels updateZJUserByPara(@RequestParam(value = "name")String name ,
//                                      @RequestParam(value = "age",defaultValue = "0")int age,
//                                      @RequestParam(value ="area")String area,
//                                      @RequestParam(value ="id")int id){
//        ZJModels zjModels = new ZJModels();
//        zjModels.setId(id);
//        zjModels.setName(name);
//        zjModels.setAge(age);
//        zjModels.setArea(area);
//        zjUserPostService.updateByParm(id , name , age , area);
//        return zjModels;
//    }
//
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
//    public Map<String,Object> updateZJUserByMap(@PathVariable("id")int id , @RequestBody Map<String,Object> reqMap){
//        zjUserPostService.updateByMap(id , reqMap);
//        ZJModels zjModels = new ZJModels();
//        return reqMap;
//    }
//
//
//
//}
