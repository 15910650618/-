package cn.solohand.trolley.controller;

import cn.solohand.commons.pojo.Trolley;
import cn.solohand.trolley.service.TrolleyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
public class TrolleyController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private TrolleyService service;

    @GetMapping(value = "/AddTrolley/{cid}")
    public Trolley addTrolley(@PathVariable int cid){
        String url = "http://localhost:8080/items/"+cid;
        Trolley trolley = restTemplate.getForObject(url,Trolley.class);
        return service.addTrolley(trolley);
    }
    @GetMapping(value = "/trolleys")
    public Collection<Trolley> findAllItem(){
        return service.findAllTrolleys();
    }
    @PutMapping(value = "/trolleys/{cid}")
    public Trolley updateTrolley(@PathVariable int cid,@RequestBody Trolley trolley){
        return service.update(cid,trolley);
    }
    @DeleteMapping(value = "/trolleys/{cid}")
    public ResponseEntity<String> deleteTrolley(@PathVariable int cid){
        String rt = "{}";
        int result = service.delete(cid);
        if(result == 0){
            rt="{\"error\":\"删除不成功\"}";
        }
        return ResponseEntity.ok().header("Content-Type","application/json").body(rt);
    }

    @GetMapping(value = "/items/{id}")
    public Trolley findTrolleyById(@PathVariable int id){
        Trolley trolley = new Trolley(id,"面向对象");
        return trolley;
    }
}
