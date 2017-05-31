package dao;

import model.EmployeeLocation;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeLocationDAOImpl extends AbstractHibernateDAO<EmployeeLocation> {
	public EmployeeLocationDAOImpl() {
		setClazz(EmployeeLocation.class);
	}
}