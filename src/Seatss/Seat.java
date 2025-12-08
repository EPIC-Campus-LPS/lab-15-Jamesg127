package Seatss;

public class Seat {
	private static boolean sold;
	private static String type;
	private static double price;
	
	public static boolean getSold() {
		return sold;
	}
	public static String getType() {
		return type;
	}
	public static double getPrice() {
		return price;
	}
	public static void setSold(boolean s) {
		sold = s;
	}
	public static void setType(String t) {
		type = t;
	}
	public static void setPrice(double p) {
		price = p;
	}
	public Seat(boolean s, String t, double p) {
		
	}
}
