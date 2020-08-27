package root.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String author;
	private String title;
	private String shortDescription;
	private String shortlong;
	private String[] images;
	private String thumbnail;
	private String publisher;
	private int available;
	private String coverType;
	private String weight;
	private int pages;
	private double price;
	private double discount;
	@OneToMany()
	private List<Book> relatives;
//

	public long getId() {
		return id;
	}

	public Book(String author, String title, String shortDescription, String shortlong, 
			String thumbnail, String publisher, int available, String coverType, String weight, int pages, double price,
			double discount) {
		this.author = author;
		this.title = title;
		this.shortDescription = shortDescription;
		this.shortlong = shortlong;
		this.thumbnail = thumbnail;
		this.publisher = publisher;
		this.available = available;
		this.coverType = coverType;
		this.weight = weight;
		this.pages = pages;
		this.price = price;
		this.discount = discount;
	}

	public Book() {
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getShortlong() {
		return shortlong;
	}

	public void setShortlong(String shortlong) {
		this.shortlong = shortlong;
	}

	public String[] getImages() {
		return images;
	}

	public void setImages(String[] images) {
		this.images = images;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public String getCoverType() {
		return coverType;
	}

	public void setCoverType(String coverType) {
		this.coverType = coverType;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public List<Book> getRelatives() {
		return relatives;
	}

	public void setRelatives(List<Book> relatives) {
		this.relatives = relatives;
	}

}
