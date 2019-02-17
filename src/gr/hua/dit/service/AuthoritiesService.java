package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Authorities;

public interface AuthoritiesService {

	List<Authorities> getAuthorities();

	void saveAuthoritie(Authorities authoritie);

	Authorities getAuthoritie(String authority);

	void deleteAuthoritie(String authority);

	void updateAuthoritie(Authorities authoritie);

	Authorities getAuthoritieId(int id);

}
