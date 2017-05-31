package dao;

import model.EmployeePushid;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

@Repository
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class EmployeePushidDAOImpl extends AbstractHibernateDAO<EmployeePushid> {
	public EmployeePushidDAOImpl() {
		setClazz(EmployeePushid.class);
	}
}