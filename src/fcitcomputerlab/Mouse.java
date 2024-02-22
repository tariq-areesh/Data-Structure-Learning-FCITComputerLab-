
package fcitcomputerlab;

public class Mouse extends Device{
    private String type;
    
    //----------------------------------------------------------------------------------------------------------------------------------------------------

    public Mouse(String company, String type, String device_code) {
        super(company, device_code);
        this.type = type;
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
    @Override
    public String toString() {
        return "Company :" + company + " Mouse Type: " + type;
    }
    

}
