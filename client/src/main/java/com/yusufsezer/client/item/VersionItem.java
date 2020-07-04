package com.yusufsezer.client.item;

import com.yusufsezer.client.contract.Item;

public class VersionItem implements Item {

    @Override
    public String getName() {
        return "--version";
    }

    @Override
    public String getTitle() {
        return "version";
    }

    @Override
    public void run() {
        System.out.println("YSNoteSOAP 1.0-SNAPSHOT");
    }

    @Override
    public boolean isShowMenu() {
        return false;
    }

}
