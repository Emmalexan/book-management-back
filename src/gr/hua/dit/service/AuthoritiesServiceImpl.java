package gr.hua.dit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.AuthoritiesDAO;
import gr.hua.dit.dao.TextBookDAO;
import gr.hua.dit.entity.Authorities;
import gr.hua.dit.entity.TextBook;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {
	
	@Autowired
	private AuthoritiesDAO authoritieDAO;
	
		


@Override
@Transactional
public List<Authorities> getAuthorities() {
	// TODO Auto-generated method stub
	return authoritieDAO.getAuthorities();
}



@Override
@Transactional
public void saveAuthoritie(Authorities authoritie) {
	
	authoritieDAO.saveAuthoritie(authoritie);
}

@Override
@Transactional
public Authorities getAuthoritie(String authority) {
	// TODO Auto-generated method stub
	return authoritieDAO.getAuthoritie(authority);
}

@Override
@Transactional
public Authorities getAuthoritieId(int id) {
	// TODO Auto-generated method stub
	return authoritieDAO.getAuthoritieId(id);
}
@Override
@Transactional
public void deleteAuthoritie(String authority) {
	// TODO Auto-generated method stub
	authoritieDAO.deleteAuthoritie(authority);
}

@Override
@Transactional
public void updateAuthoritie(Authorities authoritie) {
	authoritieDAO.updateAuthoritie(authoritie);
	
}

}
