package com.phoenix.wechat.model.menu;

/**
 * 自定义菜单按钮
 *
 * @since 0.0.1
 */
public class BaseButton {

    /**
     * 菜单标题，不超过16个字节，子菜单不超过40个字节
     */
    private final String name;

    /**
     * 基础按钮
     *
     * @param name 菜单标题
     */
    public BaseButton(String name) {
        this.name = name;
    }

    /**
     * 获取 菜单标题
     *
     * @return 菜单标题
     */
    public String getName() {
        return name;
    }
}
