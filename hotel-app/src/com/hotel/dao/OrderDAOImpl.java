package com.hotel.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.entity.ConfirmedOrders;

@Repository
public class OrderDAOImpl implements OrderDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger log = Logger.getLogger(OrderDAOImpl.class.getName());
	
	@Transactional
	@Override
	public Integer addTheConfirmedOrderToDB(ConfirmedOrders confirmedOrders) {
		
		log.info("[OrderDAOImpl]Saving the Confirmed Order : " + confirmedOrders.toString());
		Session session = sessionFactory.getCurrentSession();
		session.save(confirmedOrders);
		log.info("[OrderDAOImpl]Confirmed Order Saved: " + confirmedOrders.toString());
		log.info("[OrderDAOImpl]Order Id : " + confirmedOrders.getOrderId());
		
		return confirmedOrders.getOrderId();
	}

	@Transactional
	@Override
	public ConfirmedOrders getConfirmedOrderObjectByOrderId(Integer orderId) {
		
		log.info("[OrderDAOImpl]Getting the Confirmed Order by orderId : " + orderId);
		Session session = sessionFactory.getCurrentSession();
		
		ConfirmedOrders confirmedOrders = session.get(ConfirmedOrders.class, orderId);
		log.info("[OrderDAOImpl] ConfirmedOrders object : " + confirmedOrders.toString());
		
		return confirmedOrders;
	}

	@Transactional
	@Override
	public List<ConfirmedOrders> getConfirmedOrdersByDateMoreThanEqualTo(String date) 
	{
		List<ConfirmedOrders> confirmedOrdersList = new ArrayList<>();
		log.info("[OrderDAOImpl]Getting the Confirmed Orders by Date more than equal to Date: " + date);
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from ConfirmedOrders where orderDate >= :date");
		query.setParameter("date", date);
		
		List<Object> objectList = query.getResultList();
		for(Object object : objectList)
		{
			ConfirmedOrders confirmedOrder = (ConfirmedOrders) object;
			confirmedOrdersList.add(confirmedOrder);
		}
		
		log.info("[OrderDAOImpl]Acquired the Confirmed Orders List: "+ confirmedOrdersList);

		return confirmedOrdersList;
	}
	
	

}
