package in.ineuron.Test;
import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.CardPayment;
import in.ineuron.model.ChequePayment;
import in.ineuron.util.HibernateUtil;


public class InsertApp {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {
				transaction = session.beginTransaction();
			}
			
			if(transaction != null) {
				CardPayment card = new CardPayment();
				card.setPid(1234);
				card.setAmount(8000.5f);
				
				card.setCardNo(12587489577L);
				card.setCardType("Debit");
				card.setPaymenyGateway("visa");
				
				
				ChequePayment cheque = new ChequePayment();
				cheque.setPid(1235);
				cheque.setAmount(50000.50f);
				
				cheque.setChequeNo(52485785426L);
				cheque.setChequeType("self");
				cheque.setExpiryDate(LocalDate.of(23, 4, 25));
				
				session.save(card);
				session.save(cheque);
				flag = true;
			}
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				transaction.commit();
				System.out.println("Object Inserted in the DB");
			}
			else {
				transaction.rollback();
				System.out.println("Object Failed to insert");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
