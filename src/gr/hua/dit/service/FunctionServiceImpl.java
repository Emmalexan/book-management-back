package gr.hua.dit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.FunctionDAO;
import gr.hua.dit.entity.Authorities;
import gr.hua.dit.entity.Function;



@Service
public class FunctionServiceImpl implements FunctionService {
	
		@Autowired
		private FunctionDAO functionDAO;

		@Override
		@Transactional
		public void deleteFunction(int id) {
			functionDAO.deleteFunction(id);
			
		}
		
		@Override
		@Transactional
		public List<Function> getFunctions() {
			return functionDAO.getFunctions();
		}

		@Override
		@Transactional
		public Function getFunction(int id) {
			return functionDAO.getFunction(id);
		}

		@Override
		@Transactional
		public void saveFunction(Function function) {
			functionDAO.saveFunction(function);		
		}

		@Override
		@Transactional
		public void updateFunction(Function function) {
			functionDAO.updateFunction(function);
		}
		
	/*	@Override
		@Transactional
		public void updateFunctions(int id, Role role) {
			functionDAO.updateFunctions(id,role);
		}*/
		
		@Override
		@Transactional
		public void updateFunctions(int id, Authorities authority) {
			functionDAO.updateFunctions(id,authority);
		}
}
