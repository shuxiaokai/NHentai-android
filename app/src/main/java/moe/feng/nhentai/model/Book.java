package moe.feng.nhentai.model;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Book {

	/** 必须获取到的数据 */
	public String title, other, bookId;

	/** 次要数据 */
	public String previewImageUrl, bigCoverImageUrl, titleJP, galleryId;
	public int pageCount;

	public int thumbHeight = 0, thumbWidth = 0;

	public String parodies, language, group;
	public ArrayList<String> tags = new ArrayList<>();
	public ArrayList<String> characters = new ArrayList<>();
	public ArrayList<String> artists = new ArrayList<>();

	/** 旧数据 */
	private String artist = null;

	public String uploadTime, uploadTimeText;

	public Book() {
		this(null, null, null);
	}

	public Book(String title, String other, String bookId) {
		this.title = title;
		this.other = other;
		this.bookId = bookId;
	}

	public Book(String title, String other, String bookId, String previewImageUrl) {
		this.title = title;
		this.other = other;
		this.bookId = bookId;
		this.previewImageUrl = previewImageUrl;
	}

	public String getAvailableTitle() {
		return this.titleJP != null ? this.titleJP : this.title;
	}

	public String toJSONString() {
		return new Gson().toJson(this);
	}

	public void updateDataFromOldData() {
		if (this.artist != null && !this.artist.trim().isEmpty()) {
			this.artists.add(this.artist);
		}
		if (this.bigCoverImageUrl.contains("i.nhentai")) {
			this.bigCoverImageUrl = this.bigCoverImageUrl.replace("i.nhentai", "t.nhentai");
		}
		if (this.previewImageUrl.contains("i.nhentai")) {
			this.previewImageUrl = this.previewImageUrl.replace("i.nhentai", "t.nhentai");
		}
	}

	public static Book toBookFromJson(String json) {
		Book book = new Gson().fromJson(json, Book.class);
		book.updateDataFromOldData();
		return book;
	}

}
