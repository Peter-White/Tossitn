package rpgmakertrash;

public abstract class Node {
	
	private Object data;
	
	public Node(Object data) {
		super();
		this.data = data;
	}
	private Node previous;
	private Node next;

	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Node getPrevious() {
		return previous;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}
