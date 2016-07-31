package cn.hegrace.www.v1.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.ezmorph.MorpherRegistry;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

import org.apache.commons.lang.ArrayUtils;

public class StringUtils extends org.apache.commons.lang.StringUtils {
	private static final String REGEX_ASCII = "^[\\x00-\\xFF]+$";
	private static final String REGEX_CHINESE = "^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$";
	private static final String REGEX_COLOR = "^#[a-fA-F0-9]{6}";
	private static final String REGEX_DATE = "^\\d{4}(\\-|\\/|.)\\d{1,2}\\1\\d{1,2}$";
	private static final String REGEX_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
	private static final String REGEX_ENGLISH = "^[a-zA-Z0-9]+$";
	private static final String REGEX_INTEGER = "^-?\\d+$";
	private static final String REGEX_IP = "^(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])(\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])){3}$";
	private static final String REGEX_LETTER = "^[a-zA-Z]+$";
	private static final String REGEX_MOBILE = "^0{0,1}13[0-9]{9}$";
	private static final String REGEX_NUMBER = "^-?\\d+\\.?\\d*$";
	private static final String REGEX_PHONE = "(^(\\d{2,4}[-]?)?\\d{3,8}([-]?\\d{3,8})?([-]?\\d{1,7})?$)|(^0?1[35]\\d{9}$)";
	private static final String REGEX_PICTURE = "(.*)\\.(jpg|bmp|gif|ico|pcx|jpeg|tif|png|raw|tga)$";
	private static final String REGEX_RAR = "(.*)\\.(rar|zip|7zip|tgz)$";
	private static final String REGEX_SRM = "^[a-zA-Z0-9\\s]+$";
	private static final String REGEX_URL = "^http[s]?:\\/\\/([\\w-]+\\.)+[\\w-]+([\\w-./?%&=]*)?$";
	private static final String REGEX_ZIPCODE = "^\\d{6}$";

	private static final String NUMBERS_AND_LETTERS = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private static Random randGen;
	private static Object initLock = new Object();
	private static char[] numbersAndLetters;

	public static Double compare(String x, String y) {
		if (isNumber(x) && isNumber(y)) {
			return parseDouble(x) - parseDouble(y);
		}
		return null;
	}

	public static Boolean between(String value, String x, String y) {
		Double d1 = compare(value, x);
		Double d2 = compare(value, y);
		if (d1 != null && d2 != null) {
			return d1 >= 0 && d2 <= 0;
		}
		return null;
	}

	public static String filter(String... arr) {
		if (arr != null) {
			for (String str : arr) {
				if (StringUtils.isNotBlank(str)) {
					return str;
				}
			}
		}
		return null;
	}

	public static boolean isAscii(String s) {
		return !isBlank(s) && s.matches(REGEX_ASCII);
	}

	public static boolean isChinese(String s) {
		return !isBlank(s) && s.matches(REGEX_CHINESE);
	}

	public static boolean isColor(String s) {
		return !isBlank(s) && s.matches(REGEX_COLOR);
	}

	public static boolean isDate(String s) {
		return !isBlank(s) && s.matches(REGEX_DATE);
	}

	public static boolean isEmail(String s) {
		return !isBlank(s) && s.matches(REGEX_EMAIL);
	}

	public static boolean isEnglish(String s) {
		return !isBlank(s) && s.matches(REGEX_ENGLISH);
	}

	public static boolean isInteger(String s) {
		return !isBlank(s) && s.matches(REGEX_INTEGER);
	}

	public static boolean isIp(String s) {
		return !isBlank(s) && s.matches(REGEX_IP);
	}

	public static boolean isLetter(String s) {
		return !isBlank(s) && s.matches(REGEX_LETTER);
	}

	public static boolean isMobile(String s) {
		return !isBlank(s) && s.matches(REGEX_MOBILE);
	}

	public static boolean isNumber(String s) {
		return !isBlank(s) && s.matches(REGEX_NUMBER);
	}

	public static boolean isPhone(String s) {
		return !isBlank(s) && s.matches(REGEX_PHONE);
	}

	public static boolean isPicture(String s) {
		return !isBlank(s) && s.matches(REGEX_PICTURE);
	}

	public static boolean isRar(String s) {
		return !isBlank(s) && s.matches(REGEX_RAR);
	}

	public static boolean isSrm(String s) {
		return !isBlank(s) && s.matches(REGEX_SRM);
	}

	public static boolean isUrl(String s) {
		return !isBlank(s) && s.matches(REGEX_URL);
	}

	public static boolean isZipcode(String s) {
		return !isBlank(s) && s.matches(REGEX_ZIPCODE);
	}

	public static short parseShort(String s) {
		try {
			return isInteger(s) ? Short.parseShort(s) : 0;
		} catch (Exception e) {
			return 0;
		}
	}

	public static int parseInt(String s) {
		try {
			return isInteger(s) ? Integer.parseInt(s) : 0;
		} catch (Exception e) {
			return 0;
		}
	}

	public static long parseLong(String s) {
		try {
			return isInteger(s) ? Long.parseLong(s) : 0;
		} catch (Exception e) {
			return 0;
		}
	}

	public static float parseFloat(String s) {
		try {
			return isNumber(s) ? Float.parseFloat(s) : 0;
		} catch (Exception e) {
			return 0;
		}
	}

	public static double parseDouble(String s) {
		try {
			return isNumber(s) ? Double.parseDouble(s) : 0;
		} catch (Exception e) {
			return 0;
		}
	}

	public static Short toShort(String s) {
		try {
			return isInteger(s) ? Short.valueOf(s) : null;
		} catch (Exception e) {
			return null;
		}
	}

	public static Integer toInt(String s) {
		try {
			return isInteger(s) ? Integer.valueOf(s) : null;
		} catch (Exception e) {
			return null;
		}
	}

	public static Long toLong(String s) {
		try {
			return isInteger(s) ? Long.valueOf(s) : null;
		} catch (Exception e) {
			return null;
		}
	}

	public static Float toFloat(String s) {
		try {
			return isNumber(s) ? Float.valueOf(s) : null;
		} catch (Exception e) {
			return null;
		}
	}

	public static Double toDouble(String s) {
		try {
			return isNumber(s) ? Double.valueOf(s) : null;
		} catch (Exception e) {
			return null;
		}
	}

	public static BigDecimal toBigDecimal(String s) {
		try {
			return isNumber(s) ? new BigDecimal(s) : null;
		} catch (Throwable e) {
			return null;
		}
	}

	public static Date toDate(String s) {
		if (isBlank(s)) {
			return null;
		}
		String dateFormat = null;
		switch (s.length()) {
		case 8:
			dateFormat = "yyyyMMdd";
			break;
		case 10:
			dateFormat = "yyyy-MM-dd";
			break;
		case 16:
			dateFormat = "yyyy-MM-dd HH:mm";
			break;
		default:
			dateFormat = "yyyy-MM-dd HH:mm:ss";
			break;
		}
		if (dateFormat != null) {
			try {
				return new SimpleDateFormat(dateFormat).parse(s);
			} catch (Exception e) {
			}
		}
		return null;
	}

	public static String trimJson(String json) {
		if (isBlank(json)) {
			return json;
		}
		String regex = "\"\\w+\":(\"\"|null)";
		regex = "(," + regex + ")|(" + regex + ",)|(" + regex + ")";
		return json.replaceAll(regex, "");
	}

	public static String lowerFirst(String str) {
		return str == null ? null : str.substring(0, 1).toLowerCase() + str.substring(1);
	}

	public static String upperFirst(String str) {
		return str == null ? null : str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	public static String randomString(int length) {
		if (length < 1) {
			return null;
		}
		if (randGen == null) {
			synchronized (initLock) {
				if (randGen == null) {
					randGen = new Random();
					numbersAndLetters = NUMBERS_AND_LETTERS.toCharArray();
				}
			}
		}
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
			// randBuffer[i] = numbersAndLetters[randGen.nextInt(35)];
		}
		return new String(randBuffer);
	}

	public static String find(String str, String regex) {
		if (str != null) {
			Matcher matcher = Pattern.compile(regex).matcher(str);
			if (matcher.find()) {
				return matcher.group();
			}
		}
		return null;
	}

	public static String[] findAll(String str, String regex) {
		String[] arr = null;
		if (str != null) {
			Matcher matcher = Pattern.compile(regex).matcher(str);
			while (matcher.find()) {
				arr = (String[]) ArrayUtils.add(arr, matcher.group());
			}
		}
		return arr;
	}

	public static String replaceAll(String str, String regex, Replacement replacement) {
		if (str == null || replacement == null) {
			return str;
		}
		StringBuffer sb = new StringBuffer();
		Matcher matcher = Pattern.compile(regex).matcher(str);
		int i = 0, index = 0;
		while (matcher.find()) {
			sb.append(str.substring(index, matcher.start()));
			sb.append(replacement.format(matcher.group(), i++));
			index = matcher.end();
		}
		sb.append(str.substring(index));
		return sb.toString();
	}

	public static interface Replacement {
		public abstract String format(String str, int i);
	}

	public static String replaceAll(String str, String regex, String[] arr) {
		if (str == null || arr == null) {
			return str;
		}
		ArrayReplacement replacement = new ArrayReplacement() {
			public String format(String str, int i) {
				String[] arr = getArr();
				return arr != null && arr.length > i ? trimToEmpty(arr[i]) : "";
			}
		};
		replacement.setArr(arr);
		return replaceAll(str, regex, replacement);
	}

	private static abstract class ArrayReplacement implements Replacement {
		private String[] arr;

		public String[] getArr() {
			return arr;
		}

		public void setArr(String[] arr) {
			this.arr = arr;
		}
	}

	public static String replaceAll(String str, String regex, Map<String, String> map) {
		if (str == null || map == null) {
			return str;
		}
		MapReplacement replacement = new MapReplacement() {
			@SuppressWarnings("unchecked")
			public String format(String str, int i) {
				Map<String, String> map = getMap();
				return map != null ? trimToEmpty(map.get(str)) : "";
			}
		};
		replacement.setMap(map);
		return replaceAll(str, regex, replacement);
	}

	private static abstract class MapReplacement implements Replacement {
		private Map<String, String> map;

		public Map<String, String> getMap() {
			return map;
		}

		public void setMap(Map<String, String> map) {
			this.map = map;
		}
	}

	public static Object parse(Class<?> type, String value) {
		if (type == String.class) {
			return value;
		} else if (type == Short.class) {
			return toShort(value);
		} else if (type == Integer.class) {
			return toInt(value);
		} else if (type == int.class) {
			return toInt(value);
		} else if (type == Long.class) {
			return toLong(value);
		} else if (type == Double.class) {
			return toDouble(value);
		} else if (type == BigDecimal.class) {
			return toBigDecimal(value);
		} else if (type == Date.class) {
			return toDate(value);
		} else {
			return null;
		}
	}

	/**
	 * @param classOrInstanceName
	 */
	public static String parseTablename(String classOrInstanceName) {
		return classOrInstanceName == null ? null : replaceAll(classOrInstanceName, "[a-z][A-Z]", new Replacement() {
			public String format(String str, int i) {
				return new StringBuffer(str).insert(1, "_").toString();
			}
		}).toUpperCase();
	}

	/**
	 * @param tablename
	 */
	public static String parseInstanceName(String tablename) {
		return tablename == null ? null : replaceAll(tablename.toLowerCase(), "_\\w", new Replacement() {
			public String format(String str, int i) {
				return str.substring(1).toUpperCase();
			}
		});
	}

	public static String parseClassName(String tablename) {
		return upperFirst(parseInstanceName(tablename));
	}

	/**
	 * @param columnName
	 */
	public static String parseFieldName(String columnName) {
		return columnName == null ? null : replaceAll(columnName.toLowerCase(), "_\\w", new Replacement() {
			public String format(String str, int i) {
				return str.substring(1).toUpperCase();
			}
		});
	}

	public static boolean isMember(String collection, String element) {
		return StringUtils.isNotBlank(collection) && StringUtils.isNotBlank(element)
				&& collection.matches("(^|.*\\W)" + element + "(\\W.*|$)");
	}

	public static String formatPath(String path) {
		return path.replace("\\", "/").replaceAll("//*", "/");
	}

	public static boolean isCompareExpression(String expression) {
		if (isBlank(expression)) {
			return false;
		}
		String regex = "^(=-?\\d+\\.?\\d*|<=?-?\\d+\\.?\\d*|>=?-?\\d+\\.?\\d*|-?\\d+\\.?\\d*--?\\d+\\.?\\d*)$";
		return expression.matches(regex);
	}

	public static String substring(StringBuffer sb, int length) {
		return sb.substring(0, Math.max(sb.length() - length, 0));
	}

	/** 清除Sql关键字 */
	public static String clearSqlKeywords(String sql) {
		return isBlank(sql) ? "" : sql.replaceAll(".*([';]+|(--)+).*", "");
	}

	public static String csvReplac(String csv) {
		if (StringUtils.isBlank(csv))
			return "";
		return csv.replaceAll(",", "，");
	}

}