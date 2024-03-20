package entities;

import java.util.Optional;

public class Sale {

	private final Integer month;
	private final Integer year;
	private final String seller;
	private final Integer items;
	private final Double total;

	public Sale(Integer month, Integer year, String seller, Integer items, Double total) {
		this.month = month;
		this.year = year;
		this.seller = seller;
		this.items = items;
		this.total = total;
	}

	public Integer getMonth() {
		return month;
	}

	public Integer getYear() {
		return year;
	}

	public String getSeller() {
		return seller;
	}

	public Integer getItems() {
		return items;
	}

	public Double getTotal() {
		return total;
	}

	public Optional<Double> averagePrice() {
		if (items == 0) {
			return Optional.empty();
		}
		return Optional.of(total / items);
	}

	@Override
	public String toString() {
		return "Sale [month=" + month + ", year=" + year + ", seller=" + seller + ", items=" + items + ", total="
				+ total + ", averagePrice=" + averagePrice().orElse(0.0) + "]";
	}
}
