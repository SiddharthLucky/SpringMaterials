package com.example.springmvc.controllers;

import com.example.springmvc.models.items;
import com.example.springmvc.service.itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/inventory")
public class itemController
{
    @Autowired
    itemService itemService;

    @RequestMapping(value = {"/all",""})
    public String getAllItems(Model model)
    {
        List<items> itemListHolder = itemService.getAllItems();
        model.addAttribute("itemsList", itemListHolder);
        model.addAttribute("pageHeading", "Item Inventory");
        return "views/itemsView";
    }

    @RequestMapping(value = "/items/{itemID}")
    public String getItemByItemID(@PathVariable("itemID") int itemID, Model model)
    {
        items itemHolder = itemService.getItemByID(itemID);
        model.addAttribute("itemsList", itemHolder);
        return "views/itemsView";
    }
}
