package root.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToMany
	List<CartItem> cartItems = new ArrayList<CartItem>();

	public double totalAmount() {
		double result = 0;
		for (int i = 0; i < this.size(); i++) {
			result += this.cartItems.get(i).getAmount();
		}
		return result;
	}

	public int size() {
		return this.cartItems.size();
	}
}
