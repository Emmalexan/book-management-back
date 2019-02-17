package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Authorities;
import gr.hua.dit.entity.Function;


public interface FunctionService {

	public void deleteFunction(int id);

	public List<Function> getFunctions();

	public Function getFunction(int id);

	public void saveFunction(Function function);

	public void updateFunction(Function function);

	void updateFunctions(int id, Authorities authority);

}
