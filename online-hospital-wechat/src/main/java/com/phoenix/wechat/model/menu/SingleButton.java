package com.phoenix.wechat.model.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * 带子菜单的按钮,此按钮中必须设置子菜单
 *
 * @since 0.0.1
 */
public class SingleButton extends BaseButton {

	/**
	 * 子菜单(此菜单需要手动添加，所以get和set方法能喝微信返回的json一致)
	 */
	private List<SingleButton> subButton;

	public SingleButton(String name) {
		super(name);
	}

	/**
	 * 设置 子菜单
	 *
	 * @param sub_button 子菜单
	 */
	public void setSubButton(List<SingleButton> sub_button) {
		this.subButton = sub_button;
	}

	/**
	 * 获取 子菜单
	 *
	 * @return 子菜单
	 */
	public List<SingleButton> getSubButton() {
		if (subButton == null) {
			subButton = new ArrayList<SingleButton>(0);
		}
		return this.subButton;
	}
}
