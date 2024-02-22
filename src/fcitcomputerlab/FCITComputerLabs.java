
package fcitcomputerlab;

import java.io.*;
import java.util.*;

public class FCITComputerLabs {
     static ArrayList<Device> AllDevices = new ArrayList<>();
    
    public static void main(String[] args) throws FileNotFoundException {
        
        File fcitInput_File = new File("fcitInput.txt");
        File fcitOutputLab_File = new File("fcitOutPutLab.txt");
        File fcitReportLab_File = new File("fcitReportLab.txt");
        if(!fcitInput_File.exists()) {
            System.out.println("fcitInput file is not found");
            System.exit(0);
        }
        if(fcitOutputLab_File.exists()) {
            System.out.println("fcitOutputLab file already exists");
            System.exit(0);
        }
        if(fcitReportLab_File.exists()) {
            System.out.println("fcitReportLab file already exists");
            System.exit(0);
        }
        Scanner fcitInput = new Scanner(fcitInput_File);
        PrintWriter fcitOutPutLab = new PrintWriter(fcitOutputLab_File);
        //PrintWriter fcitReportLab = new PrintWriter(fcitReportLab_File);
        
        readAndWriteFcitLab_files(fcitInput, fcitOutPutLab);
        
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public static void readAndWriteFcitLab_files(Scanner in, PrintWriter fcitOutPutLab) {
        fcitOutPutLab.println("Welcome to the FCIT Lab  System.\nToday Date is " + getDate() + "\n"); // method getDate()
        
        while(true) {
            String command = in.next();
            String installError = null;
            if(command.equalsIgnoreCase("Add_Computer")) {
                Device computer = new Computer(in.next(), in.nextDouble(), in.next(), in.next());
                AllDevices.add(computer);
                printFcitOutPutLab_commands(fcitOutPutLab, command, null, (Computer) computer, null, null, null);
            }
            else if(command.equalsIgnoreCase("Add_Printer")) {
                Device printer = new Printer(in.next(), in.next(), in.nextBoolean(), in.next());
                AllDevices.add(printer);
                printFcitOutPutLab_commands(fcitOutPutLab, command, null, (Computer) null, (Printer) printer, null, null);
            }
            else if(command.equalsIgnoreCase("Add_Mouse")) {
                Device mouse = new Mouse(in.next(), in.next(), in.next());
                AllDevices.add(mouse);
                printFcitOutPutLab_commands(fcitOutPutLab, command, null, null, null, (Mouse) mouse, null);
            }
            else if(command.equalsIgnoreCase("Add_Software")) {
                Device software = new Software(null, in.next(), in.nextDouble(), in.next());
                AllDevices.add(software);
                printFcitOutPutLab_commands(fcitOutPutLab, command, null, null, null, null, (Software) software);
            }
            else if(command.equalsIgnoreCase("Install_SW")) {
                Computer computer = (Computer) AllDevices.get(searchDeviceIndex(in.next()));
                Software software = (Software) AllDevices.get(searchDeviceIndex(in.next()));
                boolean isAvailable = searchSoftwareAvailability(computer.getSoftware(), software);
                if(isAvailable || computer.getTotalSoftware() >= 5) {
                    if(computer.getTotalSoftware() >= 5) {
                        installError = "computer has 5 softwares";
                    }
                    else {
                        installError = "computer already has the software";
                    }
                }
                else {
                    computer.getSoftware().add(software);
                }
                printFcitOutPutLab_commands(fcitOutPutLab, command, installError, computer, null, null, software);
            }
            
            else if(command.equalsIgnoreCase("Install_printer")) {
                Computer computer = (Computer) AllDevices.get(searchDeviceIndex(in.next()));
                Printer printer = (Printer) AllDevices.get(searchDeviceIndex(in.next()));
                
                if(computer.getPrinter() != null) {
                    installError = "computer is already attached to a printer";
                }
                else {
                    computer.setPrinter(printer); 
                }
                printFcitOutPutLab_commands(fcitOutPutLab, command, installError, computer, printer, null, null);
            }
            
            else if(command.equalsIgnoreCase("Install_mouse")) {
                Computer computer = (Computer) AllDevices.get(searchDeviceIndex(in.next()));
                Mouse mouse = (Mouse) AllDevices.get(searchDeviceIndex(in.next()));
                
                if(computer.getMouse() != null) {
                    installError = "computer is already attached to a mouse";
                }
                else {
                    computer.setMouse(mouse); 
                }
                printFcitOutPutLab_commands(fcitOutPutLab, command, installError, computer, null, mouse, null);
            }
            
            else if(command.equalsIgnoreCase("UnInstall_SW")) {
                Computer computer = (Computer) AllDevices.get(searchDeviceIndex(in.next()));
                Software software = (Software) AllDevices.get(searchDeviceIndex(in.next()));
                 boolean isAvailable = searchSoftwareAvailability(computer.getSoftware(), software);
                if(!isAvailable) {
                    installError = "there is no such a software in this computer";
                }
                else {
                    computer.getSoftware().remove(software);
                }
                printFcitOutPutLab_commands(fcitOutPutLab, command, installError, computer, null, null, software);
            }
            
            else if(command.equalsIgnoreCase("List_All_Computer_Configuration")) {
                
            }
            else if(command.equalsIgnoreCase("List_Computer_With_SW")) {
                in.next();
            }
            else if(command.equalsIgnoreCase("List_Computer_Speed_>")) {
                in.nextDouble();
            }
            else if(command.equalsIgnoreCase("Compare_Computer_Speed")) {
                in.next(); in.next();
            }
            else if(command.equalsIgnoreCase("Quit")) 
                break;
            
        }
        fcitOutPutLab.close();
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public static Date getDate() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+3"));
        Calendar date = Calendar.getInstance(TimeZone.getTimeZone(""));
        return date.getTime();
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public static void printFcitOutPutLab_commands(PrintWriter fcitOutPutLab, String command, String Error, Computer computer, Printer printer, Mouse mouse, Software software) {
        String installComputerInfo = (command.matches("Install.*") || command.matches("UnInstall.*")) ?
                "The computer  Company : " + computer.getCompany() + "  Model: " + computer.getModelName() : null;
        
        fcitOutPutLab.println("**************************************************************************************************************\nCommand: " + command);
        fcitOutPutLab.print(command.matches("Add.*") ? "\n\n":"\n");
        
        if(command.equalsIgnoreCase("Add_Computer")) {
                fcitOutPutLab.println("Computer Details \n" + computer.toString());
                fcitOutPutLab.println("""
                                      -- Following Softwares are Installed in the Machine ---
                                       No Software has been installed
                                      --- Following  Peripheral are  attached in the Machine ---
                                       No Pripheral has been attached
                                      """);
            }
        
         else if(command.equalsIgnoreCase("Add_Printer")) {
                fcitOutPutLab.println("Printer Details \n \n" + printer.toString() + "\n");
            }
         
         else if(command.equalsIgnoreCase("Add_Mouse")) {
                fcitOutPutLab.println("Mouse Details \n\n" + mouse.toString() + "\n");
            }
         
         else if(command.equalsIgnoreCase("Add_Software")) {
                fcitOutPutLab.println("Software Details \n\n" + software.toString() + "\n");
            }
         
         else if(command.equalsIgnoreCase("Install_SW")) {
                if(Error != null) {
                    fcitOutPutLab.println(installComputerInfo);
                    
                    if(Error.equals("computer has 5 softwares")) 
                        fcitOutPutLab.println("has 5 S/W installed.. You can not install any S/W");
                    else
                        fcitOutPutLab.println("has already S/W " + software.getName() + "  installed..");
                }
                else 
                    fcitOutPutLab.println("The S/W " + software.getName() + "  has been installed in the " + installComputerInfo);
            }
            
         else if(command.equalsIgnoreCase("Install_printer")) {
                if(Error != null) 
                    fcitOutPutLab.println(installComputerInfo + "\nhas already attached to Printer " + printer.getCompany() + "  Printer Type :" + printer.getType());
                else 
                    fcitOutPutLab.println("The Printer " + printer.getCompany() + "  Printer Type :" + printer.getType() + "  has been attached to the " + installComputerInfo);
            }
            
         else if(command.equalsIgnoreCase("Install_mouse")) {
                if(Error != null) 
                    fcitOutPutLab.println(installComputerInfo + "\nhas already attached to Mouse " + mouse.getCompany() + "  " + mouse.getType());
                else
                    fcitOutPutLab.println("The Mouse " + mouse.getCompany() + "  " + mouse.getType() +"  has been attached to the " + installComputerInfo);
            }
         
         else if(command.equalsIgnoreCase("UnInstall_SW")) {
                if(Error != null) 
                    fcitOutPutLab.print("The Software : " + software.getName() + "  is not installed \nin " + installComputerInfo);
                else
                    fcitOutPutLab.println("The S/W " + software.getName() + "  has been uninstalled from the " + installComputerInfo);
            }
        
        fcitOutPutLab.print(command.matches("Add.*") ? " has been added to the FCIT Lab. Database.\n\n":"");
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public static int searchDeviceIndex(String code) {
        for(Device device: AllDevices) {
            if(device.device_code.equalsIgnoreCase(code)) {
                return AllDevices.indexOf(device);
            }
        }
        return 0; // *****check later*****
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public static boolean searchSoftwareAvailability(ArrayList<Software> softwares, Software software) {
        for(Software s: softwares) {
            if(software.getDevice_code().equalsIgnoreCase(s.getDevice_code())) {
                return true;
            }
        }
        return false;
    }
}
