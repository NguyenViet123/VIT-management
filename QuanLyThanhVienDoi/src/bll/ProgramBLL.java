/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.ProgramDAL;
import entity.Program;
import java.util.ArrayList;
/**
 *
 * @author Viet_dz
 */
public class ProgramBLL {
    ProgramDAL prodal = new ProgramDAL();
    
    public boolean addProgram(Program mem){
        return prodal.addProgram(mem);
    }
    
    public boolean deleteProgram(String id){
        return prodal.deleteProgram(id);
    }
    
    public ArrayList<Program> getAllProgram(){
        return prodal.getAllPrograms();
    }
    

    
    public Program searchProgram(String id){
        return prodal.searchProgram(id);
    }
    
    public boolean updateProgram(Program mem){
        return prodal.updateProgram(mem);
    }
}
