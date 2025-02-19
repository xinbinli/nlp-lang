package org.nlpcn.commons.lang.pinyin;

import java.io.BufferedReader;
import java.util.List;

public class Pinyin {

	/**
	 * 拼音返回
	 *
	 * @param str
	 * @return [chang, jiang, cheng, zhang]
	 */

	public static List<String> pinyin(String str) {
		return PinyinUtil.INSTANCE.convert(str, PinyinFormatter.TYPE.WITHOUT_NUM_PINYIN_FORMAT);
	}

	/**
	 * 取得每个字的首字符
	 *
	 * @param str
	 * @return [c, j, c, z]
	 */
	public static List<String> firstChar(String str) {
		return PinyinUtil.INSTANCE.convert(str, PinyinFormatter.TYPE.FIRST_CHAR_PINYIN_FORMAT);
	}

	/**
	 * 取得每个字的帶音標
	 *
	 * @param str
	 * @return [cháng, jiāng, chéng, zhăng]
	 */
	public static List<String> unicodePinyin(String str) {
		return PinyinUtil.INSTANCE.convert(str, PinyinFormatter.TYPE.UNICODE_PINYIN_FORMAT);
	}

	/**
	 * 要音標的拼音
	 *
	 * @param str
	 * @return [chang2, jiang1, cheng2, zhang3]
	 */
	public static List<String> tonePinyin(String str) {
		return PinyinUtil.INSTANCE.convert(str, PinyinFormatter.TYPE.DEFAULT_PINYIN_FORMAT);
	}

	/**
	 * list 转换为字符串
	 * 
	 * @param list
	 * @param spearator
	 * @return
	 */
	public static String list2String(List<String> list, String spearator) {
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		for (String string : list) {
			if (string == null) {
				string = "NULL";
			}

			if (flag) {
				sb.append(string);
				flag = false;
			} else {
				sb.append(spearator);
				sb.append(string);
			}

		}
		return sb.toString();
	}

	/**
	 * list 转换为字符串 默认空格
	 * 
	 * @param list
	 * @return
	 */
	public static String list2String(List<String> list) {
		return list2String(list, " ");
	}

	/**
	 * 动态增加到拼音词典中
	 *
	 * @param word
	 *            大长今
	 * @param pinyins
	 *            ['da4', 'chang2' ,'jing1']
	 */
	public static void insertPinyin(String word, String[] pinyins) {
		PinyinUtil.INSTANCE.insertPinyin(word, pinyins);
	}

	/**
	 * 清除已加载到内存的拼音及多音字字典
	 */
	public static void clearPinyin(){
		PinyinUtil.INSTANCE.clearPinyin();
	}

	/**
	 * 对拼音插件定向开发方法，适用于拼音热加载远程多音字字典
	 * @param in
	 */
	public static void loadPolyphoneMappingForPinyin(BufferedReader in){
		PinyinUtil.INSTANCE.loadPolyphoneMappingForPinyin(in);
	}

	/**
	 * list 转换为字符串 默认空格,忽略null
	 * 
	 * @param list
	 * @return
	 */
	public static String list2StringSkipNull(List<String> list) {
		return list2StringSkipNull(list, " ");
	}

	/**
	 * list 转换为字符串
	 * 
	 * @param list
	 * @param spearator
	 * @return
	 */
	public static String list2StringSkipNull(List<String> list, String spearator) {
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		for (String string : list) {
			if (string == null) {
				continue;
			}

			if (flag) {
				sb.append(string);
				flag = false;
			} else {
				sb.append(spearator);
				sb.append(string);
			}

		}
		return sb.toString();
	}
}