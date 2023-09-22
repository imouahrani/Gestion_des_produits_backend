package com.iouahran.produits.entities;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProduitDTO {
    private Long idProduit;
    private String nomProduit;
    private Double prixProduit;
    private Date dateCreation;
    private Categorie categorie;
    private String nomCat;

}
