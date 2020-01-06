package com.phoenix.wechat.model.qrcode;

/**
 * 二维码类型
 *
 * @since 0.1.0
 */
public enum QrcodeType {

    /**
     * 临时的整型参数值
     */
    QR_SCENE("QR_SCENE"),
    /**
     * 临时的字符串参数值
     */
    QR_STR_SCENE("QR_STR_SCENE"),
    /**
     * 永久的整型参数值
     */
    QR_LIMIT_SCENE("QR_LIMIT_SCENE"),
    /**
     * 永久的字符串参数值
     */
    QR_LIMIT_STR_SCENE("QR_LIMIT_STR_SCENE");

    private String value = "";

    QrcodeType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static QrcodeType parse(String value) {
        if (value == null) {
            return null;
        }
        if (value.toUpperCase().equals(QR_SCENE.toString())) {
            return QR_SCENE;
        }
        if (value.toUpperCase().equals(QR_STR_SCENE.toString())) {
            return QR_STR_SCENE;
        }
        if (value.toUpperCase().equals(QR_LIMIT_SCENE.toString())) {
            return QR_LIMIT_SCENE;
        }
        if (value.toUpperCase().equals(QR_LIMIT_STR_SCENE.toString())) {
            return QR_LIMIT_STR_SCENE;
        }
        return null;
    }
}
