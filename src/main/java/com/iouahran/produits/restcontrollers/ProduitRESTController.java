package com.iouahran.produits.restcontrollers;

import com.iouahran.produits.entities.Produit;
import com.iouahran.produits.entities.ProduitDTO;
import com.iouahran.produits.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ProduitRESTController {

    @Autowired
    ProduitService produitService;

  /*  @RequestMapping(method = RequestMethod.GET)
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Produit getProduitById(@PathVariable("id") Long id) {
        return produitService.getProduit(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.saveProduit(produit);
    }*/

    @RequestMapping(method = RequestMethod.PUT)
    public Produit updateProduit(@RequestBody Produit produit) {
        return produitService.updateProduit(produit);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteProduit(@PathVariable("id") Long id)
    {
        produitService.deleteProduitById(id);
    }

    @RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
    public List<Produit> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
        return produitService.findByCategorieIdCat(idCat);
    }
    @RequestMapping(value="/trieNomProduitAsc", method = RequestMethod.GET)
    public List<Produit> findByOrderByNomProduitAsc() {
        return produitService.findByOrderByNomProduitAsc();
    }

    @RequestMapping(value="/trieNomPrix", method = RequestMethod.GET)
    public List<Produit> trierProduitsNomsPrix() {
        return produitService.trierProduitsNomsPrix();
    }

    @RequestMapping(value="/findByNomProduitContains/{nomProduit}", method = RequestMethod.GET)
    public List<Produit> findByNomProduitContains(@PathVariable("nomProduit") String nom) {
        return produitService.findByNomProduitContains(nom);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ProduitDTO> getAllProduits() {
        return produitService.getAllProduits();
    }
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ProduitDTO getProduitById(@PathVariable("id") Long id) {
        return produitService.getProduit(id);
    }
}
