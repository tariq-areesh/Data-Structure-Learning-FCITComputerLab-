
package fcitcomputerlab;

public class Device {
    protected String company;
    protected String device_code;
    
    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public Device() {
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public Device(String company, String device_code) {
        this.company = company;
        this.device_code = device_code;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public void setCompany(String company) {
        this.company = company;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public String getCompany() {
        return company;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------

    public void setDevice_code(String device_code) {
        this.device_code = device_code;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------

    public String getDevice_code() {
        return device_code;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------


    @Override
    public String toString() {
        return "Device{" + "company=" + company + ", device_code=" + device_code + '}';
    }
    
}
