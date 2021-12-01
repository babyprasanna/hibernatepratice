package cachingstudent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		Branch branch = new Branch(505, "cse");

		Student student = new Student(1, "prasanna", "velpur", "Female", branch);
		Student student1 = new Student(2, "Rajendra", "Tanuku", "male", branch);
		Student student2 = new Student(3, "Rekha", "Velpur", "Female", branch);

		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Branch.class);
		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(branch);
		session.save(student);
		session.save(student1);
		session.save(student2);

		tx.commit();
		session.close();

		Session session1 = sf.openSession();

		Student s1 = session1.get(Student.class, 2);
		System.out.println(s1);

		session1.close();

		Session session2 = sf.openSession();

		Student s = session2.get(Student.class, 2);
		System.out.println(s);

		session2.close();

	}

}
