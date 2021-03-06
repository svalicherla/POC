package com.deloitte.poc.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.poc.mappers.IPlanMapper;
import com.deloitte.poc.model.Plan;

//Acts as a Service class, implements the IPlanService interface and 
//uses PlanMapper class methods  to interact with the database.
@Service("planService")
public class PlanServiceImpl implements IPlanService {

	/*
	 * @Autowired private SqlSession sqlSession; //This is to demonstrate
	 * injecting SqlSession object
	 */
	@Autowired
	private IPlanMapper planMapper;// This is to demonstrate how to inject
									// Mappers directly

	// This method fetches all the records from database.
	public List<Plan> getAllPlans() {
		List<Plan> planList = planMapper.getAllPlans();
		return planList;
	}

	// This method adds new record to the database.
	public void addPlan(Plan plan) {
		planMapper.addPlan(plan);

	}

	// This method fetches record based on id provided as parameter from the
	// database.
	public Plan getPlanById(int id) {
		Plan planById = planMapper.getPlanById(id);
		return planById;

	}

}
