package rpgmakertrash;

import java.util.Scanner;

public class App {

	private static Scanner scanner = new Scanner(System.in);
	private static Node first = null;
	private static Node last = null;
	private static Node current = null;
	
	public static void main(String[] args) {
		
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
				if(first != null) {
					iterationMenu();
				} else {
					System.out.println("Nothing in the drawer. Try adding something first.");
				}
				break;
			case 4:
				quit = true;
				break;
			case 0:
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
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();
			switch (choice) {
				case 1:
				case 2:
					Node newNode = createNode(choice);
					addFirst(newNode);
					break;
				case 3:
					System.out.println("Back to main");
					System.out.println("");
					back = true;
					break;
				case 0:
					addNodeInstructions();
					break;
				default:
					System.out.println("Not valid");
					System.out.println("");
					break;
			}
		}
	}
	
	public static void iterationMenu() {
		if(first == null) {
			System.out.println("Nothing in the drawer.");
			System.out.println("");
		}
		Node position;
		if(current == null) {
			position = first;
		} else {
			position = current;
		}
		current = position;
		iterationInstructions();
		System.out.println("Currently set to: " + position.getData());
		System.out.println("");
		boolean back = false;
		while (!back) {
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				if(position.getNext() != null) {
					position = position.getNext();
					current = position;
					System.out.println(position.getData());
				} else {
					System.out.println("Bottom of the drawer reached");
					System.out.println("");
				}
				break;
			case 2:
				System.out.println(position.getData());
				System.out.println("");
				break;
			case 3:
				if(position.getPrevious() != null) {
					position = position.getPrevious();
					current = position;
					System.out.println(position.getData());
				} else {
					System.out.println("Top of the pile reached");
					System.out.println("");
				}
				break;
			case 4:
				addNodeInstructionsMin();
				int type = scanner.nextInt();
				switch (type) {
					case 1:
					case 2:
						addNode(position, type);
						break;
					default:
						System.out.println("Not valid");
						System.out.println("");
						break;
				}
				break;
			case 5:
				deleteNode(position);
				if(position.getPrevious() == null) {
					if(position.getNext() == null) {
						System.out.println("Your junk drawer is empty. Going back to main.");
						back = true;
					} else {
						position = position.getNext();
					}
				} else {
					position = position.getPrevious();
				}
				break;
			case 6:
				current = first;
				System.out.println(current.getData());
				System.out.println("");
				break;
			case 7:
				System.out.println("Back to main");
				System.out.println("");
				back = true;
				break;
			case 0:
				iterationInstructions();
				break;
			default:
				System.out.println("Not Valid");
				System.out.println("");
				break;
			}
		}
	}
	
	public static void mainMenuInstructions() {
		System.out.println("");
		System.out.println("Press: ");
		System.out.println("1 - To add an item to the top of the drawer");
		System.out.println("2 - To print a list of items");
		System.out.println("3 - To cycle trough items manually");
		System.out.println("4 - To quit");
		System.out.println("0 - To print instructions");
		System.out.println("");
	}
	public static void addNodeInstructions() {
		System.out.println("");
		System.out.println("Press: ");
		System.out.println("1 - To add a coin / dallor bill");
		System.out.println("2 - To add a random object");
		System.out.println("3 - To go back");
		System.out.println("0 - To print instructions");
		System.out.println("");
	}
	public static void addNodeInstructionsMin() {
		System.out.println("");
		System.out.println("Press: ");
		System.out.println("1 - To add a coin / dallor bill");
		System.out.println("2 - To add a random object");
		System.out.println("");
	}
	public static void iterationInstructions() {
		System.out.println("");
		System.out.println("Press: ");
		System.out.println("1 - To go to the next item");
		System.out.println("2 - To see current item");
		System.out.println("3 - To go back to the previous item");
		System.out.println("4 - To add a new item");
		System.out.println("5 - To remove an item");
		System.out.println("6 - To start from the begining");
		System.out.println("7 - To go back");
		System.out.println("0 - To print instructions");
		System.out.println("");
	}
	
	private static void addNode(Node node, int choice) {
		Node newNode = createNode(choice);
		Node next = node.getNext();
		if(next == null) {
			node.setNext(newNode);
			newNode.setPrevious(node);
			last = newNode;
			System.out.println(newNode.getData() + " is at the bottom of the drawer");
		} else {
			next.setPrevious(newNode);
			node.setNext(newNode);
			newNode.setNext(next);
			newNode.setPrevious(node);
			System.out.println(newNode.getData() + " is lying between " + 
			node.getData() + " and " + next.getData());
			System.out.println("");
		}
	}
	
	private static void deleteNode(Node node) {
		boolean done = false;
		while (!done) {
			System.out.println("Are you sure you want to delete " + node.getData()
			 + "? (y/n)");
			String selection = scanner.nextLine();
			selection = selection.toLowerCase();
			switch (selection) {
				case "y":
					if(node == first && node != last) {
						node.getNext().setPrevious(null);
						first = node.getNext();
						System.out.println("The first item has been removed from drawer");
						System.out.println("");
					} else if (node != first && node == last) {
						node.getPrevious().setNext(null);
						last = node.getPrevious();
						System.out.println("The last item has been removed from drawer");
						System.out.println("");
					} else if (node != first && node != last) {
						node.getPrevious().setNext(node.getNext());
						node.getNext().setPrevious(node.getPrevious());
					} else {
						first = null;
						last = null;
					}
					done = true;
					break;
				case "n":
					done = true;
					break;
				default:
					System.out.println("Not Valid");
					System.out.println("");
					break;
			}
		}

	}
	
	public static void addFirst(Node node) {
		if(first == null) {
			first = node;
		} else {
			node.setNext(first);
			first.setPrevious(node);
			first = node;
		}
		System.out.println(node.getData() + " is on top of the pile");
		System.out.println("");
		if(last == null) {
			last = node;
		}
	}
	
	public static void addLast(Node node) {
		node.setPrevious(last);
		last.setNext(node);
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
		System.out.println("");
	}
	
	public static Node createNode(int choice) {
		Node newNode;
		if(choice == 1) {
			System.out.println("Enter coin or bill type by dallor value e.g. 0.25 for a quarter");
			double value = scanner.nextDouble();
			newNode = new Money(value);
		} else {
			System.out.println("Enter the name of the object");
			scanner.nextLine();
			String thing = scanner.nextLine();
			newNode = new Thing(thing);
		}
		return newNode;
	}
}
