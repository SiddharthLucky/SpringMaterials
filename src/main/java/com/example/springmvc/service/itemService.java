package com.example.springmvc.service;

import com.example.springmvc.models.items;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class itemService
{
    //Method to get All items in the repository.
    public List<items> getAllItems()
    {
        List<items> itemsList = new ArrayList<>();
        itemsList.add(new items(1, "item1", 1.00, 1));
        itemsList.add(new items(2, "item2", 2.10, 2));
        itemsList.add(new items(3, "item3", 3.20, 3));
        itemsList.add(new items(4, "item4", 4.30, 4));
        return itemsList;
    }

    //Method to filter the items based on user given ID
    public items getItemByID(int itemID)
    {
        itemService itemService = new itemService();
        List<items> itemListHolder = itemService.getAllItems();
        for(items itemHolder : itemListHolder)
        {
            if(itemHolder.getItemID() == itemID)
            {
                return itemHolder;
            }
        }
        return null;
    }
}
