package employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		Employee employee = new Employee(1, "Prasanna", null);
		Employee employee2 = new Employee(2, "Rajendra", null);
		Employee employee3 = new Employee(3, "Rekha", null);

		Designation designation = new Designation(505, "Softwate developer", employee);
		Designation designation2 = new Designation(506, "Backend Developer", employee2);
		Designation designation3 = new Designation(508, "Networking", employee3);

		employee.setDisgnation(designation);
		employee2.setDisgnation(designation2);
		employee3.setDisgnation(designation3);

		Configuration config = new Configuration().configure().addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Designation.class);
		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(employee);
		session.save(employee2);
		session.save(employee3);

		session.save(designation);
		session.save(designation2);
		session.save(designation3);

		tx.commit();
		session.close();

	}
}