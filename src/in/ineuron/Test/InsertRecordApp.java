package in.ineuron.Test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.InsurancePolicy;
import in.ineuron.Util.HibernateUtil;

public class InsertRecordApp {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		Long id = null;
		boolean flag = false;
		try {
		session=HibernateUtil.getSession();
		if(session != null)
		 transaction=session.beginTransaction();
		if(transaction != null)
		{
			
			InsurancePolicy policy = new InsurancePolicy();
			policy.setCompany("LIC");
			policy.setPolicyName("Jeevan Anada");
			policy.setPolicyType("yearly");
			policy.setTenure(5);
			
		id	= (Long) session.save(policy);
		flag = true;
		}
		
		
		}catch (HibernateException e) {
			e.printStackTrace();
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			if(flag)
			{
				transaction.commit();
				System.out.println("Object inserted into database with the id :: "+ id);
			}
			else
			{
				transaction.rollback();
				System.out.println("Object not inserted into database");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
