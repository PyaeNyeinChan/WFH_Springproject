package com.chan.spring.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.chan.spring.domain.Customer;

@Repository
public class CustomerRepo {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void create(Customer c) {
		em.persist(c);
	}
	
	@Transactional
	public void update(Customer c) {
		em.merge(c);
	}
	
	@Transactional
	public void delete(int id) {
		em.remove(em.find(Customer.class, id));
	}

	public Customer find(int id) {
		return em.find(Customer.class, id);
	}
	public List<Customer> findAll(){
		return em.createNamedQuery("findAll",Customer.class).getResultList();
	}
	
	public List<Customer> findByName(String name){
		return em.createNamedQuery("findByName",Customer.class).setParameter("name", name).getResultList();
	}
}
