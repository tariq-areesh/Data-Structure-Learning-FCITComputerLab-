
package fcitcomputerlab;

import java.util.ArrayList;

public class Computer  extends Device implements Comparable<Computer> {
    private double speed;
    private String modelName;
    private ArrayList<Software> software = new ArrayList<>();
    private Mouse mouse;
    private Printer printer;
    private int totalSoftware;
    
    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public Computer(String company, double speed,  String modelName, String Code) {
        super(company, Code);
        this.modelName = modelName;
        this.speed = speed;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------

    public double getSpeed() {
        return speed;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------

    public String getModelName() {
        return modelName;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------

    public void setSoftware(Software software) {
        this.software.add(software);
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------

    public ArrayList<Software> getSoftware() {
        return software;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------

    public Mouse getMouse() {
        return mouse;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------

    public Printer getPrinter() {
        return printer;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------

    public int getTotalSoftware() {
        return totalSoftware = software.size();
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Company :" + company + "  Model: " + modelName + "  Speed: " + speed + " GHz ";
    }
    
    //----------------------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public int compareTo(Computer c1) {
            
        if(getSpeed() > c1.getSpeed()) 
            return 1;
        else if(getSpeed() < c1.getSpeed())
            return -1;
        else
            return 0;
    }
    
    

    
}
