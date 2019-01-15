package books;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * BookApp is the test client for Book
 * @author Jesse Tice
 *
 */
public class BookApp
{
	/**
	 * Main class which sorts and prints the book list.
	 * @param args
	 */
	public static void main(String[] args)
	{
		List<Book> myList = Book.getList("src/books/books.csv");
		System.out.println("Number of books read in: " + myList.size() + "\n");
		Collections.sort(myList);
		System.out.println("Sorted book list:");
		for (Book el : myList)
		{
			System.out.println(el);
		}
		
		Comparator<Book> reverseOrder = Collections.reverseOrder();
		Collections.sort(myList, reverseOrder);
		System.out.println("\nReverse order:");
		for (Book el : myList)
		{
			System.out.println(el);
		}	
	}
}
