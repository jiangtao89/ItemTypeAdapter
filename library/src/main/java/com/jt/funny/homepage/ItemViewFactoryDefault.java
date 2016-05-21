package com.jt.funny.homepage;

import android.content.Context;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * Created by jiangtao on 16/5/21.
 *
 * @author jiang.tao
 * @version 1.0.0
 */
class ItemViewFactoryDefault implements ItemViewFactory {

    private ItemViewManager mItemViewManager;

    private static final HashMap<String, Constructor<? extends ItemView>> sConstructorMap =
            new HashMap<>();

    private static final Class<?>[] mConstructorSignature = new Class[]{Context.class};

    private final Object[] mConstructorArgs = new Object[1];

    /**
     * ItemViewFactory
     *
     * @param itemViewManager itemViewRepository
     */
    public ItemViewFactoryDefault(ItemViewManager itemViewManager) {
        mItemViewManager = itemViewManager;
    }

    /**
     * create item view
     *
     * @param itemVO item view object
     * @return item view
     */
    @Override
    public ItemView createItemView(Context context, ItemVO itemVO) {
        ItemView itemView = null;

        final String itemViewTypeDesc = itemVO.getItemViewTypeDesc();

        Constructor<? extends ItemView> constructor = sConstructorMap.get(itemViewTypeDesc);

        // get constructor of item view
        if (constructor == null) {
            try {
                Class<? extends ItemView> clazz = mItemViewManager.getItemView(itemViewTypeDesc);
                constructor = clazz.getConstructor(mConstructorSignature);
                sConstructorMap.put(itemViewTypeDesc, constructor);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        // new instance of item view
        if (constructor != null) {
            try {
                mConstructorArgs[0] = context;
                Object[] args = mConstructorArgs;
                constructor.setAccessible(true);
                itemView = constructor.newInstance(args);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return itemView;
    }
}
