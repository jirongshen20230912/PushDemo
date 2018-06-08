package cn.sibat.pushdemo.bean;

/**
 * 功能概要：字符串实用类<br>
 *
 * @author 新谓来 程元森
 *
 */
public final class StringUtil {

    /**
     * 禁止实例化
     */
    private StringUtil() {
    }

    /**
     * 参数为null或者长度=0时，返回true；否则false
     *
     * @param str 参数
     * @return boolean 返回
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    /**
     * 参数为null时返回空白
     *
     * @param str 参数
     * @return String 返回
     */
    public static String toEmpty(String str) {
        return str == null ? "" : str;
    }

    /**
     * trim参数，null时返回blank
     *
     * @param str 参数
     * @return String 返回
     */
    public static String trim(String str) {
        return str == null ? "" : str.trim();
    }

    /**
     * [方法的处理概要]<br>
     *
     * @param str 参数
     * @return 返回
     */
    public static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0 || "null".equalsIgnoreCase(str.trim().toLowerCase());
    }

    /**
     * [方法的处理概要]<br>
     *
     * @param str 字符参数
     * @return 返回boolean
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 取子字符串 <br>
     * 字符串是null或者""的时候，返回"" <br>
     * 开始截取位置比字符串大时，返回"" <br>
     *
     * @param argInput 字符串
     * @param posStart 开始截取位置
     * @param posEnd 终了截取位置
     * @return 截取字符串
     */
    public static String subString(String argInput, int posStart, int posEnd) {
        if (isEmpty(argInput)) {
            return "";
        }
        int len = argInput.length();

        if (posStart < 0) {
            posStart = 0;
        }

        if (posEnd < posStart || posStart > len - 1) {
            return "";
        }

        if (posEnd > len) {
            return argInput.substring(posStart);
        }

        return argInput.substring(posStart, posEnd);
    }



}
