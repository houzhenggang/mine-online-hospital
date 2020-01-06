package com.phoenix.wechat.model.groups;

/**
 * 微信平台分组对象
 *
 * @since 0.0.4
 */
public class Group implements java.io.Serializable {

    private int id;             //分组id，由微信分配
    private String name;        //分组名字，UTF8编码（30个字符以内）
    private int count;          //分组内用户数量

    /**
     * 获取 分组id
     *
     * @return 分组id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置 分组id
     *
     * @param id 分组id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取 分组名字
     *
     * @return 分组名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 分组名字
     *
     * <p>30个字符以内</p>
     *
     * @param name 分组名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 用户数量
     *
     * @return 用户数量
     */
    public int getCount() {
        return count;
    }

    /**
     * 设置 用户数量
     *
     * @param count 用户数量
     */
    public void setCount(int count) {
        this.count = count;
    }
}
