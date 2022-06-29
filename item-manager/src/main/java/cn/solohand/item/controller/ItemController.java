package cn.solohand.item.controller;

import cn.solohand.commons.pojo.Trolley;
import cn.solohand.item.pojo.Item;
import cn.solohand.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;


@RestController
public class ItemController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ItemService service;

    @GetMapping(value = "/selectItem/{cid}")
    public Trolley selectItem(@PathVariable int cid){
        String url = "http://localhost:8090/items/"+cid;
        Trolley trolley = restTemplate.getForObject(url,Trolley.class);
        return trolley;
    }
    @GetMapping(value = "/items")
    public Collection<Item> findAllItem(){
        return service.findAllItems();
    }

    @GetMapping(value = "/items/{id}")
    public Item loadItem(@PathVariable int id){
        return service.findItemById(id);
    }

    @PostMapping(value = "/items")
    public Item addItem(@RequestBody Item item){
        return service.addItem(item);
    }

    @PutMapping(value = "/items/{id}")
    public Item updateItem(@PathVariable int id,@RequestBody Item item){
        return service.update(id,item);
    }

    @DeleteMapping(value = "/items/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable int id){
        String ri = "{}";
        int result = service.delete(id);
        if(result == 0){
            ri="{\"error\":\"删除不成功\"}";
        }
        return ResponseEntity.ok().header("Content-Type","application/json").body(ri);
    }
}
