import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;


public class CmtTest {
	/**
	 * SchemaExport
	 */
	@Test
	public void testSchemaExport(){
		Configuration config = new Configuration().configure();
		
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		
		SessionFactory factory = config.buildSessionFactory(registry);
		
		Session session = factory.getCurrentSession();
		
		SchemaExport export = new SchemaExport(config);
		
		export.create(true,true);
		
	}
}
