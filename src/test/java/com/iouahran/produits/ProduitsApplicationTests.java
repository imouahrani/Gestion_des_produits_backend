package com.iouahran.produits;

import com.iouahran.produits.entities.Produit;
import com.iouahran.produits.repos.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class ProduitsApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;
	@Test
	public void testCreateProduit() {
		Produit prod = new Produit("PC Dell",2200.500,new Date());
		produitRepository.save(prod);
	}
	@Test
	public void testFindProduit()
	{
		Produit p = produitRepository.findById(4L).get();
		System.out.println(p);
	}
	@Test
	public void testUpdateProduit()
	{
		Produit p = produitRepository.findById(2L).get();
		p.setPrixProduit(1000.0);
		produitRepository.save(p);
	}
	@Test
	public void testDeleteProduit()
	{
		produitRepository.deleteById(2L);;
	}

	@Test
	public void testListerTousProduits()
	{
		List<Produit> prods = produitRepository.findAll();
		for (Produit p : prods)
		{
			System.out.println(p);
		}
	}
	@Test
	public void testFindByNomProduit()
	{
		List<Produit> prods = produitRepository.findByNomProduit("PC Dell");
		for (Produit p : prods)
		{
			System.out.println(p);
		}
	}
	@Test
	public void testFindByNomProduitContains ()
	{
		List<Produit> prods=produitRepository.findByNomProduitContains("iphone");
		for (Produit p : prods)
		{
			System.out.println(p);
		}
	}
	@Test
	public void testfindByNomPrix()
	{
		List<Produit> prods = produitRepository.findByNomPrix("PC Dell", 2200.5);
		for (Produit p : prods)
		{
			System.out.println(p);
		}
	}
	@Test
	public void testTrierProduitsNomsPrix()
	{
		List<Produit> prods = produitRepository.trierProduitsNomsPrix();
		for (Produit p : prods)
		{
			System.out.println("Nom produit : "+p.getNomProduit() +" Prix produit : "+p.getPrixProduit());

		}
	}
	@Test
	public void findByCategorieIdCat()
	{
		List<Produit> prods = produitRepository.findByCategorieIdCat(2L);
		for (Produit p : prods)
		{
			System.out.println(p);
		}
	}
	@Test
	public void testfindByOrderByNomProduitAsc()
	{
		List<Produit> prods =
				produitRepository.findByOrderByNomProduitAsc();
		for (Produit p : prods)
		{
			System.out.println(p.getNomProduit());
		}
	}
}
