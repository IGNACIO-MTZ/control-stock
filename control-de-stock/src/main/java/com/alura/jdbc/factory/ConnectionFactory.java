package com.alura.jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	private DataSource datasource;
	public ConnectionFactory() {
		var pooledDatasource = new ComboPooledDataSource();
		pooledDatasource.setJdbcUrl("jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimeZone=UTC");
		pooledDatasource.setUser("root");
		pooledDatasource.setPassword("ccnobe1719");
		pooledDatasource.setMaxPoolSize(10);
		this.datasource = (DataSource) pooledDatasource;
	}
	public Connection recuperaConexion() {
		try {
			return this.datasource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


}
