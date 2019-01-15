package books;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads in books from a csv file and then sorts them using Comparable and a Comparator
 * @author Jesse Tice
 *
 */
public class Book implements Comparable<Book>
{
	private String title;
	private String author;
	private int year;
	
	public Book (String title, String author, int year)
	{
		this.title = title;
		this.author = author;
		this.year = year;
	}
	
	/**
	 * Getter for book title.
	 * @return title
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * Getter for book author.
	 * @return author
	 */
	public String getAuthor()
	{
		return author;
	}
	
	/**
	 * Getter for book year.
	 * @return year
	 */
	public int getYear()
	{
		return year;
	}
	
	/**
	 * Structures the sentence for toString
	 */
	@Override
	public String toString()
	{
		return title + " by " + author + " (" + year + ")";
	}
	
	
	/**
	 * Create list of books using the file param
	 * @param file
	 * @return List<Book>
	 */
	public static List<Book> getList (String file)
	{
		List<Book> bookList = new ArrayList<Book>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String inputLine = br.readLine();
			while (inputLine != null)
			{
				String[] singleBook = inputLine.split(",");
				if (singleBook.length == 3)
				{
				Book myBook = new Book(singleBook[0], singleBook[1], Integer.parseInt(singleBook[2]));
				bookList.add(myBook);
				}
				else {
					System.err.println("Problem reading in \"" + inputLine + "\"");
				}
				inputLine = br.readLine();
			}
		}
		
		catch (Exception e)
		{
			System.out.printf("Problem reading in \"%s\"%n", e.getMessage());
		}
		return bookList; 
	}
	
	/**
	 * Changing how compareTo sorts data
	 */
	@Override
	public int compareTo(Book that)
	{
		return (this.getTitle().compareTo(that.getTitle()));
	}
}
