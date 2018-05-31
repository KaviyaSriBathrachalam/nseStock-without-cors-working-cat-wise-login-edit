package com.kgisl.strnsestock.demostock;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("portfolioService")
public class PortfolioServiceImp implements PortfolioService {

    @Autowired
    private PortfolioRepository portfoilioRepository;

    @Override
    public List<Portfolio> getAll() {
        return portfoilioRepository.findAll();
    }
 
    // @Override
    // public Portfolio find(long id) {
    //     return portfolioRepository.findOne(id);
    // }

    @Override
    public void delete(Long pId) {
        portfoilioRepository.delete(pId);
    }

    @Override
	public void update(Portfolio portfolio,Long pId) {
        portfolio.setId(pId);
        portfoilioRepository.saveAndFlush(portfolio);      
    }

    
    @Override
    public List<Portfolio> save(List<Portfolio>  p) {
       
        for ( Portfolio obj:p) {

            portfoilioRepository.saveAndFlush(obj);
        }		
        return portfoilioRepository.findAll();
    }
}