package com.yusufsezer;

import com.yusufsezer.client.Menu;
import com.yusufsezer.client.contract.Item;
import com.yusufsezer.client.item.*;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        // set items
        List<Item> menuItems = Arrays.asList(
                new AddItem(),
                new ListItem(),
                new GetByIdItem(),
                new EditItem(),
                new DeleteItem(),
                new CountItem(),
                new ExitItem(),
                new HelpItem(),
                new VersionItem()
        );
        // create menu
        Menu menu = new Menu.Builder()
                .setTitle("### YSNote SOAP Client ##")
                .setItems(menuItems)
                .getMenu();

        if (args.length == 1) {
            menu.showItem(args[0]);
        } else {
            menu.start();
        }
    }

}
