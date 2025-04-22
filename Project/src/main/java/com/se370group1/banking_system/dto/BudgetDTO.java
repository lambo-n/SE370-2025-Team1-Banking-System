package com.se370group1.banking_system.dto;

import com.se370group1.banking_system.model.Budget;

public class BudgetDTO {
    private String budgetID;
    
    private String connectedUserID;
    private int foodPercentage;
    private int rentPercentage;
    private int entertainmentPercentage;
    private int transportationPercentage;

    public BudgetDTO(String budgetID, String connectedUserID, int foodPercentage, int rentPercentage, int entertainmentPercentage, int transportationPercentage) {
        this.budgetID = budgetID;
        this.connectedUserID = connectedUserID;
        this.foodPercentage = foodPercentage;
        this.rentPercentage = rentPercentage;
        this.entertainmentPercentage = entertainmentPercentage;
        this.transportationPercentage = transportationPercentage;
    }

    public Budget toDomainModel() {
        Budget budget = new Budget(this.budgetID, this.connectedUserID, this.foodPercentage, this.rentPercentage, this.entertainmentPercentage, this.transportationPercentage);
        return budget;
    }
    public String getBudgetID() { return budgetID; }
    public void setBudgetID(String budgetID) { this.budgetID = budgetID; }

    public String getConnectedUserID() { return connectedUserID; }
    public void setConnectedUserID(String connectedUserID) { this.connectedUserID = connectedUserID; }

    public int getFoodPercentage() { return foodPercentage; }
    public void setFoodPercentage(int foodPercentage) { this.foodPercentage = foodPercentage; }

    public int getRentPercentage() { return rentPercentage; }
    public void setRentPercentage(int rentPercentage) { this.rentPercentage = rentPercentage; }

    public int getEntertainmentPercentage() { return entertainmentPercentage; }
    public void setEntertainmentPercentage(int entertainmentPercentage) { this.entertainmentPercentage = entertainmentPercentage; }

    public int getTransportationPercentage() { return transportationPercentage; }
    public void setTransportationPercentage(int transportationPercentage) { this.transportationPercentage = transportationPercentage; }    
}
