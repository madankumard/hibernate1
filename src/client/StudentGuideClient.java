package client;

import entity.Guide;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class StudentGuideClient {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction txn = session.getTransaction();

        try{
            txn.begin();

            Guide guide = new Guide("2000MO10789", "Mike Lawson", 1000);
            Student student = new Student("2014JT50123", "John Smith", guide);

            //session.save(guide);
            session.persist(student);

            Student student1 = session.get(Student.class, 6L);
            session.delete(student1);

            txn.commit();
        }catch (Exception e){
            if(txn != null) txn.rollback();
            e.printStackTrace();
        }finally {
            if(session!=null) session.close();
        }
    }
}
