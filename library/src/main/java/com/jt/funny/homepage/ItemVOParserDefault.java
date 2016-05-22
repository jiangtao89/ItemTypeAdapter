package com.jt.funny.homepage;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * Created by jiangtao on 16/5/22.
 *
 * @author jiangtao
 * @version 1.0.0
 */
public class ItemVOParserDefault implements ItemVOParser {

    @Override
    public ItemVO parse(String typeDesc, String itemJson) {

        if (itemJson == null || itemJson.length() == 0) {
            return new NullableItemVO();
        }

        ItemViewManager viewManager = ItemViewManager.getInstance();
        final Class itemVOClazz = viewManager.getItemVO(typeDesc);

        try {
            ItemVO itemVO = (ItemVO) new Gson().fromJson(itemJson, itemVOClazz);
            itemVO.setItemViewTypeDesc(typeDesc);
            return itemVO;
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }

        return new NullableItemVO();
    }
}
