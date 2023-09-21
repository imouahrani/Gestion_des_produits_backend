package com.iouahran.produits.repos;

import com.iouahran.produits.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import com.iouahran.produits.entities.Produit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    List<Produit> findByNomProduit(String nom);
    List<Produit> findByNomProduitContains(String nom);

    /*@Query("select p from Produit p where p.nomProduit like %?1 and p.prixProduit > ?2")
    List<Produit> findByNomPrix (String nom, Double prix);*/

    @Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit > :prix")
    List<Produit> findByNomPrix (@Param("nom") String nom, @Param("prix") Double prix);

    @Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
    List<Produit> trierProduitsNomsPrix ();


    List<Produit> findByOrderByNomProduitAsc();

    List<Produit> findByCategorieIdCat(Long id);

    List<Produit> findByCategorie(Categorie categorie);


}