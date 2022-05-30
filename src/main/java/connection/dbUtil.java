package connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
public class dbUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("k19WebApp");

    public static EntityManagerFactory getEMF() {
        return emf;
    }
}
