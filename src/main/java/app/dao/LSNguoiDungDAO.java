package app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import app.dto.LSNguoiDung;
import app.util.HibernateUtil;

public class LSNguoiDungDAO {
	public static int add(LSNguoiDung lsNguoiDung) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		int id = -1;
		try {
			id = (Integer) session.save(lsNguoiDung);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return id;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<LSNguoiDung> layListTatCa() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		List<LSNguoiDung> list = null;
		try {
			String hql = "from LSNguoiDung l order by l.thoiGian desc";
			Query query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
}
