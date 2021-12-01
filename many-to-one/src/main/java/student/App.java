package student;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		Books books = new Books(101, "Java", null);
		Books books2 = new Books(102, "Cpp", null);
		Books books3 = new Books(103, "Webdesigning", null);
		Books books4 = new Books(104, "C", null);

		List<Books> book = new ArrayList<Books>();
		book.add(books);
		book.add(books2);
		book.add(books3);

		List<Books> book1 = new ArrayList<Books>();
		book1.add(books4);

		Student student = new Student(1, "prasanna", book);
		Student student2 = new Student(2, "Rajendra", book1);
		Student student3 = new Student(3, "Rani", null);
		Student student4 = new Student(4, "Rekha", null);
		
		books.setStudent(student);
		books2.setStudent(student);
		books3.setStudent(student);
		books4.setStudent(student2);
		

		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Books.class);
		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(student);
		session.save(student2);
		session.save(student3);
		session.save(student4);

		session.save(books);
		session.save(books2);
		session.save(books3);
		session.save(books4);

		tx.commit();

	}
}
