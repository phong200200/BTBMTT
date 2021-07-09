package app.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import app.dto.NguoiDung;
import app.util.HibernateUtil;

public class NguoiDungDAO {
	@SuppressWarnings("rawtypes")
	public static NguoiDung layNguoiDungDangNhap(String email, String password) {
		NguoiDung user = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			String hql = "from NguoiDung u where u.email = ?0 and u.matKhau = ?1";
			Query query = session.createQuery(hql);
			query.setParameter(0, email);
			query.setParameter(1, password);
			user = (NguoiDung) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}
	
	public static int add(NguoiDung nguoiDung) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		int id = -1;
		try {
			id = (Integer) session.save(nguoiDung);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return id;
	}
	
	public static void update(NguoiDung nguoiDung) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			
			session.update(nguoiDung);
			
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		}
		
	}
}
