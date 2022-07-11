package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.SportDao;
import entity.Sport;

public class Menu {
	
	private SportDao sportDao = new SportDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Sports",
			"Add Sport",
			"Remove Sport",
			"Update");
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if (selection.equals("1")) {
						displaySports();
				} else if (selection.equals("2")) {
						addSport();
				} else if (selection.equals("3")) {
						deleteSport();
				} else if (selection.equals("4")) {
						updateSport();
				}
			}  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Press enter to continue");
			scanner.nextLine();
			
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an Option:\n------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void displaySports() throws SQLException {
		List<Sport> sports = sportDao.getSports();
		for (Sport sport : sports) {
			System.out.println(sport.getSportId() + ": " + sport.getSport());
		}
	}
	
	private void addSport() throws SQLException {
		System.out.println("Enter new sport:");
		String name = scanner.nextLine();
		sportDao.createNewSport(name);
	}
	
	private void deleteSport() throws SQLException {
		displaySports();
		System.out.println("Choose sport to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		sportDao.deleteSport(id);
	}
	
	private void updateSport() throws SQLException {
		displaySports();
		System.out.println("Enter id to update:");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter name of new sport:");
		String name = scanner.nextLine();
		sportDao.updateSport(name, id);
	}
	
}
