package com.phoenix.wechat.component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;

import com.phoenix.wechat.Configuration;
import com.phoenix.wechat.Weixin;
import com.phoenix.wechat.WeixinException;
import com.phoenix.wechat.http.HttpsClient;
import com.phoenix.wechat.http.Response;
import org.springframework.stereotype.Component;

import com.phoenix.wechat.model.groups.Group;

/**
 * 用户分组组件（微信已过时，推荐使用标签组件）
 * 
 * @since 0.1.0
 */
@Component
public class GroupsComponent extends AbstractComponent {

    public GroupsComponent(Weixin weixin) {
        super(weixin);
    }

    /**
     * 创建分组
     *
     * @param name 分组名字（30个字符以内）
     * @return 创建成功，返回带Id的Group对象
     * @throws WeixinException 创建分组异常
     */
    public Group create(String name) throws WeixinException {
        //内部业务验证
        if (name == null || name.equals("")) {
            throw new IllegalStateException("name can not be null or empty");
        }
        //拼接参数
        JSONObject postGroup = new JSONObject();
        JSONObject postName = new JSONObject();
        postName.put("name", name);
        postGroup.put("group", postName);
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取access_token接口
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/groups/create?access_token=" + weixin.getToken().getAccess_token(), postGroup);
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        Group group = null;
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("/groups/create返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
            }
            JSONObject jsonGroup = jsonObj.getJSONObject("group");
            group = JSONObject.toJavaObject(jsonGroup, Group.class);
        }
        return group;
    }

    /**
     * 查询所有分组
     *
     * <p>
     * 最多支持创建500个分组</p>
     *
     * @return 分组列表
     * @throws WeixinException 查询所有分组异常
     */
    public List<Group> get() throws WeixinException {
        List<Group> groupList = new ArrayList<Group>();
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取access_token接口
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/groups/get?access_token=" + weixin.getToken().getAccess_token(), null);
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("getGroups返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
            }
            //获取分组列表
            JSONArray groups = jsonObj.getJSONArray("groups");
            for (int i = 0; i < groups.size(); i++) {
                JSONObject jsonGroup = groups.getJSONObject(i);
                Group group = (Group) JSONObject.toJavaObject(jsonGroup, Group.class);
                groupList.add(group);
            }
        }
        return groupList;
    }

    /**
     * 查询用户所在分组
     *
     * <p>
     * 通过用户的OpenID查询其所在的GroupID</p>
     *
     * @param openid 用户唯一标识符
     * @return 返回用户所在分组Id
     * @throws WeixinException 查询用户所在分组异常
     */
    public int getId(String openid) throws WeixinException {
        //内部业务验证
        if (openid == null || openid.equals("")) {
            throw new IllegalStateException("openid is null!");
        }
        int groupId = -1;
        //拼接参数
        JSONObject postParam = new JSONObject();
        postParam.put("openid", openid);
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取access_token接口
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=" + weixin.getToken().getAccess_token(), postParam);
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("getGroupId返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
            }
            //获取成功返回分组Id
            groupId = jsonObj.getIntValue("groupid");
        }
        return groupId;
    }

    /**
     * 修改分组名
     *
     * @param id 分组id，由微信分配
     * @param name 分组名字（30个字符以内）
     * @throws WeixinException 修改分组名异常
     */
    public void update(int id, String name) throws WeixinException {
        //内部业务验证
        if (id < 0) {
            throw new IllegalStateException("id can not <= 0!");
        }
        if (name == null || name.equals("")) {
            throw new IllegalStateException("name is null!");
        }
        //拼接参数
        JSONObject postGroup = new JSONObject();
        JSONObject postName = new JSONObject();
        postName.put("id", id);
        postName.put("name", name);
        postGroup.put("group", postName);
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取access_token接口
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/groups/update?access_token=" + weixin.getToken().getAccess_token(), postGroup);
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("/groups/update返回json：" + jsonObj.toString());
            }
            //判断是否修改成功
            //正常时返回 {"errcode": 0, "errmsg": "ok"}
            //错误时返回 示例：{"errcode":40013,"errmsg":"invalid appid"}
            int errcode = jsonObj.getIntValue("errcode");
            //登录成功，设置accessToken和过期时间
            if (errcode != 0) {
                //返回异常信息
                throw new WeixinException(getCause(errcode));
            }
        }
    }

    /**
     * 删除分组
     *
     * @param groupId 分组Id
     * @throws WeixinException 删除分组异常
     */
    public void delete(int groupId) throws WeixinException {
        //拼接参数
        JSONObject postParam = new JSONObject();
        JSONObject group = new JSONObject();
        group.put("id", groupId);
        postParam.put("group", group);
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取access_token接口
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/groups/delete?access_token=" + weixin.getToken().getAccess_token(), postParam);
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("/groups/delete返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
            }
        }
    }

    /**
     * 移动用户分组
     *
     * @param openid 用户唯一标识符
     * @param to_groupid 分组id
     * @throws WeixinException 移动用户分组异常
     */
    public void membersUpdate(String openid, int to_groupid) throws WeixinException {
        //内部业务验证
        if (openid == null || openid.equals("")) {
            throw new IllegalStateException("openid is null!");
        }
        if (to_groupid < 0) {
            throw new IllegalStateException("to_groupid can not <= 0!");
        }
        //拼接参数
        JSONObject postParam = new JSONObject();
        postParam.put("openid", openid);
        postParam.put("to_groupid", to_groupid);
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取access_token接口
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=" + weixin.getToken().getAccess_token(), postParam);
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("/groups/members/update返回json：" + jsonObj.toString());
            }
            //判断是否修改成功
            //正常时返回 {"errcode": 0, "errmsg": "ok"}
            //错误时返回 示例：{"errcode":40013,"errmsg":"invalid appid"}
            int errcode = jsonObj.getIntValue("errcode");
            //登录成功，设置accessToken和过期时间
            if (errcode != 0) {
                //返回异常信息
                throw new WeixinException(getCause(errcode));
            }
        }
    }
}
