package entityrunner;

import entity.Address;
import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author RasmusFriis
 */
public class run {

    public static void main(String[] args) {
        Persistence.generateSchema("pu", null);
        Customer cust = new Customer("karry", "harry");
        Customer cust2 = new Customer("larry", "aarry");
        Address address = new Address("dfg", "hejby");
        Address address2 = new Address("lrenfg", "nfgfg");
        Address address3 = new Address("sejevej", "borer");
        cust.addAddress(address);
        cust.addAddress(address2);
        cust.addAddress(address3);
        address.setCustomer(cust);
        address2.setCustomer(cust);
        address3.setCustomer(cust);

        EntityManager em = Persistence.createEntityManagerFactory("pu").createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cust);
            em.persist(cust2);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

}
