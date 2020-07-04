package com.yusufsezer.client.contract;

public interface Item {

    String getName();

    String getTitle();

    void run();

    default boolean isShowMenu() {
        return true;
    }

}
