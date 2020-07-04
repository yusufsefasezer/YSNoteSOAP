package com.yusufsezer.client.item;

import com.yusufsezer.client.contract.Item;

public class ExitItem implements Item {

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getTitle() {
        return "Exit";
    }

    @Override
    public void run() {
        System.exit(0);
    }

}
