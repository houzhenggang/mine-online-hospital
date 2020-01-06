package com.phoenix.wechat.model.message;

/**
 *
 * 素材类型
 *
 * @since 0.0.1
 */
public enum MediaType {

    /**
     * 图片
     */
    Image("image"),
    /**
     * 语音
     */
    Voice("voice"),
    /**
     * 视频
     */
    Video("video"),
    /**
     * 缩略图
     */
    Thumb("thumb");

    private String value = "";

    MediaType(String value) {
        this.value = value;
    }

//    /**
//     * 根据媒体类型字符串，返回媒体类型枚举对象
//     *
//     * @param mediaType 媒体类型字符串
//     * @return 媒体类型枚举对象
//     */
//    public MediaType valueOf(String mediaType) {
//        if (mediaType.equals(Voice.toString())) {
//            return Voice;
//        }
//        if (mediaType.equals(Image.toString())) {
//            return Image;
//        }
//        if (mediaType.equals(Video.toString())) {
//            return Image;
//        }
//        if (mediaType.equals(Thumb.toString())) {
//            return Image;
//        }
//        return null;
//    }

    @Override
    public String toString() {
        return value;
    }
}
