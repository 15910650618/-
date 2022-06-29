package cn.solohand.item.service.impl;

import cn.solohand.item.pojo.Item;
import cn.solohand.item.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ItemServiceImpTest {

    @Autowired
    private ItemService service;
    @Test
    void findAllItems() {
        Collection<Item> items = service.findAllItems();
        Assert.isTrue(items.size()==62);
    }

    @Test
    void findItemById() {
        Item item = service.findItemById(3);
        Assert.isTrue("联想平板电脑".equals(item.getName()));
    }

    @Test
    void addItem() {
        Item item = new Item();
        item.setName("红米K40 Pro+");
        item.setBrand("骁龙888");
        Item item1 = service.addItem(item);
        Assert.isTrue(item1.getId() != 0);
    }

    @Test
    void update() {
        Item item = new Item(57,"小米平板5 Pro","骁龙870","小米",300,2000,"平板电脑","57.png");
        Item item1 = service.update(57,item);
        Assert.isTrue(item1.getType()=="骁龙870");
    }

    @Test
    void delete() {
        int ri=service.delete(3);
        Assert.isTrue(ri==1);
    }
}