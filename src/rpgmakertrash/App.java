package rpgmakertrash;

import java.util.Scanner;

public class App {

	private static Scanner scanner = new Scanner(System.in);
	private static Node first = null;
	private static Node last = null;
	
	public static void main(String[] args) {
		
		Node card = new Thing("A discarded Ace of Spades");
		Node quarter = new Money(0.25);
		addFirst(card);
		addFirst(quarter);
		addFirst(new Thing("Condom"));
		junkDraw();

	}
	
	public static void junkDraw() {
		System.out.println("Welcome to Tossitn - Junk Draw Simulator");
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
	
	public static void mainMenuInstructions() {
		System.out.println("Press: ");
		System.out.println("1 - To add an item to the draw");
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
	
	private static void addNode(int i) {
		
	}
	
	public static void addFirst(Node node) {
		node.setNext(first);
		first = node;
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
