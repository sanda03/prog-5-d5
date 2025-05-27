#  Machine à Café Java

##  Description

Cette application Java simule le fonctionnement d'une machine à café, en respectant les principes du **Clean Code**. Elle permet à un utilisateur d’ajouter de l’argent, de sélectionner un type de café, et de recevoir le café si toutes les conditions sont réunies. Elle inclut également une **gestion complète des erreurs** 

---

##  Fonctionnalités

###  Paiement
- L’utilisateur peut insérer de l'argent
- Vérification du solde avant toute commande

###  Sélection du café
- L’utilisateur choisit un type de café
- Vérification de :
  - L'existence du type de café
  - La disponibilité du stock
  - L'eau disponible
  - L'alimentation électrique
  - L'absence de maintenance

###  Livraison
- Si toutes les conditions sont remplies, le café est préparé
- Décrémentation automatique du stock



---

##  Structure du projet

### 1. `Payer.java`
Gère le solde.

| Méthode              | Rôle                                 |
|----------------------|--------------------------------------                   |
| `payer(double)`      | Déduit de l'argent                    |             |
| `estSoldeSuffisants(double)` | Vérifie les fonds suffisants   

---

### 2. `Cafe.java`
Représente un type de café.

| Attribut     | Description                     |
|--------------|---------------------------------|
| `nom`        | Nom du café (ex: Latte)         |
| `prix`       | Prix du café                    |
| `quantite`   | Quantité en stock               |

| Méthode               | Rôle                              |
|-----------------------|-----------------------------------|
| `estDisponible()`     | Vérifie la disponibilité          |                 |

---

### 3. `MachineACafe.java`
Classe principale qui orchestre la machine.

| Attribut            | Description                          |
|---------------------|--------------------------------------|
| `cafes`             | Liste des cafés disponibles          |
| `eauDisponible`     | Eau disponible ou non                |
| `sousTension`       | État de l’alimentation électrique    |

| Méthode                  | Rôle                                    |
|--------------------------|-----------------------------------------|
| `selectionnerCafe(String)` | Sélectionne un café                   |
| `preparerCafe(String)`     | Prépare et sert le café               |
| `estSousTension()`         | Vérifie si la machine est sous tension|

---

##  Gestion des erreurs

| Code | Type d’erreur               | Description technique                                     |
|------|-----------------------------|-----------------------------------------------------------|
| c1   | Fonds insuffisants          | L’argent inséré est inférieur au prix du café             |
| c2   | Stock vide                  | Quantité du café sélectionné est à 0                      |
| c3   | Panne de courant            | `machine.sousTension == false`                            |
| c4   | Réservoir vide              | `machine.eauDisponible == false`                          |
| c5   | Type de café invalide       | Type inexistant dans la liste                             |
| c6   | Maintenance en cours        | Machine en mode maintenance (`enMaintenance == true`)     |
| c7   | Accès refusé                | Utilisateur non autorisé (badge ou permissions)           |

---


