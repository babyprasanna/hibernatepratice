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

		List<Student> std = new ArrayList<Student>();
		List<Activities> act = new ArrayList<Activities>();

		List<Student> std1 = new ArrayList<Student>();
		List<Activities> act1 = new ArrayList<Activities>();

		List<Student> std2 = new ArrayList<Student>();
		List<Activities> act2 = new ArrayList<Activities>();

		Student student = new Student(1, "Prasanna", null);
		Student student2 = new Student(2, "Rajendra", null);
		Student student3 = new Student(3, "Rekha", null);

		std.add(student);
		std.add(student2);
		std.add(student3);

		std1.add(student);
		std1.add(student2);

		std1.add(student3);
		std1.add(student2);

		Activities activities = new Activities(101, "Dancing", std);
		Activities activities1 = new Activities(102, "singing", std1);
		Activities activities2 = new Activities(103, "Drawing", std);
		Activities activities3 = new Activities(104, "Pottery", std2);
		Activities activities4 = new Activities(105, "Woodworking", std2);

		act.add(activities);
		act.add(activities1);
		act.add(activities2);
		act1.add(activities);
		act1.add(activities1);
		act1.add(activities2);
		act1.add(activities3);
		act2.add(activities);
		act2.add(activities1);
		act2.add(activities2);
		act2.add(activities3);
		act2.add(activities4);

		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Activities.class);
		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(student);
		session.save(student2);
		session.save(student3);

		session.save(activities);
		session.save(activities1);
		session.save(activities2);
		session.save(activities3);
		session.save(activities4);

		tx.commit();

	}

}
