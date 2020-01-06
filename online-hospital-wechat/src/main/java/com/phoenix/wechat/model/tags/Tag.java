package com.phoenix.wechat.model.tags;

/**
 * 用户标签管理
 *
 * <p>
 * 通过<tt>Weixin</tt>产生一个请求对象，通过<code>getUserTags()</code>生成一个<tt>Tags</tt>，集合</p>
 *
 * @since 0.0.7
 */
public class Tag {

    private int id;             //标签id，由微信分配
    private String name;        //标签名，UTF8编码（30个字符以内）
    private int count;          //此标签下粉丝数

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
