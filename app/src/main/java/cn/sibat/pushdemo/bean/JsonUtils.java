package cn.sibat.pushdemo.bean;

import com.google.gson.Gson;

public class JsonUtils {
	/***
	 * 解析单个对象
	 * 
	 * @param jsonstr
	 * @return
	 */
	public static <T> T jsonObject(Class<T> Obclass, String jsonstr) {
		Gson gson = new Gson();// 创建Gson对象
		T object = null;
		try {
			object = gson.fromJson(jsonstr, Obclass);// 解析json对象
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
}
