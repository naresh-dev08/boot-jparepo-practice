package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.offers.Offers;
import com.nt.entity.prod.Product;
import com.nt.repository.offers.IOffersRepository;
import com.nt.repository.prod.IProductReposity;

@Service("multiDBsService")
public class MultiDBsInteractionServiceMgmtImpl implements IMultiDBsInteractionServiceMgmt {

	@Autowired
	IProductReposity prodRepo;
	
	@Autowired
	IOffersRepository offerRepo;
	
	@Override
	public String registerProducts(List<Product> list) {
		prodRepo.saveAll(list);
		return list.size()+" Products are saved";
	}

	@Override
	public String registerOffers(List<Offers> list) {
		offerRepo.saveAll(list);
		return list.size()+" Offers are saved";
	}

	@Override
	public List<Product> getAllProcuts() {
		return prodRepo.findAll();
	}

	@Override
	public List<Offers> getAllOffers() {
		return offerRepo.findAll();
	}

}
