package com.jt.funny.homepage;

/**
 * Created by jiangtao on 16/5/22.
 *
 * @author jiangtao
 * @version 1.0.0
 */
public interface ItemVOParser {

    /**
     * parse json to vo
     *
     * @param type item vo type
     * @param json json string
     * @return vo
     */
    public ItemVO parse(String type, String json);
}
