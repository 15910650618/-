package cn.solohand.item.service;

import cn.solohand.item.pojo.Item;

import java.util.Collection;

public interface ItemService {
    Collection<Item> findAllItems();
    Item findItemById(int id);
    Item addItem(Item item);
    Item update(int id,Item item);
    int delete(int id);
}
