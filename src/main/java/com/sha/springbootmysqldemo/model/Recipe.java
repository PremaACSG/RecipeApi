package com.sha.springbootmysqldemo.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="recipe")
@EntityListeners(AuditingEntityListener.class)
public class Recipe {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto-increment
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "ingredients")
    private String ingredients;
    
    @Column(name = "instructions")
    private String instructions;
    
    @Column(name = "serves")
    private int serves;
    
    @Column(name = "is_veg")
    private int isVeg;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
          return id;
      }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
          this.id = id;
      }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
          return name;
      }

    /**
     * Sets name.
     *
     * @param name
     */
    public void setname(String name) {
          this.name = name;
      }

    /**
     * Gets instructions.
     *
     * @return instructions
     */
    public String getInstructions() {
          return instructions;
      }

    /**
     * Sets Instructions.
     *
     * @param instructions
     */
    public void setInstructions(String instructions) {
          this.instructions = instructions;
      }

    /**
     * Gets ingredients.
     *
     * @return the ingredients
     */
    public String getIngredients() {
          return ingredients;
      }

    /**
     * Sets ingredients.
     *
     * @param ingredients
     */
    public void setIngredients(String ingredients) {
          this.ingredients = ingredients;
      }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public LocalDateTime getCreatedAt() {
          return createdAt;
      }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(LocalDateTime createdAt) {
          this.createdAt = createdAt;
      }

    /**
     * Gets the serve quantity.
     *
     * @return the serve quantity
     */
    public int getServes() {
          return serves;
      }

    /**
     * Sets serve quantity.
     *
     * @param serves
     */
    public void setServes(int serves) {
          this.serves = serves;
      }

    /**
     * Gets isVeg value.
     *
     * @return isVeg
     */
    public int getIsVeg() {
          return isVeg;
      }

    /**
     * Sets isVeg Value.
     *
     * @param isVeg
     */
    public void setIsVeg(int isVeg) {
          this.isVeg = isVeg;
      }
    
      @Override
      public String toString() {
          return "Recipe{" +
                  "id=" + id +
                  ", name='" + name + '\'' +
                  ", instructions='" + instructions + '\'' +
                  ", ingredients='" + ingredients + '\'' +
                  ", createdAt=" + createdAt +
                  ", isVeg='" + isVeg + '\'' +
                  ", serves=" + serves +
                  '}';
      }
}
