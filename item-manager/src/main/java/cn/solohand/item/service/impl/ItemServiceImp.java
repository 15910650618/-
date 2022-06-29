package cn.solohand.item.service.impl;

import cn.solohand.item.pojo.Item;
import cn.solohand.item.service.ItemService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;
import java.util.Hashtable;

@Service
public class ItemServiceImp implements ItemService {
    private Hashtable<Integer,Item> items = new Hashtable<>();
    private int max=62;
    public ItemServiceImp() {

        Workbook workbook = null;
        try {
            workbook = new XSSFWorkbook("商品数据.xlsx");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet = workbook.getSheetAt(0);
        int index = 1;
        Row row = null;
        while((row = sheet.getRow(index))!=null){
            Cell idCell = row.getCell(0);
            Cell nameCell = row.getCell(1);
            Cell typeCell = row.getCell(2);
            Cell brandCell = row.getCell(3);
            Cell countCell = row.getCell(4);
            Cell priceCell = row.getCell(5);
            Cell sortCell = row.getCell(6);
            Cell picCell = row.getCell(7);

            int id = (int)idCell.getNumericCellValue();
            String name = nameCell.getStringCellValue();
            String type = typeCell.getStringCellValue();
            String brand = brandCell.getStringCellValue();
            int count = (int)countCell.getNumericCellValue();
            double price = priceCell.getNumericCellValue();
            String sort = sortCell.getStringCellValue();
            String pic = picCell.getStringCellValue();

            Item item = new Item(id,name,type,brand,count,price,sort,pic);

            items.put(id,item);

            index++;
        }
    }

    @Override
    public Collection<Item> findAllItems() {
        return items.values();
    }

    @Override
    public Item findItemById(int id) {
        return items.get(id);
    }

    @Override
    public Item addItem(Item item) {
        max++;
        item.setId(max);
        item.setPicture(max+".png");
        items.put(item.getId(),item);
        return item;
    }

    @Override
    public Item update(int id, Item item) {
        items.put(id,item);
        return item;
    }

    @Override
    public int delete(int id) {
        Item item = items.remove(id);
        if(item!=null){
            return 1;
        }else {
            return 0;
        }

    }


}
