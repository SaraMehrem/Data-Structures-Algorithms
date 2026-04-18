package palindrome;

public class ListA {

	char a[];
	int top;
//	int size;

	public ListA() {
//		a = new char[size];
		top = -1;
//		size = 5;
	}

	void push(char data) {

		top++;
		a[top] = data;

	}

	void pop() {
		top--;
	}

	char top() {
		return a[top];
	}

	boolean isEmpty() {
		return top == -1;
	}

	boolean isPalindrome(String s) {
		
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		char arr[] = s.toCharArray();

		int n = arr.length;
		a = new char[n * 4];
		

		int i;
		int mid = n / 2;

		for (i = 0; i < mid; i++) {
			push(arr[i]);

		}

		if (n % 2 != 0)
			i++;

		while (i < n) {

			char m = top();

			if (m != arr[i])
				return false;

			pop();

			i++;
		}
		return true;
	}

	void print() {
		System.out.print("[");
		for (int i = 0; i <= top; i++) {

			System.out.print(a[i]);

			if (i < top)
				System.out.print(", ");

		}
		System.out.println("]");
	}

}
