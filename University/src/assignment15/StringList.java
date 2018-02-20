package assignment15;

public class StringList {
	private CharNode _head;

	public StringList() {
		_head = null;
	}

	public StringList(CharNode node) {
		if (node == null)
			_head = null;
		else {
			_head = new CharNode(node.getData(), node.getValue(), null);
			for (CharNode ptr = node.getNext(), last = _head; ptr != null; ptr = ptr.getNext()) {
				last.setNext(new CharNode(ptr.getData(), ptr.getValue(), ptr.getNext()));
				last = last.getNext();
			}
		}
	}

	public StringList(String s) {
		if (s == null)
			_head = null;
		else {
			_head = new CharNode(s.charAt(0), 1, null);
			CharNode ptr = _head;

			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) == s.charAt(i - 1))
					ptr.setValue(ptr.getValue() + 1);
				else {
					ptr.setNext(new CharNode(s.charAt(i), 1, null));
					ptr = ptr.getNext();
				}
			}
		}
	}

	public StringList(StringList other) {
		this(other._head);
	}

	public char charAt(int i) {
		CharNode ptr = _head;

		for (int j = 0; j + ptr.getValue() <= i; j += ptr.getValue(), ptr = ptr.getNext()) {
		}

		return ptr.getData();
	}

	public StringList concat(StringList str) {
		CharNode head = new CharNode(this.charAt(0), 1, null);

		CharNode ptr = head;
		for (int i = 1; i < this.length(); i++) {
			if (this.charAt(i) == this.charAt(i - 1))
				ptr.setValue(ptr.getValue() + 1);
			else {
				ptr.setNext(new CharNode(this.charAt(i), 1, null));
				ptr = ptr.getNext();
			}
		}

		ptr.setNext(new CharNode(str.charAt(0), 1, null));
		ptr = ptr.getNext();

		for (int j = 1; j < str.length(); j++) {
			if (str.charAt(j) == str.charAt(j - 1))
				ptr.setValue(ptr.getValue() + 1);
			else {
				ptr.setNext(new CharNode(str.charAt(j), 1, null));
				ptr = ptr.getNext();
			}
		}

		return new StringList(head);
	}

	public int indexOf(int ch, int fromIndex) {
		CharNode ptr = _head;
		int i = fromIndex;

		for (int j = 0; j + ptr.getValue() <= fromIndex; j += ptr.getValue(), ptr = ptr.getNext()) {
		}

		for (; ptr.getData() != ch && ptr.getNext() != null; i += ptr.getValue(), ptr = ptr.getNext()) {
		}

		if (ptr.getNext() == null)
			return -1;

		return i;
	}

	public int indexOf(int ch) {
		return this.indexOf(ch, 0);
	}

	public boolean equals(StringList str) {
		if (this.length() != str.length())
			return false;

		return equals(str, 0);
	}

	private boolean equals(StringList str, int index) {
		if (index < this.length()) {
			if (str.charAt(index) != this.charAt(index))
				return false;
		} else
			return true;

		return equals(str, index + 1);
	}

	public int compareTo(StringList str) {
		if (this.equals(str))
			return 0;

		return compareTo(str, 0);
	}

	private int compareTo(StringList str, int index) {
		if (index == this.length() || index == str.length())
			return this.length() > str.length() ? -1 : 1;
		else if (this.charAt(index) < str.charAt(index))
			return -1;
		else if (this.charAt(index) > str.charAt(index))
			return 1;
		
		
		return compareTo(str, index + 1);
	}

	public StringList substring(int i, int j) {
		CharNode head = new CharNode(this.charAt(i), 1, null);

		CharNode ptr = head;
		for (i++; i <= j; i++) {
			if (this.charAt(i) == this.charAt(i - 1))
				ptr.setValue(ptr.getValue() + 1);
			else {
				ptr.setNext(new CharNode(this.charAt(i), 1, null));
				ptr = ptr.getNext();
			}
		}

		return new StringList(head);
	}

	public StringList substring(int i) {
		return this.substring(i, length() - 1);
	}

	public int length() {
		CharNode ptr = _head;
		int count = 0;

		while (ptr != null) {
			count += ptr.getValue();
			ptr = ptr.getNext();
		}

		return count;
	}

	public String toString() {
		String s = "\"";
		CharNode ptr = _head;

		while (ptr != null) {
			for (int i = 0; i < ptr.getValue(); i++)
				s += ptr.getData();

			ptr = ptr.getNext();
		}

		return s + "\"";
	}
}