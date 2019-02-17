package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.Authorities;

public interface AuthoritiesDAO {

	List<Authorities> getAuthorities();

	void saveAuthoritie(Authorities authoritie);

	Authorities getAuthoritie(String authority);

	void deleteAuthoritie(String authority);

	void updateAuthoritie(Authorities authority);

	Authorities getAuthoritieId(int id);

}
