package com.yusufsezer.client.item;

import com.yusufsezer.client.contract.Item;
import com.yusufsezer.client.util.ServiceUtil;

public class CountItem implements Item {

    @Override
    public String getName() {
        return "count";
    }

    @Override
    public String getTitle() {
        return "Count";
    }

    @Override
    public void run() {
        Long count = ServiceUtil.getService().count();
        System.out.println("Total note: " + count);
    }

}
