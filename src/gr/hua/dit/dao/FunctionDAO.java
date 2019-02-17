package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.Authorities;
import gr.hua.dit.entity.Function;



public interface FunctionDAO {

	public List<Function> getFunctions();

	public void deleteFunction(int id);

	public void saveFunction(Function function);

	public Function getFunction(int id);

	public void updateFunction(Function function);

//	public void updateFunctions(int id, Role role);

	void updateFunctions(int id, Authorities auth);
	
}
