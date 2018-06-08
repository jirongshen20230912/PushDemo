package cn.sibat.pushdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class AppInfo {
	private static SharedPreferences info;
	private static Editor editor;
	private static SharedPreferences first_pref;


	/**
	 * 设置是否第一次安装标记
	 * 
	 * @param context
	 * @return
	 */
	public static void setFirstIn(Context context, boolean isFirstIn) {
		first_pref = context.getSharedPreferences("first_pref",
				Context.MODE_PRIVATE);
		editor = first_pref.edit();
		editor.putBoolean("isFirstIn", isFirstIn);
		editor.commit();
	}

	/**
	 * 获取是否第一次安装标记
	 * @param context
	 * @return 是否第一次安装，默认返回true
	 */
	public static boolean getFirstIn(Context context) {
		first_pref = context.getSharedPreferences("first_pref",
				Context.MODE_PRIVATE);
		return first_pref.getBoolean("isFirstIn", true);
	}

	/**
	 * 是否已经登录
	 * 
	 * @param context
	 * @param isLogin
	 */
	public static void setIsLogin(Context context, boolean isLogin) {
		info = context.getSharedPreferences("info", Context.MODE_PRIVATE);
		editor = info.edit();
		editor.putBoolean("isLogin", isLogin);
		editor.commit();
	}

	/**
	 * 获取用户是否已经登录
	 * @param context
	 * @return 用户是否已经登录，默认为false
	 */
	public static boolean getIsLogin(Context context) {
		info = context.getSharedPreferences("info", Context.MODE_PRIVATE);
		return info.getBoolean("isLogin", false);
	}



	/**
	 * 用户头像地址
	 * 
	 * @param context
	 * @param imageUrl
	 */
	public static void setUserImageUrl(Context context, String imageUrl) {
		info = context.getSharedPreferences("info", Context.MODE_PRIVATE);
		editor = info.edit();
		editor.putString("imageUrl", imageUrl);
		editor.commit();
	}

	/**
	 * 获取用户头像地址
	 * @param context
	 * @return 用户头像地址,默认返回""
	 */
	public static String getUserImageUrl(Context context) {
		info = context.getSharedPreferences("info", Context.MODE_PRIVATE);
		return info.getString("imageUrl", "");
	}

	/**
	 * 设置用户昵称
	 *
	 * @param context
	 * @param userName
	 */
	public static void setUserName(Context context, String userName) {
		info = context.getSharedPreferences("info", Context.MODE_PRIVATE);
		editor = info.edit();
		editor.putString("userName", userName);
		editor.commit();
	}

	/**
	 * 获取用户名称
	 * @param context
	 * @return 获取用户名称,默认返回""
	 */
	public static String getUserName(Context context) {
		info = context.getSharedPreferences("info", Context.MODE_PRIVATE);
		return info.getString("userName", "");
	}

	/**
	 * 用户登录会话key
	 * 
	 * @param context
	 * @param sessionId
	 */
	public static void setSessionId(Context context, String sessionId) {
		info = context.getSharedPreferences("info", Context.MODE_PRIVATE);
		editor = info.edit();
		editor.putString("sessionId", sessionId);
		editor.commit();
	}

	/**
	 * 获取用户登录会话key
	 * @param context
	 * @return 用户登录会话key,默认返回null
	 */
	public static String getSessionId(Context context) {
		info = context.getSharedPreferences("info", Context.MODE_PRIVATE);
		return info.getString("sessionId", "");
	}


	/**
	 * 设置用户消息数
	 *
	 * @param context
	 * @param messageNum
	 */
	public static void setMessageNum(Context context, int messageNum) {
		info = context.getSharedPreferences("info", Context.MODE_PRIVATE);
		editor = info.edit();
		editor.putInt("messageNum", messageNum);
		editor.commit();
	}

	/**
	 * 获取用户消息数
	 * @param context
	 * @return 用户登录会话key,默认返回null
	 */
	public static int getMessageNum(Context context) {
		info = context.getSharedPreferences("info", Context.MODE_PRIVATE);
		return info.getInt("messageNum", 0);
	}

	/**
	 * 清空数据
	 */
	public static void clearAllData(Context context){
		AppInfo.setIsLogin(context, false);
		AppInfo.setSessionId(context, "");
		AppInfo.setUserImageUrl(context,"");
		AppInfo.setUserName(context,"");
	}








}
