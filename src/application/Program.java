package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Sale;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Entre o caminho do arquivo: ");
			String path = sc.nextLine();
			List<Sale> list = new ArrayList<>();

			try (BufferedReader br = new BufferedReader(new FileReader(path))) {
				String line;
				while ((line = br.readLine()) != null) {
					String[] parts = line.split(",");
					if (parts.length >= 5) {
						try {
							Integer month = Integer.parseInt(parts[0]);
							Integer year = Integer.parseInt(parts[1]);
							String seller = parts[2];
							Integer items = Integer.parseInt(parts[3]);
							Double total = Double.parseDouble(parts[4]);

							Sale sale = new Sale(month, year, seller, items, total);
							list.add(sale);
						} catch (NumberFormatException e) {
							System.out.println("Error parsing line: " + line);
						}
					}
				}
			} catch (IOException e) {
				System.out.println("Error reading file: " + e.getMessage());
				return;
			}
			System.out.println();

			System.out.println("Total de vendas por vendedor:");
			Map<String, Double> totalSoldBySeller = list.stream()
					.collect(Collectors.groupingBy(Sale::getSeller, Collectors.summingDouble(Sale::getTotal)));

			totalSoldBySeller
					.forEach((seller, total) -> System.out.println(String.format("%s - R$ %.2f", seller, total)));

		}
	}
}
