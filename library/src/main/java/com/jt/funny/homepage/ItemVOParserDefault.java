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
    public ItemVO parse(String type, String json) {

        if (json == null || json.length() == 0) {
            return new NullableItemVO();
        }

        ItemViewManager viewManager = ItemViewManager.getInstance();
        final Class itemVOClazz = viewManager.getItemVO(type);

        try {
            ItemVO itemVO = (ItemVO) new Gson().fromJson(json, itemVOClazz);
            itemVO.setItemViewTypeDesc(type);
            return itemVO;
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }

        return new NullableItemVO();
    }
}
