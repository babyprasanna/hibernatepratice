package student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		Laptop laptop = new Laptop();
		laptop.setId(212);
		laptop.setName("Dell");
		laptop.setStudent(null);

		Laptop laptop1 = new Laptop();
		laptop1.setId(505);
		laptop1.setName("aspire");
		laptop1.setStudent(null);

		Student student = new Student(1, "Rajendra", laptop);
		laptop.setStudent(student);

		Student student1 = new Student();

		student1.setRollnum(2);
		student1.setName("Prasanna");
		student1.setLaptop(laptop1);

		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);
		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(laptop);
		session.save(student);

		session.save(laptop1);
		session.save(student1);

		tx.commit();

	}

}
