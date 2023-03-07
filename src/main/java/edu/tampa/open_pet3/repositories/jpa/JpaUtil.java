package edu.tampa.open_pet3.repositories.jpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JpaUtil {
    @PersistenceContext
    private EntityManager em;

    public void clear2ndLevelHibernateCache(){
        Session session = (Session) em.getDelegate();
        SessionFactory sf= session.getSessionFactory();
        sf.getCache().evictQueryRegions();
        sf.getCache().evictDefaultQueryRegion();
        sf.getCache().evictCollectionRegions();
        sf.getCache().evictEntityRegions();
    }
}
