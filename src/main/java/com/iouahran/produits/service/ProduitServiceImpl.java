package com.iouahran.produits.service;

import com.iouahran.produits.entities.Categorie;
import com.iouahran.produits.entities.Produit;
import com.iouahran.produits.entities.ProduitDTO;
import com.iouahran.produits.repos.ProduitRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitServiceImpl implements ProduitService {
    @Autowired
    ProduitRepository produitRepository;
   /* @Override
    public Produit saveProduit(Produit p) {return produitRepository.save(p);
    }*/
    @Override
    public Produit updateProduit(Produit p) {
        return produitRepository.save(p);
    }
    @Override
    public void deleteProduit(Produit p) {
        produitRepository.delete(p);
    }
    @Override
    public void deleteProduitById(Long id) {
        produitRepository.deleteById(id);
    }
    /*@Override
    public Produit getProduit(Long id) {
        return produitRepository.findById(id).get();
    }
    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }*/
    @Override
    public List<Produit> findByNomProduit(String nom) {
        return produitRepository.findByNomProduit(nom);
    }
    @Override
    public List<Produit> findByNomProduitContains(String nom) {
        return produitRepository.findByNomProduitContains(nom);
    }
    @Override
    public List<Produit> findByNomPrix(String nom, Double prix) {
        return produitRepository.findByNomPrix(nom, prix);
    }
    @Override
    public List<Produit> findByCategorie(Categorie categorie) {
        return produitRepository.findByCategorie(categorie);
    }
    @Override
    public List<Produit> findByCategorieIdCat(Long id) {
        return produitRepository.findByCategorieIdCat(id);
    }
    @Override
    public List<Produit> findByOrderByNomProduitAsc() {
        return produitRepository.findByOrderByNomProduitAsc();
    }
    @Override
    public List<Produit> trierProduitsNomsPrix() {
        return produitRepository.trierProduitsNomsPrix();
    }

   /* @Override
    public ProduitDTO convertEntityToDto(Produit produit) {
        ProduitDTO produitDTO = new ProduitDTO();
        produitDTO.setIdProduit(produit.getIdProduit());
        produitDTO.setNomProduit(produit.getNomProduit());
        produitDTO.setPrixProduit(produit.getPrixProduit());
        produitDTO.setDateCreation(produit.getDateCreation());
        produitDTO.setCategorie(produit.getCategorie());

        return produitDTO;*/

         /*return ProduitDTO.builder()
        .idProduit(produit.getIdProduit())
        .nomProduit(produit.getNomProduit())
        .prixProduit(produit.getPrixProduit())
        .dateCreation(p.getDateCreation())
        .categorie(produit.getCategorie())
        .build();
    }*/

    @Override
    public ProduitDTO saveProduit(Produit p) {
        return convertEntityToDto( produitRepository.save(p));
    }
    @Override
    public ProduitDTO getProduit(Long id) {
        return convertEntityToDto( produitRepository.findById(id).get());
    }
    @Override
    public List<ProduitDTO> getAllProduits() {

        return produitRepository.findAll().stream()
                .map(this::convertEntityToDto)
                        .collect(Collectors.toList());
        //OU BIEN
        /*List<Produit> prods = produitRepository.findAll();
        List<ProduitDTO> listprodDto = new ArrayList<>(prods.size());
        for (Produit p : prods)
        listprodDto.add(convertEntityToDto(p));
        return listprodDto;*/
    }
    @Autowired
    ModelMapper modelMapper;
    @Override
    public ProduitDTO convertEntityToDto(Produit produit) {
        /*ProduitDTO produitDTO = modelMapper.map(produit, ProduitDTO.class);*/
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ProduitDTO produitDTO = modelMapper.map(produit, ProduitDTO.class);
        return produitDTO;
    }
    @Override
    public Produit convertDtoToEntity(ProduitDTO produitDto) {
        Produit produit = new Produit();
        produit = modelMapper.map(produitDto, Produit.class);
        return produit;
    }
}
