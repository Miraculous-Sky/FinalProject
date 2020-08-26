package root.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Genre {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	@Column
	private String name;

	@OneToMany
	private List<Book> books;

}
