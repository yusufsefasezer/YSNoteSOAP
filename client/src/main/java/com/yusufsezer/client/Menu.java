package com.yusufsezer.client;

import com.yusufsezer.client.contract.Item;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private String title;
    private List<Item> items;

    private Menu() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void showItem(String name) {
        items.forEach((item) -> {
            if (item.getName().equals(name)) {
                item.run();
            }
        });
    }

    public void start() {
        do {
            showMenu();
            int iIndex = new Scanner(System.in).nextInt();
            if (iIndex > 0 && iIndex <= items.size()) {
                Item selectedItem = items.get(iIndex - 1);
                if (selectedItem.isShowMenu()) {
                    selectedItem.run();
                }
            }
        } while (true);
    }

    private void showMenu() {
        System.out.println(title);
        for (int i = 0; i < items.size(); i++) {
            Item currentItem = items.get(i);
            if (currentItem.isShowMenu()) {
                System.out.println(String.format("%d-) %s",
                        (i + 1), currentItem.getTitle()));
            }
        }
    }

    public static class Builder {

        private final Menu menu;

        public Builder() {
            menu = new Menu();
        }

        public Builder setTitle(String title) {
            menu.setTitle(title);
            return this;
        }

        public Builder setItems(List<Item> items) {
            menu.items = items;
            return this;
        }

        public Menu getMenu() {
            return menu;
        }

    }

}
