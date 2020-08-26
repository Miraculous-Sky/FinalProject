package root.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
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

}
