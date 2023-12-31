package in.ineuron.util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import in.ineuron.model.CardPayment;
import in.ineuron.model.ChequePayment;
import in.ineuron.model.Payment;


public class HibernateUtil {
	
	private static SessionFactory sessionFactory = null;
	private static Session session = null;
	
	private HibernateUtil(){}
	
	static {
		//if we write addAnnotatedClass(class name) then we don't have to give the mapping details in the hibernate.cfg.xml file
		sessionFactory = new Configuration().configure()
				.addAnnotatedClass(Payment.class)
				.addAnnotatedClass(CardPayment.class)
				.addAnnotatedClass(ChequePayment.class)
				.buildSessionFactory();
	}
	
	public static Session getSession() {
		if(sessionFactory != null)
			session = sessionFactory.openSession();
		return session;
	}
	
	public static void closeSession(Session session) {
		if(session != null)
			session.close();
	}
	
	public static void closeSessionFactory() {
		if(sessionFactory != null)
			sessionFactory.close();
	}
	
}
