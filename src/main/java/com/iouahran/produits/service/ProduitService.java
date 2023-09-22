package com.iouahran.produits.service;

import com.iouahran.produits.entities.Categorie;
import com.iouahran.produits.entities.Produit;
import com.iouahran.produits.entities.ProduitDTO;

import java.util.List;

public interface ProduitService {
   // Produit saveProduit(Produit p);
    Produit updateProduit(Produit p);
    void deleteProduit(Produit p);
    void deleteProduitById(Long id);
   // Produit getProduit(Long id);
   // List<Produit> getAllProduits();
    List<Produit> findByNomProduit(String nom);
    List<Produit> findByNomProduitContains(String nom);
    List<Produit> findByNomPrix (String nom, Double prix);
    List<Produit> findByCategorie (Categorie categorie);
    List<Produit> findByCategorieIdCat(Long id);
    List<Produit> findByOrderByNomProduitAsc();
    List<Produit> trierProduitsNomsPrix();

    ProduitDTO convertEntityToDto (Produit produit);
    ProduitDTO saveProduit(Produit p);
    ProduitDTO getProduit(Long id);
    List<ProduitDTO> getAllProduits();
    Produit convertDtoToEntity(ProduitDTO produitDto);
}