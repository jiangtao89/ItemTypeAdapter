package com.jt.funny.homepage.app;

import android.os.Handler;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.jt.funny.homepage.ItemVO;
import com.jt.funny.homepage.ItemVOParser;
import com.jt.funny.homepage.ItemVOParserDefault;

import java.util.ArrayList;

/**
 * Created by jiangtao on 16/5/22.
 *
 * @author jiangtao
 * @version 1.0.0
 */
public class MainModelImpl implements MainModel {



    @Override
    public void request(final Callback callback) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                String imageJson = new Gson().toJson(new ImageItemPO());
                ItemPO imageItemPO = new ItemPO();
                imageItemPO.mType = "image";
                imageItemPO.mItem = imageJson;

                String textJson = new Gson().toJson(new TextItemPO());
                ItemPO textItemPO = new ItemPO();
                textItemPO.mType = "text";
                textItemPO.mItem = textJson;


                Data data = new Data();

                data.mData.add(textItemPO);
                data.mData.add(textItemPO);
                data.mData.add(textItemPO);
                data.mData.add(textItemPO);
                data.mData.add(textItemPO);
                data.mData.add(textItemPO);
                data.mData.add(textItemPO);
                data.mData.add(textItemPO);
                data.mData.add(textItemPO);

                data.mData.add(imageItemPO);
                data.mData.add(imageItemPO);
                data.mData.add(imageItemPO);
                data.mData.add(imageItemPO);
                data.mData.add(imageItemPO);
                data.mData.add(imageItemPO);
                data.mData.add(imageItemPO);
                data.mData.add(imageItemPO);
                data.mData.add(imageItemPO);

                ItemVOParser itemVOParser = new ItemVOParserDefault();

                try {
                    ArrayList<ItemVO> itemVOs = new ArrayList<ItemVO>();
                    for (ItemPO itemPO : data.mData) {
                        itemVOs.add(itemVOParser.parse(itemPO.mType, itemPO.mItem));
                    }

                    callback.success(itemVOs);
                } catch (Exception e) {
                    callback.failed();
                }
            }
        }, 1000);
    }

    public static class Data {
        @SerializedName("data")
        ArrayList<ItemPO> mData = new ArrayList<>();
    }

    public static class ItemPO {
        @SerializedName("type")
        String mType;

        @SerializedName("item")
        String mItem;
    }

    public static class TextItemPO {
        @SerializedName("title")
        String mTitle = "title of jt";
    }

    public static class ImageItemPO {
        @SerializedName("url")
        String url = "http://c.hiphotos.baidu.com/image/h%3D360/sign=0c16089cc9134954611eee62664f92dd/ac6eddc451da81cb6b1233d05066d01609243132.jpg";
    }

    /**
     * {
     "array": [
     {
     "type": "text",
     "item": "\"{\"title\": \"title of jt\"}\""
     },
     {
     "type": "image",
     "item": "\"{\"url\": \"http://d.hiphotos.baidu.com/image/h%3D360/sign=d624682592ef76c6cfd2fd2dad17fdf6/9e3df8dcd100baa1fee8fdbf4510b912c9fc2ee9.jpg\"\""
     }
     ]
     }
     */
}
