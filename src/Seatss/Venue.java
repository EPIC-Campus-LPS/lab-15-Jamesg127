package Seatss;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Venue {
	private Seat[][] seatArr;
	public Venue(int row, int col, double price) {
		Seat[][] s = new Seat[row][col]; 
		seatArr = s;
		for(int i = 0; i < seatArr.length; i++) {
			for(int j = 0; j < seatArr[i].length; j++) {
				seatArr[i][j].setPrice(price);
				seatArr[i][j].setSold(false);
			}
		}
	}
	
	public boolean buyTicket(int row, int col) {
		if (seatArr[row][col].getSold() == true) {
			return false;
		}
		return true;
	}
	public boolean isAvailable(int row, int col) {
		if (seatArr[row][col].getSold() == true) {
			return false;
		}
		return true;
	}
	public void setPremium(int row, double price) {
		for(int i = 0; i < seatArr[row].length; i++) {
			seatArr[row][i].setType("P");
			seatArr[row][i].setPrice(price);
		}
	}
	public void setPremium(int row, int colStart, int colEnd, double price) {
		for(int i = colStart; i < colEnd; i++) {
			seatArr[row][i].setType("P");
			seatArr[row][i].setPrice(price);
		}
	}
	public void setGA(int row, double price) {
		for(int i = 0; i < seatArr[row].length; i++) {
			seatArr[row][i].setType("G");
			seatArr[row][i].setPrice(price);
		}
	}
	public boolean importTickets(String filename) throws IOException {
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		String[] soldSeats;
		while(scan.hasNextLine()) {
			soldSeats = scan.nextLine().split(",");
			int i = Integer.parseInt(soldSeats[0]);
			int j = Integer.parseInt(soldSeats[1]);
			seatArr[i][j].setSold(true);
		}	
		return true;
	}
	public double totalRevenue()
	{
		int sum = 0;
		for(int i = 0; i < seatArr.length; i++) {
			for (int j = 0; j < seatArr[i].length; j++)
			{
				if (seatArr[i][j].getSold() == true)
				{
					sum += seatArr[i][j].getPrice();
				}
			}
		}
		
		return sum;
	}
	public double totalRevenue(int col)
	{
		int sum = 0;
		for (int i = 0; i < seatArr.length; i++)
		{
			if (seatArr[i][col].getSold() == true)
			{
				sum += seatArr[i][col].getPrice();
			}
		}
		return sum;
	}
	public int totalSold()
	{
		int count = 0;
		for (int i = 0; i < seatArr.length; i++)
		{
			for (int j = 0; j < seatArr[i].length; j++)
			{
				if (seatArr[i][j].getSold() == true)
				{
					count++;
				}
			}
		}
		return count;
	}
	public int totalSold(int row)
	{
		int count = 0;
		for (int j = 0; j < seatArr[row].length; j++)
		{
			if (seatArr[row][j].getSold() == true)
			{
				count++;
			}
		}
		return count;
	}
	public void printVenue()
	{
		for (int i = 0; i < seatArr.length; i++)
		{
			for (int j = 0; j < seatArr[i].length; j++)
			{
				if (seatArr[i][j].getSold() == true)
				{
					System.out.print(i + ", " + j + " : Sold");
				}
				else
				{
					System.out.print(i + ", " + j + " : Not Sold");
				}
			}
		}
	}
	public void printVenueType()
	{
		for (int i = 0; i < seatArr.length; i++)
		{
			for (int j = 0; j < seatArr[i].length; j++)
			{
				if (seatArr[i][j].getType().equals("R"))
				{
					System.out.print(i + ", " + j + " : Regular Seat");
				}
				else if (seatArr[i][j].getType().equals("G"))
				{
					System.out.print(i + ", " + j + " : General Admissions Seat");
				}
				else if (seatArr[i][j].getType().equals("P"))
				{
					System.out.print(i + ", " + j + " : Premium Seat");
				}
			}
		}
	}
	public void printVenuePrice()
	{
		for (int i = 0; i < seatArr.length; i++)
		{
			for (int j = 0; j < seatArr[i].length; j++)
			{
					System.out.print(i + ", " + j + " : " + seatArr[i][j].getPrice());
			}
		}
	}
	public double maxPrice(int rowStart, int rowEnd, int colStart, int colEnd)
	{
		int max = -1;
		for (int i = rowStart; i < rowEnd; i++)
		{
			for (int j = colStart; j < colEnd; j++)
			{
					max += seatArr[i][j].getPrice();
			}
		}
		return max;
	}
	public boolean containsGA(int row)
	{
		for (int j = 0; j < seatArr[row].length; j++)
		{
			if (seatArr[row][j].getType().equals("G"))
			{
				return true;
			}
		}
		return false;
	}
	public boolean allPremium(int col){
		boolean bean = true;
		for (int j = 0; j < seatArr.length; j++){
			if (seatArr[j][col].getType().equals("P")){
			}
			else
			{
				bean = false;
			}
		}
		if (bean)
		{
			return true;
		}
		return false;
	}
}
