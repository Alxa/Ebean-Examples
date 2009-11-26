package ebean.howto1;

import java.io.File;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.server.lib.ShutdownManager;

import ebean.howto1.model.Hello;

public class HelloWorld {
	public static void main(String[] args) {
		// ### Configuration Objects ###
		ServerConfig serverConfig = new ServerConfig();
		DataSourceConfig dataSourceConfig = new DataSourceConfig();

		// ### Configuration Settings ###
		// -> data source
		dataSourceConfig.setDriver("org.h2.Driver");
		dataSourceConfig.setUsername("howtouser");
		dataSourceConfig.setPassword("");
		dataSourceConfig.setUrl("jdbc:h2:db/howto1");

		// -> server
		serverConfig.setName("default");
		serverConfig.setDataSourceConfig(dataSourceConfig);

		//  auto create db if does not exist
		if(!(new File("db/howto1.h2.db")).exists()  ){
			serverConfig.setDdlGenerate(true);
			serverConfig.setDdlRun(true);
		}
		// add entity
		serverConfig.addClass(Hello.class);
			
		// create server
		EbeanServer eServer = EbeanServerFactory.create(serverConfig);

		// dealing with data
		long id = 3;
		Hello data = eServer.find(Hello.class, id);
		if (data == null) {
			System.out.println("This is the first run, saving data..");
			eServer.save(new Hello(id, "Hello World!"));
		} else {
			System.out.println(String.format("############\n%s\n############", data.getMessage()));
		}
		// we shouldn't need this see http://groups.google.com/group/ebean/browse_thread/thread/ddbc0eb7f5336ec3
		// for more information
		ShutdownManager.shutdown();
	}
}
