package com.deloitte.poc.mappers;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.deloitte.poc.model.Plan;

//Acts as a Mapper class and maps the attributes in the model class to the database columns.
public interface IPlanMapper {
	
	//Queries to interact with the database.
	final String getAllPlans = "SELECT * FROM poc.plan";
	final String addPlan = "INSERT INTO poc.plan(id, planName, deductible, monthlyCost, hsaCompatible) values (#{id},#{planName},#{deductible},#{monthlyCost},#{hsaCompatible}) ";
	final String getPlanById = "SELECT  plan.id, plan.planName, plan.deductible, plan.monthlyCost, plan.hsaCompatible FROM poc.plan where id=#{id}";
			
	//Fetches all the records from database. 
	//Iterating the resultset and mapping the attribute names.
	@Select(getAllPlans)
	   @Results(value = {
	      @Result(property = "id", column = "id"),
	      @Result(property = "planName", column = "planName"),
	      @Result(property = "deductible", column = "deductible"),
	      @Result(property = "monthlyCost", column = "monthlyCost"),       
	      @Result(property = "hsaCompatible", column = "hsaCompatible")
	      })
	List<Plan> getAllPlans();
	
	//Add the record to the database. 
	//Since the id in the database is autogenerated, set the property useGeneratedKeys to true.
	@Insert(addPlan)
	   @Options(useGeneratedKeys = true, keyProperty = "id")
	   void addPlan(Plan plan);
	
	//Fetches the record from the database with the id provided.
	@Select(getPlanById)
	public Plan getPlanById(int id);

}
