package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.Secretary;


public interface SecretaryDAO {

	public List<Secretary> getSecretaries();

	public Secretary getSecretary(int id);

	public void saveSecretary(Secretary secretary);

	public void deleteSecretary(int id);

	public void updateSecretary(Secretary secretary);

	

}
