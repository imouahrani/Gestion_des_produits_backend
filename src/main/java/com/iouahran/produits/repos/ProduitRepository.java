package com.iouahran.produits.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.iouahran.produits.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}