package moe.feng.nhentai.api.common;

import moe.feng.nhentai.model.Category;

public class NHentaiUrl {

	public static final String NHENTAI_HOME = "http://nhentai.net";
	public static final String NHENTAI_I = "http://i.nhentai.net";
	public static final String NHENTAI_T = "http://t.nhentai.net";

	public static String getSearchUrl(String content) {
		return getSearchUrl(content, 1);
	}

	public static String getSearchUrl(String content, int page_num) {
		String targetContent = content;
		if (targetContent.contains(" ")) {
			targetContent = targetContent.replaceAll(" ", "+");
		}
		return NHENTAI_HOME + "/search/?q=" + targetContent + "&page=" + page_num;
	}

	public static String getBookDetailsUrl(String book_id) {
		return NHENTAI_HOME + "/g/" + book_id;
	}

	public static String getBookPageUrl(String book_id, int page_num) {
		return getBookDetailsUrl(book_id) + "/" + page_num;
	}

	public static String getGalleryUrl(String g_id) {
		return NHENTAI_I + "/galleries/" + g_id;
	}

	public static String getThumbGalleryUrl(String g_id) {
		return NHENTAI_T + "/galleries/" + g_id;
	}

	public static String getOriginPictureUrl(String g_id, String page_num) {
		return getPictureUrl(g_id, page_num, "jpg");
	}

	public static String getThumbPictureUrl(String g_id, String page_num) {
		return getThumbPictureUrl(g_id, page_num + "t", "jpg");
	}

	public static String getThumbUrl(String g_id) {
		return getThumbPictureUrl(g_id, "thumb", "jpg");
	}

	public static String getBigCoverUrl(String g_id) {
		return getThumbPictureUrl(g_id, "cover", "jpg");
	}

	public static String getPictureUrl(String g_id, String page_num, String file_type) {
		return getGalleryUrl(g_id) + "/" + page_num + "." + file_type;
	}

	public static String getThumbPictureUrl(String g_id, String page_num, String file_type) {
		return getThumbGalleryUrl(g_id) + "/" + page_num + "." + file_type;
	}

	@Deprecated
	public static String getParodyUrl(String name) {
		String targetName = name;
		if (targetName.contains(" ")) {
			targetName = targetName.replaceAll(" ", "-");
		}
		return NHENTAI_HOME + "/parody/" + targetName;
	}

	@Deprecated
	public static String getCharacterUrl(String name) {
		String targetName = name;
		if (targetName.contains(" ")) {
			targetName = targetName.replaceAll(" ", "-");
		}
		return NHENTAI_HOME + "/character/" + targetName;
	}

	@Deprecated
	public static String getTagUrl(String tag) {
		String targetTag = tag;
		if (targetTag.contains(" ")) {
			targetTag = targetTag.replaceAll(" ", "-");
		}
		return NHENTAI_HOME + "/tagged/" + targetTag;
	}

	@Deprecated
	public static String getArtistUrl(String name) {
		String targetName = name;
		if (targetName.contains(" ")) {
			targetName = targetName.replaceAll(" ", "-");
		}
		return NHENTAI_HOME + "/artist/" + targetName;
	}

	@Deprecated
	public static String getGroupUrl(String name) {
		String targetName = name;
		if (targetName.contains(" ")) {
			targetName = targetName.replaceAll(" ", "-");
		}
		return NHENTAI_HOME + "/group/" + targetName;
	}

	@Deprecated
	public static String getLanguageUrl(String name) {
		String targetName = name;
		if (targetName.contains(" ")) {
			targetName = targetName.replaceAll(" ", "-");
		}
		return NHENTAI_HOME + "/language/" + targetName;
	}

	public static String getCategoryUrl(Category category, boolean isPopularType) {
		String targetName = category.name;
		if (targetName.contains(" ")) {
			targetName = targetName.replaceAll(" ", "-");
		}
		return NHENTAI_HOME + "/" + category.type.toLowerCase() + "/" + targetName +
				(isPopularType ? "/popular" : "");
	}

	public static String getHomePageUrl(int page) {
		return NHENTAI_HOME + "/?page=" + page;
	}

}
