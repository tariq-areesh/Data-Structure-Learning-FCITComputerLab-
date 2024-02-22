
package fcitcomputerlab;

public class Printer extends Device{
    private String type;
    private boolean isColor;
    
    //----------------------------------------------------------------------------------------------------------------------------------------------------

    public Printer(String company, String type, boolean isColor, String Code) {
        super(company, Code);
        this.type = type;
        this.isColor = isColor;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public void setType(String type) {
        this.type = type;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------

    public String getType() {
        return type;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public void setIsColor(boolean isColor) {
        this.isColor = isColor;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public boolean IsColor() {
        return isColor;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Company :" + company + " Color Type: " + (isColor ? "Colored  ":"Black&white  ") + "Printer Type :" + type;
    }
    
}
