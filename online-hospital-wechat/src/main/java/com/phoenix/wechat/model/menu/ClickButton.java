package com.phoenix.wechat.model.menu;

/**
 * 点击推事件
 *
 * @since 0.0.1
 */
public class ClickButton extends SingleButton {

    /**
     * click类型必须.菜单KEY值，用于消息接口推送，不超过128字节
     */
    private String key;

    public ClickButton(String name, String key) {
        super(name);
        this.key = key;
    }

    public String getType() {
        return ButtonType.Click.toString();
    }

    /**
     * 获取 菜单KEY值
     *
     * <p>
     * click类型必须.菜单KEY值， 用于消息接口推送，不超过128字节
     * </p>
     *
     * @return 菜单KEY值
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置 菜单KEY值
     *
     * <p>
     * click类型必须.菜单KEY值，用于消息接口推送，不超过128字节
     * </p>
     *
     * @param key 菜单KEY值
     */
    public void setKey(String key) {
        this.key = key;
    }
}
