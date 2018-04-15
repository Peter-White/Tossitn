package rpgmakertrash;

import java.util.Scanner;

public class App {

	private static Scanner scanner = new Scanner(System.in);
	private static Node first = null;
	private static Node last = null;
	private static Node current = null;
	
	public static void main(String[] args) {
		
		Node card = new Thing("A discarded Ace of Spades");
		Node quarter = new Money(0.25);
		addFirst(card);
		addFirst(quarter);
		addFirst(new Thing("Condom"));
		junkDrawer();

	}
	
	public static void junkDrawer() {
		System.out.println("Welcome to Tossitn - Junk Drawer Simulator");
		mainMenuInstructions();
		boolean quit = false;
		while (!quit) {
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				addNodeMenu();
				break;
			case 2:
				printList();
				break;
			case 3:
				System.out.println("Under Construction");
				break;
			case 4:
				mainMenuInstructions();
				break;
			default:
				System.out.println("Not Valid");
				break;
			}
		}
	}
	
	private static void addNodeMenu() {
		addNodeInstructions();
		boolean back = false;
		while (!back) {
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
			case 2:
				addNode(choice);
				break;
			case 3:
				addNodeInstructions();
				break;
			case 0:
				System.out.println("Back to main");
				back = true;
				break;
			default:
				System.out.println("Not valid");
				break;
			}
		}
	}
	
	public static void interateThroughNodes() {
		if(first == null) {
			System.out.println("Nothing in the drawer.");
		}
		Node position;
		if(current == null) {
			position = first;
		} else {
			position = current;
		}
		interationMenu();
		boolean back = false;
		while (!back) {
			System.out.println(position.getData());
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				if(position.getNext() != null) {
					position = position.getNext();
					current = position;
				} else {
					System.out.println("Bottom of the drawer reached");
				}
				break;
			case 2:
				if(position.getPrevious() != null) {
					position = position.getPrevious();
					current = position;
				} else {
					System.out.println("Top of the pile reached");
				}
				break;
			default:
				System.out.println("Not Valid");
				break;
			}
		}
	}
	
	public static void mainMenuInstructions() {
		System.out.println("Press: ");
		System.out.println("1 - To add an item to the drawer");
		System.out.println("2 - To print a list of items");
		System.out.println("3 - To cycle trough items manually");
		System.out.println("4 - To print instructions");
		System.out.println("0 - To quit");
	}
	public static void addNodeInstructions() {
		System.out.println("Press: ");
		System.out.println("1 - To add a coin / dallor bill");
		System.out.println("2 - To add a random object");
		System.out.println("3 - To print instructions");
		System.out.println("0 - To go back");
	}
	public static void interationMenu() {
		System.out.println("Press: ");
		System.out.println("1 - To go to the next item");
		System.out.println("2 - To go back to the previous item");
		System.out.println("3 - To add a new item");
		System.out.println("4 - To remove an item");
		System.out.println("5 - To start from the begining");
		System.out.println("6 - To print instructions");
		System.out.println("0 - To go back");
	}
	
	private static void addNode(int i) {
		Node newNode;
		if(i == 1) {
			System.out.println("Enter coin or bill type by dallor value e.g. 0.25 for a quarter");
			double value = scanner.nextDouble();
			newNode = new Money(value);
		} else {
			System.out.println("Enter he name of the object");
			String title = scanner.nextLine();
			newNode = new Thing(title);
		}
		
		if(first == null) {
			addFirst(newNode);
		}
	}
	
	public static void addFirst(Node node) {
		node.setNext(first);
		first = node;
		System.out.println("First node added");
		if(last == null) {
			last = node;
		}
	}
	
	public static void addLast(Node node) {
		node.setPrevious(last);
		last = node;
	}
	
	public static void printList() {
		Node current = first;
		int i = 1;
		while (current != null) {
			System.out.println(i + ". " +current.getData());
			current = current.getNext();
			i++;
		}
	}
}
