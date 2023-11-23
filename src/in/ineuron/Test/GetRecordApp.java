package in.ineuron.Test;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.CardPayment;
import in.ineuron.model.ChequePayment;
import in.ineuron.model.Payment;
import in.ineuron.util.HibernateUtil;


public class GetRecordApp {

	public static void main(String[] args) {
		
		Session session = null; 
		
		try {
			
			session = HibernateUtil.getSession();
			
			Query<Payment> query = session.createQuery("from in.ineuron.model.Payment");
			
			List<Payment> list = query.getResultList();
			list.forEach(System.out::println);
			
			System.out.println();
			
			Query<CardPayment> cardQuery = session.createQuery("from in.ineuron.model.CardPayment");
			
			List<CardPayment> cardList = cardQuery.getResultList();
			cardList.forEach(System.out::println);
			
			System.out.println();
			
			Query<ChequePayment> chequeQuery = session.createQuery("from in.ineuron.model.ChequePayment");
			
			List<ChequePayment> chequeList = chequeQuery.getResultList();
			chequeList.forEach(System.out::println);
			
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
